

package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class Coordenado {
    
    
    //ATRIBUTOS
    private static int[][] matriz;
    private static int[][] matrizSum;
    private static Stack<Integer> pilaValores;
    private static Stack<Integer> pilaFilas;
    private static Stack<Integer> pilaColumnas;
    private static Stack<Integer> pilaValoresSum;
    private static Stack<Integer> pilaFilasSum;
    private static Stack<Integer> pilaColumnasSum;
    private static ArrayList<Integer> listaValores;
    private static ArrayList<Integer> listaFilas;
    private static ArrayList<Integer> listaColumnas;
    private static int[] arrayFila;
    private static int[] arrayColumna;
    private static int filas;
    private static int columnas;
    private static ImageIcon FadaImage= new ImageIcon("src/Images/notification.png");;

    public Coordenado(){};

       
    public static void loadMatriz(int[][] matrizFile,int fila, int columna) throws FileNotFoundException{//CARGA LA MATRIZ LEIDA 		               
        filas=fila;
        columnas=columna;
        matriz = new int[filas][columnas];
        for (int i=0; i<filas; i++){		
            for(int j=0; j<columnas; j++){                                         
                matriz[i][j]=matrizFile[i][j];				                                                 					           		
            }							
	}      
    }
    

    public static void loadMatrizSum(int[][] matrizFile,int fila, int columna) throws FileNotFoundException{//CARGA LA MATRIZ LEIDA 		               
        if(!(filas==fila && columnas==columna)){
            JOptionPane.showMessageDialog(null, "La matriz que intenta sumar no es del mismo tamaño", "NOTIFICACION", 0, FadaImage);

        }else{
            matrizSum = new int[filas][columnas];
            for (int i=0; i<filas; i++){		
                for(int j=0; j<columnas; j++){                                         
                    matrizSum[i][j]=matrizFile[i][j];				                                                 					           		
                }							
            }
        }
    }
    
    
    
    public static void coordinateFormat(){//PASA LA MATRIZ A FORMATO COORDENADO
        long time=0; //Variable para tomar el tiempo total de ejecucion
        pilaValores = new Stack<Integer>();
        pilaColumnas = new Stack<Integer>();
        pilaFilas = new Stack<Integer>();
        listaValores=new ArrayList<Integer>();
        listaFilas=new ArrayList<Integer>();
        listaColumnas=new ArrayList<Integer>();
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                
                if((matriz[i][j]==0)==false){
                    
                    pilaValores.push(matriz[i][j]);
                    pilaFilas.push(i);
                    pilaColumnas.push(j);                          
                    listaValores.add(matriz[i][j]);
                    listaFilas.add(i);
                    listaColumnas.add(j);
                }
                
            }
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo de obtener representacion coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
       
    }
    
    public static void coordinateFormatSum(){//PASA LA MATRIZ A FORMATO COORDENADO
        pilaValoresSum = new Stack<Integer>();
        pilaColumnasSum = new Stack<Integer>();
        pilaFilasSum = new Stack<Integer>();
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                
                if((matrizSum[i][j]==0)==false){
                    
                    pilaValoresSum.push(matrizSum[i][j]);
                    pilaFilasSum.push(i);
                    pilaColumnasSum.push(j);
                    
                }
                
            }
        }
    }
    
    public static void showMatriz(){//MUESTRA LA MATRIZ EN CONSOLA
        for (int x=0; x < matriz.length; x++) {
          System.out.print("|");
          for (int y=0; y < matriz[x].length; y++) {
            System.out.print (matriz[x][y]);
            if (y!=matriz[x].length-1) System.out.print("\t");
          }
          System.out.println("|");
        }
    }
        
    public static void showArray(ArrayList<Integer> lista){
        System.out.println(Arrays.toString(lista.toArray()));
    }
    public static void showMatriz2(int[][] matriz){//MUESTRA LA MATRIZ EN CONSOLA
        for (int x=0; x < matriz.length; x++) {
          System.out.print("|");
          for (int y=0; y < matriz[x].length; y++) {
            System.out.print (matriz[x][y]);
            if (y!=matriz[x].length-1) System.out.print("\t");
          }
          System.out.println("|");
        }
    }
        
    public static void showStack(Stack<Integer> pila){//MUESTRA LA PILA EN CONSOLA
        pila.forEach(k->{
            System.out.print(" "+k);
        });
        System.out.print("\n");
    }
    
    public static void fillArrayList(int[] arreglo,Stack<Integer> pila){//Funcion que llena un arreglo con los valores de una pila
        int iterador=0;
        while(!pila.empty()){
            arreglo[iterador]=pila.pop();
            iterador++;

        }
    }
    
    public static void generateRepresentation(File archivo, FileWriter escribir) throws IOException{//FUNCION QUE IMPRIME LA REPRESENTACION COORDENADA EN UN ARCHIVO DE TEXTO    
        escribir.write(System.getProperty("line.separator"));                   
        escribir.write("VALORES: ");//Imprime la pila valores en el archivo de texto.       
        pilaValores.forEach(k->{       
            try {           
                escribir.write(" "+k);              
            } catch (IOException ex) {          
                Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);              
            }          
        });              
        escribir.write(System.getProperty("line.separator"));       
        escribir.write("FILAS: ");//Imprime la pila filas en el archivo de texto.       
        pilaFilas.forEach(k->{       
            try {           
                escribir.write(" "+k);              
            } catch (IOException ex) {           
                Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);               
            }           
        });            
        escribir.write(System.getProperty("line.separator"));       
        escribir.write("COLUMNAS: ");//Imprime la pila columnas en el archivo de texto.       
        pilaColumnas.forEach(k->{       
            try {           
                escribir.write(" "+k);               
            } catch (IOException ex) {           
                Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);              
            }          
        });      
    }
    
    
    public static void cleanStack(Stack<Integer> pila){ //Funcion que limpia una pila
        while(!pila.empty()){
            pila.pop();
        }
    }

    public static void sumMatrices(String route){
        long time=0; //Variable para tomar el tiempo total de ejecucion

        int[][] matrizSumada = new int [filas][columnas];
        int[][] matriz1 = new int [filas][columnas];
        int[][] matriz2 = new int [filas][columnas];
        for(int i=0;i<filas;i++){               
            for(int j=0; j<columnas; j++){                                
                matrizSumada[i][j]=0;                
            }           
        }
        for(int i=0;i<filas;i++){               
            for(int j=0; j<columnas; j++){                                
                matriz1[i][j]=0;                
            }           
        }
     

        for(int i=0;i<filas;i++){               
            for(int j=0; j<columnas; j++){                                
                matriz2[i][j]=0;                
            }           
        }
        int aux=pilaValores.size();
            for(int i=0; i<aux;i++){//Se colocan los valores de pilas valores en las respectivas posiciones de la matriz
                matriz1[pilaFilas.peek()][pilaColumnas.peek()]=pilaValores.peek();
                pilaFilas.pop();
                pilaColumnas.pop();
                pilaValores.pop();
            }
        int aux2=pilaValoresSum.size();
            for(int i=0; i<aux2;i++){//Se colocan los valores de pilas valores en las respectivas posiciones de la matriz
                matriz2[pilaFilasSum.peek()][pilaColumnasSum.peek()]=pilaValoresSum.peek();
                pilaFilasSum.pop();
                pilaColumnasSum.pop();
                pilaValoresSum.pop();
            }
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo

        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                matrizSumada[i][j]=matriz1[i][j]+matriz2[i][j];
            }
        }
        cleanStack(pilaFilas);
        cleanStack(pilaColumnas);
        cleanStack(pilaValores);
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
               
                if((matrizSumada[i][j]==0)==false){
                    
                    pilaValores.push(matrizSumada[i][j]);
                    pilaFilas.push(i);
                    pilaColumnas.push(j);
                    
                }
                
            }
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo de obtener la suma de matrices coordenada\n para la matrices de tamaño: "+matrizSumada.length+" es de: "+ time+" milisegundos");

        try{    
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            escribir.write(System.getProperty("line.separator"));         
            for(int i=0;i<filas; i++){//Imprime la matriz al cuadrado en un archivo de texto
                if(i>0){
                    escribir.write(System.getProperty("line.separator"));
                }
                for(int j=0; j<columnas;j++){                   
                    escribir.write(String.valueOf(matrizSumada[i][j])+" ");
                }
            }
            
            generateRepresentation(archivo,escribir);
            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        } 
                    
            

    }
        
    
    
    public static void transposedMatriz(String route){
        int[][] transposedMatriz = new int [columnas][filas];           
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo

        for(int i=0;i<columnas;i++){               
            for(int j=0; j<filas; j++){                                
                transposedMatriz[i][j]=0;                
            }           
        }
        while(!pilaValores.empty()){
            transposedMatriz[pilaColumnas.pop()][pilaFilas.pop()]=pilaValores.pop();
        }
        cleanStack(pilaValores);
        cleanStack(pilaColumnas);
        cleanStack(pilaFilas);
        
        for(int i=0; i<columnas; i++){//Las llenamos nuevamente pero ahora con los valores elevados al cuadrado
            for(int j=0; j<filas; j++){               
                if((transposedMatriz[i][j]==0)==false){              
                    pilaValores.push(transposedMatriz[i][j]);
                    pilaFilas.push(i);
                    pilaColumnas.push(j);                 
                }              
            }
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo de obtener la matriz transpuesta coordenada\n para la matriz de tamaño: "+transposedMatriz.length+" es de: "+ time+" milisegundos");

        try{    
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            escribir.write(System.getProperty("line.separator"));         
            for(int i=0;i<columnas; i++){//Imprime la matriz al cuadrado en un archivo de texto
                if(i>0){
                    escribir.write(System.getProperty("line.separator"));
                }
                for(int j=0; j<filas;j++){                   
                    escribir.write(String.valueOf(transposedMatriz[i][j])+" ");
                }
            }
            
            generateRepresentation(archivo,escribir);
            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        } 

            
            
    }
    
    public static int multiplicador(int[] fila, int[] columna){ //Funcion para retornar el valor de la multiplicacion de filas por columnas
        int resultado=0;
        for(int i=fila.length-1; i>=0; i--){
            if(fila[i] !=0 && columna[i] !=0){
                resultado += fila[i]*columna[i];
            }
        }
        return resultado;
    }
    
    public static void squareMatriz(String route){ //ELEVA AL CUADRADO LOS NUMEROS DE LA MATRIZ
       if(!(columnas==filas)){
            JOptionPane.showMessageDialog(null, "La matriz no es cuadrada, por lo tanto no se puede multiplicar consigo mismo :'v", "NOTIFICACION", 0, FadaImage);
       }else{
           Stack<Integer> squareValues = new Stack<>();
           cleanStack(pilaFilas);
           cleanStack(pilaColumnas);
           for(int i=0;i<filas; i++){
               for(int j=0; j<columnas; j++){
                   getRowAux(i);//Llena el arreglo fila con los valores de una fila
                   getColumnAux(j);//Llena el arreglo columna con los valores de una columna

                   if(multiplicador(arrayFila,arrayColumna) != 0){
                        squareValues.push(multiplicador(arrayFila,arrayColumna));
                        pilaFilas.push(i);
                        pilaColumnas.push(j);
                   }
               }
           }
            try{    
                File archivo=new File(route+".txt");                        
                FileWriter escribir=new FileWriter(archivo,true);    
                escribir.write(System.getProperty("line.separator"));         
                escribir.write("VALORES: ");//Imprime la pila valores en el archivo de texto.       
                squareValues.forEach(k->{       
                    try {           
                        escribir.write(" "+k);              
                    } catch (IOException ex) {          
                        Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);              
                    }          
                });              
                escribir.write(System.getProperty("line.separator"));       
                escribir.write("FILAS: ");//Imprime la pila filas en el archivo de texto.       
                pilaFilas.forEach(k->{       
                    try {           
                        escribir.write(" "+k);              
                    } catch (IOException ex) {           
                        Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);               
                    }           
                });            
                escribir.write(System.getProperty("line.separator"));       
                escribir.write("COLUMNAS: ");//Imprime la pila columnas en el archivo de texto.       
                pilaColumnas.forEach(k->{       
                    try {           
                        escribir.write(" "+k);               
                    } catch (IOException ex) {           
                        Logger.getLogger(Coordenado.class.getName()).log(Level.SEVERE, null, ex);              
                    }          
                });

                int[][] squareMatriz = new int[filas][columnas];                       
                for(int i=0;i<filas;i++){               
                    for(int j=0; j<columnas; j++){                                
                        squareMatriz[i][j]=0;                
                    }           
                }
                int aux=pilaValores.size();
                for(int i=0; i<aux;i++){//Se colocan los valores de pilas valores en las respectivas posiciones de la matriz
                    squareMatriz[pilaFilas.peek()][pilaColumnas.peek()]=squareValues.peek();
                    pilaFilas.pop();
                    pilaColumnas.pop();
                    squareValues.pop();
                } 

                escribir.close();
            }catch(Exception e){      
            System.out.println("Error al escribir");
        } 
       }
    }
    
    public static void setPosition(String route,int fila,int columna,int numero) throws IOException{//CAMBIA EL VALOR DE UNA POSICION DE LA MATRIZ DADA SU COLUMNA Y FILA
        int tamanoValores = pilaValores.size()+1;
        int tamanoFilas = pilaFilas.size()+1;
        int tamanoColumnas = pilaColumnas.size()+1;
        //CREACION DE ARREGLOS
        int[] listaValores = new int[pilaValores.size()+1];
        int[] listaFilas = new int[pilaValores.size()+1];
        int[] listaColumnas = new int[pilaValores.size()+1];
        boolean confirmn=false;
        

        fillArrayList(listaValores,pilaValores);
        fillArrayList(listaFilas,pilaFilas);
        fillArrayList(listaColumnas,pilaColumnas);
        
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
        try{
            for(int i=0; i<=listaValores.length; i++){
                if(listaFilas[i]==fila && listaColumnas[i]==columna){//SE COMPARA LAS FILAS Y COLUMNAS, SI SE ENCUENTRA, SE CAMBIA EL VALOR
                    listaValores[i]=numero;
                    confirmn=true;
                    break;
                    }                  
               }       
         }catch(ArrayIndexOutOfBoundsException e){
            listaValores[tamanoValores-1]=numero;
            listaFilas[tamanoFilas-1]=fila;
            listaColumnas[tamanoColumnas-1]=columna;
           }

       
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo hacer cambio de una posicion de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

                   
       File archivo=new File(route+".txt");                                    
       FileWriter escribir=new FileWriter(archivo,true);                
       
       escribir.write(System.getProperty("line.separator"));
       escribir.write("VALORES: "+Arrays.toString(listaValores)+"\n");
       escribir.write("FILAS: "+Arrays.toString(listaFilas)+"\n");
       escribir.write("COLUMNAS: "+Arrays.toString(listaColumnas)+"\n");

       escribir.close();
    }
    
    public static void getRowAux(int fila){//DEVULVE LOS ELEMENTOS QUE HAY EN UNA FILA DETERMINADA        
        int aux=pilaValores.size();
        arrayFila = new int[filas];
        for(int i=0; i<arrayFila.length;i++){
            arrayFila[i]=0;
        }
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
        for(int i=0; i<listaFilas.size();i++){
            if(listaFilas.get(i)==fila){
                arrayFila[listaColumnas.get(i)]=listaValores.get(i);
            }
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo obtener una fila de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

    }
    public static void getRow(int fila){//DEVULVE LOS ELEMENTOS QUE HAY EN UNA FILA DETERMINADA        
        int aux=pilaValores.size();
        int[] valoresFila = new int[columnas];

        int iterador=0;
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
        for(int i=1; i<=aux;i++){
            if(pilaFilas.peek()==fila){
                valoresFila[pilaColumnas.peek()]=pilaValores.peek();
                pilaFilas.pop();                
                pilaColumnas.pop();              
                pilaValores.pop(); 
            }else{                  
                pilaFilas.pop();                
                pilaColumnas.pop();              
                pilaValores.pop();            
            }
            iterador++;
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo obtener una fila de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

       
        JOptionPane.showMessageDialog(null, "DADA LA FILA "+fila+"\nLOS VALORES DE ESTA SON: "+Arrays.toString(valoresFila), "NOTIFICACION", 0, FadaImage);

    }
    
    public static void getColumn(int columna){//DEVUELVE LOS ELEMENTOS QUE HAY EN UNA COLUMNA DETERMINADA
        int aux=pilaValores.size();
        int[] valoresColumna = new int[filas];

        int iterador=0;
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo       
        for(int i=1; i<=aux;i++){
            if(pilaColumnas.peek()==columna){
                valoresColumna[pilaFilas.peek()]=pilaValores.peek();
                pilaFilas.pop();                
                pilaColumnas.pop();              
                pilaValores.pop(); 
            }else{                  
                pilaFilas.pop();                
                pilaColumnas.pop();              
                pilaValores.pop();            
            }
            iterador++;
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo obtener una columna de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

       
        JOptionPane.showMessageDialog(null, "DADA LA COLUMA "+columna+"\nLOS VALORES DE ESTA SON: "+Arrays.toString(valoresColumna), "NOTIFICACION", 0, FadaImage);

    }
    
    public static void getColumnAux(int columna){//DEVUELVE LOS ELEMENTOS QUE HAY EN UNA COLUMNA DETERMINADA
        int aux=pilaValores.size();
        arrayColumna = new int [columnas];
        for(int i=0; i<arrayColumna.length;i++){
            arrayColumna[i]=0;
        }
        int iterador=0;
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo       
        for(int i=0; i<listaColumnas.size();i++){
            if(listaColumnas.get(i)==columna){
                arrayColumna[listaFilas.get(i)]=listaValores.get(i);
            }
        }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo obtener una columna de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

       

    }
    
    public static void getElement(int fila,int columna) throws IOException{//IMPRIME EN PANTALLA UN ELEMENTO DADA SU COLUMNA Y FILA

        boolean confirm=false;
        try{
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            int aux=pilaValores.size();
            for(int i=1;i<=aux+1;i++){
                if(pilaFilas.peek()==fila && pilaColumnas.peek()==columna){
                    System.out.println(String.valueOf(pilaValores.peek()));
                    confirm=true;
                    JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+columna+"\nY LA FILA "+fila+"\nEL VALOR RESPECTIVO ES: "+String.valueOf(pilaValores.peek()), "NOTIFICACION", 0, FadaImage);
                    time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
                    System.out.println("Tiempo obtener un elemento de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

                    break;
                }else{
                    pilaFilas.pop();
                    pilaColumnas.pop();
                    pilaValores.pop();
                    }
            }
            
            if(pilaFilas.empty()){
                JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+columna+"\nY LA FILA "+fila+"\nEL VALOR RESPECTIVO ES: 0", "NOTIFICACION", 0, FadaImage);
            }
            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            System.out.println("Tiempo obtener un elemento de la matriz coordenada\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

            
        }catch(EmptyStackException e){      
            JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+columna+"\nY LA FILA "+fila+"\nEL VALOR RESPECTIVO ES: 0", "NOTIFICACION", 0, FadaImage);        
        }     
    }    
    public static void createFileMatriz(String route){//Crea el archivo que contiene la matriz
        try{
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    

            escribir.write(System.getProperty("line.separator"));
            int[][] matrizFile = new int [filas][columnas];
            for(int i=0; i<filas;i++){//Se llena la matriz con 0.
                for(int j=0; j<columnas;j++){
                    matrizFile[i][j]=0;
                }
            }
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            int aux=pilaValores.size();
            for(int i=0; i<aux;i++){//Se colocan los valores de pilas valores en las respectivas posiciones de la matriz
                matrizFile[pilaFilas.peek()][pilaColumnas.peek()]=pilaValores.peek();
                pilaFilas.pop();
                pilaColumnas.pop();
                pilaValores.pop();
            } 
            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            System.out.println("Tiempo obtener un la matriz coordenada dada una representacion\n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

            
            for(int i=0;i<filas; i++){
                if(i>0){
                    escribir.write(System.getProperty("line.separator"));
                }
                for(int j=0; j<columnas;j++){                   
                    escribir.write(String.valueOf(matrizFile[i][j])+" ");
                }
            }           
            
            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        }     
    }
    
    public static void createFileRepresentation(String route){//CREA UN ARCHIVO CON LA REPRESENTACION COORDENADA
        try{      
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            generateRepresentation(archivo,escribir);  
            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            System.out.println("Tiempo obtener la representacion coordenada de la matriz \n para la matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");           
            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        }
    }

    
    
}
