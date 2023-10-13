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

    private String nombreCanal;
    private int numVideos;
    private Video[] arrayVideos;

    public Canal() {
        this.numVideos = ParseErrorSelect.getInt(true, false,
                0, 0, "Introduzca el numero de videos de su canal: ");
        arrayVideos = new Video[numVideos];
        nombreCanal = ParseErrorSelect.getString(true, false,
                0, 0, "Introduzca el nombre de su canal: ");
    }

    private void assignVariableLen(){
        
        videoNumLen = 0;
        visuVideoLen = 0;
        videoTiempoLen = 0;
        videoIdLen = 0;
        videoEarnLen = 0;
        
        for(Video video: arrayVideos){
            
            if(Integer.toString(video.getVideoNum()).length() > videoNumLen){
                videoNumLen = Integer.toString(video.getVideoNum()).length();
            }
            if(Integer.toString(video.getVisuVideo()).length() > visuVideoLen){
                visuVideoLen = Integer.toString(video.getVisuVideo()).length();
            }
            
            if(video.getTiempo().length() > videoTiempoLen){
                videoTiempoLen = video.getTiempo().length();
            }
            if(video.getIdVideoUrl().length() > videoIdLen){
                videoIdLen = video.getIdVideoUrl().length();
            }
            if(Float.toString(video.getVideoEarn()).length() > videoEarnLen){
                videoEarnLen = Float.toString(video.getVideoEarn()).length();                
            }
        }
        if(visuVideoLen < "Visualizaciones".length()){
            visuVideoLen = "Visualizaciones".length();
        }
        if(videoTiempoLen < "Duración".length()){
            videoTiempoLen = "Duración".length();
        }
        if(videoIdLen < "Id video URL".length()){
            videoIdLen = "Id video URL".length();
        }
        if(videoEarnLen < "   Ingresos previstos".length()){
            videoEarnLen = "   Ingresos previstos".length();
        }
        
        
    }
    
    public void loadCanal() {
        for (int i = 0; i < arrayVideos.length; i++) {
            arrayVideos[i] = new Video(i, true);
        }
    }

    String getCanalString() {
        
        /*
        
       | Video %{videoNumLen}{videoNum} | %{visuVideoLen}{visuVideo} | %{videoTiempoLen}{videoTiempo} | %{videoEarnLen}{videoEarn} € | 
       
        */
        
        this.assignVariableLen();
        
        String canalString = "";
        String lineaEstandar = String.format("| Video %" + videoNumLen + "d | %" + visuVideoLen + "d | %" + videoTiempoLen + "s | %" + videoEarnLen + ".2f € |", 1, 1, "10:10:10", 1.1);
        int longLinea = lineaEstandar.length();
        String separadorLinea = "|"+"-".repeat(longLinea-2)+"|\n";
        canalString = separadorLinea;
        canalString += "| Análisis preliminar del canal: " + nombreCanal + "\n";
        canalString += separadorLinea;
        canalString += "| Video " +" ".repeat(videoNumLen) + " | " + " ".repeat(visuVideoLen -"Visualizaciones".length()) + "Visualizaciones | " + " ".repeat(videoTiempoLen -"Duración".length()) + "Duración | " + " ".repeat(videoIdLen -"Id video URL".length()) + "Id video URL | " + " ".repeat(videoEarnLen -"Ingresos previstos".length()) + "Ingresos previstos|\n";
        canalString += separadorLinea;
        
        int videoNumLenFormatSpace, visuVideoLenFormatSpace, videoTiempoLenFormatSpace, videoIdLenFormatSpace, videoEarnLenFormatSpace;
        String videoNumLenFormatSpaceStr, visuVideoLenFormatSpaceStr, videoTiempoLenFormatSpaceStr, videoIdLenFormatSpaceStr, videoEarnLenFormatSpaceStr;
        
        for(Video video:arrayVideos){
            if((videoNumLenFormatSpace = (videoNumLen - Integer.toString(video.getVideoNum()).length())) == 0){
                videoNumLenFormatSpaceStr = "";
            }
            else{
                videoNumLenFormatSpaceStr = Integer.toString(videoNumLenFormatSpace);
            }
            
            if((visuVideoLenFormatSpace = (visuVideoLen - Integer.toString(video.getVisuVideo()).length())) == 0){
                visuVideoLenFormatSpaceStr = "";
            }
            else{
                visuVideoLenFormatSpaceStr = Integer.toString(visuVideoLenFormatSpace);
            }

            if((videoTiempoLenFormatSpace = (videoTiempoLen - video.getTiempo().length())) == 0){
                videoTiempoLenFormatSpaceStr = "";
            }
            else{
                videoTiempoLenFormatSpaceStr = Integer.toString(videoTiempoLenFormatSpace);
            }

            if((videoIdLenFormatSpace = (videoIdLen - video.getIdVideoUrl().length())) == 0){
                videoIdLenFormatSpaceStr = "";
            }
            else{
                videoIdLenFormatSpaceStr = Integer.toString(videoIdLenFormatSpace);
            }

            if((videoEarnLenFormatSpace = (videoEarnLen - Float.toString(video.getVideoEarn()).length())) == 0){
                videoEarnLenFormatSpaceStr = "";
            }
            else{
                videoEarnLenFormatSpaceStr = Integer.toString(videoEarnLenFormatSpace);
            }

            

            
            
            canalString += String.format("| Video %"+videoNumLenFormatSpaceStr+"d | %"+visuVideoLenFormatSpaceStr+"d | %"+ videoTiempoLenFormatSpaceStr + "s | %"+videoIdLenFormatSpaceStr+"s | %"+videoEarnLenFormatSpaceStr+".2f € |", video.getVideoNum(), video.getVisuVideo(), video.getTiempo(), video.getIdVideoUrl(), video.getVideoEarn());
        }
        
        
        return canalString;
    }

}