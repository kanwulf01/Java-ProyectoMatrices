
package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class GestionDeArchivos {
    
        
    private static int[][] matriz;
    private static int filas;
    private static int columnas;
    
    public GestionDeArchivos(){};
    
    
    public static String getRoute(){ //Funcion que me permite conocer la ruta en la cual se encuentra el archivo con la matriz
        JFileChooser objChooser = new JFileChooser();
        int window = objChooser.showOpenDialog(null);
        String routeMatriz="";
        if(window == JFileChooser.APPROVE_OPTION){
            File file = objChooser.getSelectedFile();           
            routeMatriz=String.valueOf(file);
            System.out.println(routeMatriz);
            try{
            }catch(Exception e){
                 System.out.println("El archivo no es compatible, por favor verifique el archivo");
            }
        }
        return routeMatriz;
    }
    
    
    public static void loadMatriz(String route) throws FileNotFoundException{          		
        File file = new File(route);	
        Scanner sc = new Scanner(file);	
        
        if(file.exists()){
            
            filas=sc.nextInt();
            columnas=sc.nextInt();
            matriz = new int[filas][columnas];
            
            while(sc.hasNext()){      
                
                for (int i=0; i<filas; i++){		
                    for(int j=0; j<columnas; j++){
                        
                        matriz[i][j]=sc.nextInt();						
                        
                    }					
                }		
            }							
	}      
    }
    
    public static int getFilas(){
        return filas;
    }
    
    public static int getColumnas(){
        return columnas;
    }
    
    public static int[][] getMatriz(){
        return matriz;
    }
}
