/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioyoutube;

/**
 *
 * @author juan
 */
public class EjercicioYoutube {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        Canal canalYoutube = new Canal();
        canalYoutube.loadCanal();
        System.out.print(canalYoutube.getCanalString());
        System.out.println("Parada");
        
    }

    
}
