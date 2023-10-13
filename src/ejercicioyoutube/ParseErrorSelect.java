/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioyoutube;

import java.util.Scanner;

/**
 *
 * @author juan
 */
public class ParseErrorSelect {
    
    public static int getInt(boolean onlyPositive, boolean range, int minValue, int maxValue, String inputText){
        
        Scanner scannerRef = new Scanner(System.in);
        int integerScanned = 0;
        boolean exceptionDetected;
        do{
            try{
                System.out.println(inputText);
                integerScanned = scannerRef.nextInt();
                exceptionDetected = false;
                if(onlyPositive && (integerScanned < 0)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de números positivos o iguales a 0.");
                }
                else if(range && (integerScanned < minValue || integerScanned > maxValue)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de números mayores o iguales que " + minValue + " e inferiores o iguales a " + maxValue + ".");
                }
            } catch (Exception e){
                scannerRef.nextLine();
                System.err.println("Error en la lectura del entero, inténtelo de nuevo.");
                exceptionDetected = true;
            }
        }while(exceptionDetected);
        
        
        return integerScanned;
    }
        
    public static float getFloat(boolean onlyPositive, boolean range, float minValue, float maxValue, String inputText){
        
        Scanner scannerRef = new Scanner(System.in);
        float floatScanned = 0f;
        boolean exceptionDetected;
        do{
            try{
                System.out.println(inputText);
                floatScanned = scannerRef.nextFloat();
                exceptionDetected = false;
                if(onlyPositive && (floatScanned < 0)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de números positivos o iguales a 0.");
                }
                else if(range && (floatScanned < minValue || floatScanned > maxValue)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de números mayores o iguales que " + minValue + " e inferiores o iguales a " + maxValue + ".");
                }
            } catch (Exception e){
                scannerRef.nextLine();
                System.err.println("Error en la lectura del float, inténtelo de nuevo.");
                exceptionDetected = true;
            }
        }while(exceptionDetected);
        
        
        return floatScanned;
    }
    
    public static String getString(boolean noEmpty, boolean range, int minLen, int maxLen, String inputText){
        
        Scanner scannerRef = new Scanner(System.in);
        String stringScanned = "";
        boolean exceptionDetected;
        do{
            try{
                System.out.println(inputText);
                stringScanned = scannerRef.nextLine();
                exceptionDetected = false;
                if(noEmpty && (stringScanned.length() == 0)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de números positivos o iguales a 0.");
                }
                else if(range && (stringScanned.length() < minLen || stringScanned.length() > maxLen)){
                    exceptionDetected = true;
                    System.err.println("Solo se admite la entrada de más largos que " + minLen + " e inferiores o iguales a " + maxLen + " caracteres.");
                }
            } catch (Exception e){
                scannerRef.nextLine();
                System.err.println("Error en la lectura del String, inténtelo de nuevo.");
                exceptionDetected = true;
            }
        }while(exceptionDetected);
        
        
        return stringScanned;
    }
            
}
