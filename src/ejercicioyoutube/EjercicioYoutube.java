package ejercicioyoutube;

/**
 *
 * @author juan calzada bernal
 */
public class EjercicioYoutube {   
    
    public static void main(String[] args) {
        
        Canal canalYoutube = new Canal();
        canalYoutube.loadCanal();
        System.out.print(canalYoutube.getCanalString());
        System.out.println("Parada");
        
    }

}
