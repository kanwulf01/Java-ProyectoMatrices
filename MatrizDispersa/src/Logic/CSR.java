
package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class CSR {
    private static int[][] matriz;
    private static int[][] matrizSum;
    private static ArrayList<Integer> listaValores;
    private static ArrayList<Integer> listaCFilas;
    private static ArrayList<Integer> listaFilas;
    private static ArrayList<Integer> listaColumnas;
    private static int[] arrayFila;
    private static int[] arrayColumna;
    private static int filas;
    private static int columnas;
    private static ImageIcon FadaImage= new ImageIcon("src/Images/notification.png");;

    public CSR(){};
    
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
    
    
    public void csrFormat(){
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
        listaValores=new ArrayList<>();
        listaCFilas=new ArrayList<>();
        listaColumnas=new ArrayList<>();
        listaFilas= new ArrayList<>();
        int contador=0;
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                
                if((matriz[i][j]==0)==false){    //Si el valor de la matriz es distinto de 0              
                    listaValores.add(matriz[i][j]); //Agrego el valor en la lista valores
                    listaColumnas.add(j); //Agrego la posicion de la columna en la lista columnas
                    listaFilas.add(i);
                    contador++;
                
                }                                 
                if(j==(columnas-1)){        //En la ultima iteracion            
                    listaCFilas.add(listaValores.size()-contador);//Agrego a la lista el valor de del indice del primer elemento insertado en la fila.                  
                }                 
            }
            contador=0;
        }
        listaCFilas.add(listaCFilas.get(listaCFilas.size()-1)+1);
        
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

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
    
    public static void showArrayList(ArrayList<Integer> lista){
        System.out.println(Arrays.toString(lista.toArray()));
    }
    public static void generateRepresentation(File archivo, FileWriter escribir) throws IOException{
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("VALORES: "+Arrays.toString(listaValores.toArray())); 
            
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("COLUMNAS: "+Arrays.toString(listaColumnas.toArray())); 
            
            escribir.write(System.getProperty("line.separator"));
            listaCFilas.remove(listaCFilas.size()-1);
            listaCFilas.add(listaValores.size());
            listaCFilas.lastIndexOf(filas);
            escribir.write("C. FILAS: "+Arrays.toString(listaCFilas.toArray())); 
    }
    
    public static void fillMatriz(int[][] matrizAux){            
            for (int x=0; x < matrizAux.length; x++) {
              for (int y=0; y < matrizAux[x].length; y++) {
                  matrizAux[x][y]=0;
            }
        }
    }
    
    public static void createFileMatriz(String route) throws IOException{
        int[][] matrizFile = new int [filas][columnas];
            for(int i=0; i<filas;i++){//Se llena la matriz con 0.
                for(int j=0; j<columnas;j++){
                    matrizFile[i][j]=0;
                }
            }
            int aux=listaCFilas.size();
            int contadorValores=0;
            int contadorColumnas=0;
            int contadorFilas=0;
            int cantElementosFila=0;
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
            for(int i=0; i<=aux;i++){
                if(!(contadorFilas==listaCFilas.size()-1)){//Si la lista de Punteros de inicio de filas no se ha recorrido por completo
                    cantElementosFila=(int)listaCFilas.get(contadorFilas+1)-(int)listaCFilas.get(contadorFilas);
                    for(int j=0; j<cantElementosFila;j++){//Lleno la matriz por filas.
                         if(contadorColumnas<listaColumnas.size()){//EVITA DESBORDE
                            matrizFile[contadorFilas][listaColumnas.get(contadorColumnas)]=listaValores.get(contadorValores);
                            contadorValores++;                        
                            contadorColumnas++;
                         }
                    }
                    contadorFilas++;
                }else{//Si el arreglo de punteros a inicios de fila se recorrio completamente
                    //Lleno la ultima fila con los valores y columnas restantes
                    if(contadorColumnas<listaColumnas.size()){//EVITA DESBORDE
                        matrizFile[contadorFilas-1][listaColumnas.get(contadorColumnas)]=listaValores.get(contadorValores);
                    }
                    contadorValores++;                        
                    contadorColumnas++;
                }
            }
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener la matriz dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            
              for(int i=0;i<filas; i++){
                if(i>0){
                    escribir.write(System.getProperty("line.separator"));
                }
                for(int j=0; j<columnas;j++){                   
                    escribir.write(String.valueOf(matrizFile[i][j])+" ");
                }
            }           
            
            escribir.close();

    }
    
    public static void getElement(int fila,int columna) throws IOException{//IMPRIME EN PANTALLA UN ELEMENTO DADA SU COLUMNA Y FILA
        int element;
        getRowAux(fila);
        element= arrayFila[columna];
        JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+columna+"\nY LA FILA "+fila+"\nEL VALOR RESPECTIVO ES: "+element, "NOTIFICACION", 0, FadaImage);                          

    }


    public static void getColumn(int columna){//DEVUELVE LOS ELEMENTOS QUE HAY EN UNA COLUMNA DETERMINADA
        int aux=listaValores.size();
        arrayColumna = new int [filas];
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
        JOptionPane.showMessageDialog(null, "DADA LA COLUMA "+columna+"\nLOS VALORES DE ESTA SON: "+Arrays.toString(arrayColumna), "NOTIFICACION", 0, FadaImage);

       

    }

    public static void getColumnAux(int columna){//DEVUELVE LOS ELEMENTOS QUE HAY EN UNA COLUMNA DETERMINADA
        int aux=listaValores.size();
        arrayColumna = new int [filas];
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
    public static void getRow(int fila){
            int aux=listaCFilas.size();
            int contadorValores=0;
            int contadorFilas=0;
            int cantElementosFila=0;    
            int[] valoresFila = new int[columnas];

        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo   
            for(int i=0; i<=aux;i++){
                if(!(contadorFilas==listaCFilas.size()-1)){//Si la lista de Punteros de inicio de filas no se ha recorrido por completo
                    cantElementosFila=(int)listaCFilas.get(contadorFilas+1)-(int)listaCFilas.get(contadorFilas);
                    for(int j=0; j<cantElementosFila;j++){//Lleno la matriz por filas.
                        if(contadorFilas==fila){//Si llego a la posicion de las columnas y filas
                            if(listaColumnas.size()!=contadorValores){//EVITA DESBORDE
                                valoresFila[listaColumnas.get(contadorValores)]=listaValores.get(contadorValores);
                                contadorValores++; 
                            } 
                        }else{//De lo contrario aumento los contadores.
                            contadorValores++;                                        
                        }
                    }
                    contadorFilas++;//Cuando termino de recorrer una fila, aumento el contador
                }else{//Si el arreglo de punteros a inicios de fila se recorrio completamente
                    contadorFilas--;//quito el aumente de la iteracion de condicion de salida.
                    if(contadorFilas==fila){
                        if(listaColumnas.size()!=contadorValores){//EVITA DESBORDE
                            valoresFila[listaColumnas.get(contadorValores)]=listaValores.get(contadorValores);

                            contadorValores++; 
                        }

                    }else{
                        contadorValores++;                        
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "DADA LA FILA "+fila+"\nLOS VALORES DE ESTA SON: "+Arrays.toString(valoresFila), "NOTIFICACION", 0, FadaImage);
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener una fila dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
  
    }
    
    public static void getRowAux(int fila){
            int aux=listaCFilas.size();
            int contadorValores=0;
            int contadorFilas=0;
            int cantElementosFila=0;
            int iterador=0;
            arrayFila = new int [columnas];
            for(int i=0; i<arrayFila.length;i++){//Llenamos el array con 0
                arrayFila[i]=0;
            }
            for(int i=0; i<listaFilas.size();i++){//Ciclo que recorre la lista de filas
                if(listaFilas.get(i)==fila){//Si se encuentra un elemento en la posicion de fila que solicitamos
                    arrayFila[listaColumnas.get(i)]=listaValores.get(i);//Agregamos ese elemento al array Fila.
                }
            }

 
    }
    public static void setPosition(String route,int fila, int columna,int numero) throws IOException{            
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
        int aux=listaCFilas.size();       
        int contadorValores=0;       
        int contadorColumnas=0;        
        int contadorFilas=0;       
        int cantElementosFila=0;   
        matriz[fila][columna]=numero;
        listaValores.clear();
        listaCFilas.clear();
        listaColumnas.clear();
            
        int contador=0;
                 
        for(int i=0; i<filas; i++){                   
            for(int j=0; j<columnas; j++){                  
                if((matriz[i][j]==0)==false){    //Si el valor de la matriz es distinto de 0                                 
                    listaValores.add(matriz[i][j]); //Agrego el valor en la lista valores                                      
                    listaColumnas.add(j); //Agrego la posicion de la columna en la lista columnas                   
                    contador++;                            
                }                                                       
                if(j==(columnas-1)){        //En la ultima iteracion                                    
                    listaCFilas.add(listaValores.size()-contador);//Agrego a la lista el valor de del indice del primer elemento insertado en la fila.                                     
                }                                      
            }                  
            contador=0;                 
        }               
        listaCFilas.add(listaCFilas.get(listaCFilas.size()-1)+1);
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para cambiar una posicion dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
        showMatriz();
        File archivo=new File(route+".txt");                                   
        FileWriter escribir=new FileWriter(archivo,true);                     
        generateRepresentation(archivo,escribir); 
        escribir.write(System.getProperty("line.separator"));                
        for(int i=0;i<filas; i++){
                if(i>0){
                    escribir.write(System.getProperty("line.separator"));
                }
                for(int j=0; j<columnas;j++){                   
                    escribir.write(String.valueOf(matriz[i][j])+" ");
                }
            }                           
        escribir.close();

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

    public static void squareMatriz(String route) throws IOException{
       if(!(columnas==filas)){
            JOptionPane.showMessageDialog(null, "La matriz no es cuadrada, por lo tanto no se puede multiplicar consigo mismo :'v", "NOTIFICACION", 0, FadaImage);
       }else{
           ArrayList<Integer> squareValues = new ArrayList<>();
           ArrayList<Integer> auxColumnas = new ArrayList<>();
           ArrayList<Integer> auxFilas = new ArrayList<>();
           int[][] matriz = new int[filas][columnas];
           for(int i=0;i<filas; i++){
               for(int j=0; j<columnas; j++){
                   getRowAux(i);//Llena el arreglo fila con los valores de una fila
                   getColumnAux(j);//Llena el arreglo columna con los valores de una columna

                   if(multiplicador(arrayFila,arrayColumna) != 0){
                        squareValues.add(multiplicador(arrayFila,arrayColumna));
                        auxColumnas.add(j);
                        auxFilas.add(i);
                   }
               }
           }
           for(int i=0;i<squareValues.size();i++){
               matriz[auxFilas.get(i)][auxColumnas.get(i)]=squareValues.get(i);
           }
           listaValores.clear();
           listaColumnas.clear();
           listaCFilas.clear();
        int contador=0;
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                
                if((matriz[i][j]==0)==false){    //Si el valor de la matriz es distinto de 0              
                    listaValores.add(matriz[i][j]); //Agrego el valor en la lista valores
                    listaColumnas.add(j); //Agrego la posicion de la columna en la lista columnas
                    contador++;
                
                }                                 
                if(j==(columnas-1)){        //En la ultima iteracion            
                    listaCFilas.add(listaValores.size()-contador);//Agrego a la lista el valor de del indice del primer elemento insertado en la fila.                  
                }                 
            }
            contador=0;
        }
        listaCFilas.add(listaCFilas.get(listaCFilas.size()-1)+1);           

              try{    
                    File archivo=new File(route+".txt");                        
                    FileWriter escribir=new FileWriter(archivo,true);    
                    escribir.write(System.getProperty("line.separator"));
                    escribir.write("VALORES: "+Arrays.toString(squareValues.toArray())); 

                    escribir.write(System.getProperty("line.separator"));       
                    escribir.write("COLUMNAS: "+Arrays.toString(auxColumnas.toArray())); 

                    escribir.write(System.getProperty("line.separator"));
                    listaCFilas.remove(listaCFilas.size()-1);
                    listaCFilas.add(listaValores.size());
                    listaCFilas.lastIndexOf(filas);
                    escribir.write("C. FILAS: "+Arrays.toString(listaCFilas.toArray())); 

                    escribir.close();
              
              }catch(Exception e){                     
                  System.out.println("Error al escribir");             
              } 
              
       }
    }
    
    public static void transposedMatriz(String route) throws IOException{
        int[][] transposedMatriz = new int [columnas][filas];           
        int aux=listaCFilas.size();
        int contadorValores=0;
        int contadorColumnas=0;
        int contadorFilas=0;
        int cantElementosFila=0;       
        fillMatriz(transposedMatriz);
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
        //SE CONSTRUYE LA MATRIZ A PARTIR DE LAS REPRESENTACIONES.
        for(int i=0; i<=aux;i++){//SUPER CICLO REUTILIZABLE
                if(!(contadorFilas==listaCFilas.size()-1)){//Si la lista de Punteros de inicio de filas no se ha recorrido por completo
                    cantElementosFila=(int)listaCFilas.get(contadorFilas+1)-(int)listaCFilas.get(contadorFilas);
                    for(int j=0; j<cantElementosFila;j++){//Lleno la matriz por filas.
                        if(listaColumnas.size()!=contadorColumnas){
                            transposedMatriz[listaColumnas.get(contadorColumnas)][contadorFilas]=listaValores.get(contadorValores);
                            contadorValores++;                        
                            contadorColumnas++;
                        }
                    }
                    contadorFilas++;
                }else{//Si el arreglo de punteros a inicios de fila se recorrio completamente
                    //Lleno la ultima fila con los valores y columnas restantes
                    if(listaColumnas.size()!=contadorColumnas){
                        transposedMatriz[listaColumnas.get(contadorColumnas)][contadorFilas-1]=listaValores.get(contadorValores);
                        contadorValores++;                        
                        contadorColumnas++;
                    }
                }
            }
        
        listaCFilas.clear();
        listaColumnas.clear();
        listaValores.clear();
        
        //SE ACTUALIZAN LAS REPRESENTACIONES A PARTIR DE LA MATRIZ TRANSPUESTA
        int contador=0;
        for(int i=0; i<columnas; i++){
            for(int j=0; j<filas; j++){
                
                if((transposedMatriz[i][j]==0)==false){    //Si el valor de la matriz es distinto de 0              
                    listaValores.add(transposedMatriz[i][j]); //Agrego el valor en la lista valores
                    listaColumnas.add(j); //Agrego la posicion de la columna en la lista columnas
                    contador++;
                }
                if(j==(filas-1)){        //En la ultima iteracion                                   
                    listaCFilas.add(listaValores.size()-contador);//Agrego a la lista el valor de del indice del primer elemento insertado en la fila.                                     
                } 
            }
            contador=0;
        }
        listaCFilas.add(listaCFilas.get(listaCFilas.size()-1)+1);
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener la matriz transpuesta dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
                             
        File archivo=new File(route+".txt");                                   
        FileWriter escribir=new FileWriter(archivo,true);                     
        generateRepresentation(archivo,escribir); 
        escribir.write(System.getProperty("line.separator"));                
        for(int i=0;i<columnas; i++){               
            if(i>0){               
                escribir.write(System.getProperty("line.separator"));              
            }              
            for(int j=0; j<filas;j++){                                
                escribir.write(String.valueOf(transposedMatriz[i][j])+" ");           
            }           
        }                             
        escribir.close();

        
    }
    
    public static void sumMatrices(String route) throws IOException{
        int[][] matrizSumada = new int[filas][columnas];
        for(int i=0;i<filas;i++){               
            for(int j=0; j<columnas; j++){                                
                matrizSumada[i][j]=0;                
            }           
        }
        for(int i=0; i<filas;i++){
            for(int j=0; j<columnas;j++){
                matrizSumada[i][j]=matriz[i][j]+matrizSum[i][j];
            }
        }
        listaValores.clear();
        listaCFilas.clear();
        listaColumnas.clear();
        long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
        int contador=0;
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                
                if((matrizSumada[i][j]==0)==false){    //Si el valor de la matriz es distinto de 0              
                    listaValores.add(matrizSumada[i][j]); //Agrego el valor en la lista valores
                    listaColumnas.add(j); //Agrego la posicion de la columna en la lista columnas
                    contador++;
                }
                if(j==(columnas-1)){        //En la ultima iteracion                                   
                    listaCFilas.add(listaValores.size()-contador);//Agrego a la lista el valor de del indice del primer elemento insertado en la fila.                                     
                } 
            }
            contador=0;
        }
        listaCFilas.add(listaCFilas.get(listaCFilas.size()-1)+1);
        
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
    
        File archivo=new File(route+".txt");                                   
        FileWriter escribir=new FileWriter(archivo,true);                     
        generateRepresentation(archivo,escribir); 
        escribir.write(System.getProperty("line.separator"));                
        for(int i=0;i<filas; i++){               
            if(i>0){               
                escribir.write(System.getProperty("line.separator"));              
            }              
            for(int j=0; j<columnas;j++){                                
                escribir.write(String.valueOf(matrizSumada[i][j])+" ");           
            }           
        }                             
        escribir.close();   
    
    }
            
            
    
    public static void createFileRepresentation(String route){//CREA UN ARCHIVO CON LA REPRESENTACION COORDENADA
        try{      
            
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            generateRepresentation(archivo,escribir); 

            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        }
    }
    
}
