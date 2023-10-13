/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioyoutube;

/**
 *
 * @author juan
 */
public class Canal {

    private int videoNumLen;
    private int visuVideoLen;
    private int videoTiempoLen;
    private int videoIdLen;
    private int videoEarnLen;

    private String nombreCanal = "";
    private int numVideos = 0;
    private Video[] arrayVideos = null;

    public Canal() {
        this.numVideos = ParseErrorSelect.getInt(true, false,
                0, 0, "Introduzca el numero de videos de su canal: ");
        arrayVideos = new Video[numVideos];
        nombreCanal = ParseErrorSelect.getString(true, false,
                0, 0, "Introduzca el nombre de su canal: ");
    }

    private void assignVariableLen() {

        videoNumLen = 0;
        visuVideoLen = 0;
        videoTiempoLen = 0;
        videoIdLen = 0;
        videoEarnLen = 0;

        for (Video video : arrayVideos) {

            if (Integer.toString(video.getVideoNum()).length() > videoNumLen) {
                videoNumLen = Integer.toString(video.getVideoNum()).length();
            }
            if (Integer.toString(video.getVisuVideo()).length() > visuVideoLen) {
                visuVideoLen = Integer.toString(video.getVisuVideo()).length();
            }

            if (video.getTiempo().length() > videoTiempoLen) {
                videoTiempoLen = video.getTiempo().length();
            }
            if (video.getIdVideoUrl().length() > videoIdLen) {
                videoIdLen = video.getIdVideoUrl().length();
            }
            if (Float.toString(video.getVideoEarn()).length() > videoEarnLen) {
                videoEarnLen = Float.toString(video.getVideoEarn()).length();
            }
        }
        if (visuVideoLen < "Visualizaciones".length()) {
            visuVideoLen = "Visualizaciones".length();
        }
        if (videoTiempoLen < "Duración".length()) {
            videoTiempoLen = "Duración".length();
        }
        if (videoIdLen < "Id video URL".length()) {
            videoIdLen = "Id video URL".length();
        }
        if (videoEarnLen < "   Ingresos previstos".length()) {
            videoEarnLen = "   Ingresos previstos".length();
        }

    }

    public void loadCanal() {
        for (int i = 0; i < arrayVideos.length; i++) {
            arrayVideos[i] = new Video(i);
        }
    }

    String getCanalString() {

        this.assignVariableLen();

        float ingresosTotales = 0f;

        String lineaEstandar = String.format("| Video %" + videoNumLen + "d | %" + visuVideoLen + "d | %" + videoTiempoLen + "s | %" + videoIdLen + "s | %" + videoEarnLen + ".2f |", 1, 1, "10:10:10", "Sagg08DrO5U", 1.1);
        int longLinea = lineaEstandar.length();
        String separadorLinea = "|" + "-".repeat(longLinea - 2) + "|\n";
        String canalString = separadorLinea;
        canalString += "| Analisis preliminar del canal: " + nombreCanal + " ".repeat(longLinea - ("| Analisis preliminar del canal: " + nombreCanal).length() - 1) + "|\n";
        canalString += separadorLinea;
        canalString += "| Video " + " ".repeat(videoNumLen) + " | " + " ".repeat(visuVideoLen - "Visualizaciones".length()) + "Visualizaciones | " + " ".repeat(videoTiempoLen - "Duracion".length()) + "Duracion | " + " ".repeat(videoIdLen - "Id video URL".length()) + "Id video URL | " + " ".repeat(videoEarnLen - "Ingresos previstos".length()) + "Ingresos previstos |\n";
        canalString += separadorLinea;

        for (Video video : arrayVideos) {

            canalString += String.format("| Video %" + videoNumLen + "d | %" + visuVideoLen + "d | %" + videoTiempoLen + "s | %" + videoIdLen + "s | %" + videoEarnLen + ".2f |\n", video.getVideoNum(), video.getVisuVideo(), video.getTiempo(), video.getIdVideoUrl(), video.getVideoEarn());
            ingresosTotales += video.getVideoEarn();
        }

        canalString += separadorLinea;
        canalString += "| Ingresos totales del canal: " + " ".repeat(longLinea - "| Ingresos totales del canal: ".length() - Float.toString(ingresosTotales).length() - 2) + ingresosTotales + " |\n";
        canalString += "| Ingresos medios por video: " + " ".repeat(longLinea - "| Ingresos medios por video: ".length() - Float.toString(ingresosTotales / numVideos).length() - 2) + ingresosTotales / numVideos + " |\n";
        canalString += separadorLinea;

        return canalString;
    }

}
