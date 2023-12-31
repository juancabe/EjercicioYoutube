package ejercicioyoutube;

/**
 *
 * @author juan calzada bernal
 */
public class Video {

    static private float CPM = 1.7f;

    public static float getCPM() {
        return CPM;
    }

    public static void setCPM(float aCPM) {
        CPM = aCPM;
    }
    private String tituloVideo;
    private int segundos;
    private String tiempo;
    private int visuVideo;
    private String idVideoUrl;
    private float videoEarn;
    private int videoNum;

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public Video(int numVideo) {

        tituloVideo = ParseErrorSelect.getString(true, true,
                1, 70, "Introduzca el titulo: ");
        segundos = ParseErrorSelect.getInt(true, false,
                0, 0, "Introduza la duracion de su video en segundos: ");
        tiempo = secondsToTime(segundos);
        visuVideo = ParseErrorSelect.getInt(true, false,
                0, 0, "Introduza las visualizaciones de su video: ");
        idVideoUrl = getVideoId();
        videoEarn = visuVideo / 1000 * CPM;
        videoNum = numVideo + 1;

    }

    private String secondsToTime(int seconds) {

        int horas = seconds / 3600;
        int minutos = (seconds % 3600) / 60;
        int segundos2 = (seconds & 60);

        String time = String.format("%02d:%02d:%02d", horas, minutos, segundos2);

        return time;
    }

    private String getVideoId() {
        boolean exceptionDetected;
        String urlInput = "";
        do {
            try {
                exceptionDetected = false;
                urlInput = ParseErrorSelect.getString(true, true, 43, 43,
                        "Introduzca la url del video: ");
                urlInput = urlInput.split("v=")[1];
                if (urlInput.length() <= 0) {
                    System.out.println("Url inválida.");
                    exceptionDetected = true;
                }
            } catch (Exception e) {
                System.err.println("Error en la lectura del URL, inténtelo de nuevo.");
                exceptionDetected = true;
            }
        } while (exceptionDetected);

        return urlInput;
    }

    public String getTituloVideo() {
        return tituloVideo;
    }

    public void setTituloVideo(String tituloVideo) {
        this.tituloVideo = tituloVideo;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getVisuVideo() {
        return visuVideo;
    }

    public void setVisuVideo(int visuVideo) {
        this.visuVideo = visuVideo;
    }

    public String getIdVideoUrl() {
        return idVideoUrl;
    }

    public void setIdVideoUrl(String idVideoUrl) {
        this.idVideoUrl = idVideoUrl;
    }

    public float getVideoEarn() {
        return videoEarn;
    }

    public void setVideoEarn(float videoEarn) {
        this.videoEarn = videoEarn;
    }

}
