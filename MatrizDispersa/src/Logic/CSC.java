/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class CSC {
    
    
       static GestionDeArchivos GA = new GestionDeArchivos();
        int i;
        private static String [][] matriz;
        private static String[][] Tmatriz;
            private static String[][] Omatriz;
       

        private static int tamañofila;
        private static int tamañocolumna;
        static  ArrayList<String> Listavaloresx = new ArrayList<>(); //arreglo real de valores
        static ArrayList<String> ListaFilas = new ArrayList<>();//arreglo real de filas
        static ArrayList<String> Cabezas = new ArrayList<String>();
        static ArrayList<String> nuevoVALORES = new ArrayList<>();//arreglo utilizado solo en modificar elemento
         static ArrayList<Integer> nuevoFILAS = new ArrayList<>();//arreglo utilizado solo en modificar elemento
         static ArrayList<Integer> nuevoCCOLUMNAS = new ArrayList<>();//arreglo utilizado solo en modificar elemento
         static ArrayList<Integer> CCOLUMNAS2 = new ArrayList<>();//Arreglo real de CColumnas
         static int[] columnasX;
         static int[] filasX;
        private static ImageIcon FadaImage= new ImageIcon("src/Images/notification.png");;

        public CSC(){      
        }
        
        public static void CSCFormat(){
        
            long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
     
        CCOLUMNAS(matriz);
        
        time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para obtener la representacion comprimida\n por columnas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
          }
        
        public void TRANSPUESTA(String route){
        
            ObtenerMatrizT(Listavaloresx,ListaFilas,CCOLUMNAS2,route);
        
        }
        
        public static void ImprimeMATRIZaTEXTO(String route){
        
          ObtenerMatriz(Listavaloresx,ListaFilas,CCOLUMNAS2,route);
           
        
        
        }
        
        public void ImprimeColumna(){
            String columnax = "";
            columnax = JOptionPane.showInputDialog(null,"Escriba el numero de La columna que quiere imprimir en consola");
                 int columnaN = 0;
                 columnaN = Integer.parseInt(columnax);
                 if(columnaN>=matriz[0].length){
                 JOptionPane.showMessageDialog(null,"la Columna ingresada no existe");
                 }else{ObtieneColumna(Listavaloresx,ListaFilas,CCOLUMNAS2,columnax);}
            
        }
        
        public void ImprimeFila(){
        
        String filax = "";
        filax = JOptionPane.showInputDialog(null,"Escriba el numero de La fila que quiere imprimir en consola");
        int filaN = 0;
        filaN = Integer.parseInt(filax);
        if(filaN>=matriz.length){
        
             JOptionPane.showMessageDialog(null,"la Fila ingresada no existe");
            
        }else{ObtenerFila(Listavaloresx,ListaFilas,CCOLUMNAS2,filax);}
        }
        
        public void ImprimeElemento(){
        
             String filax = "";
        filax = JOptionPane.showInputDialog(null,"Escriba el numero de La fila a");
        int filaN = 0;
        filaN = Integer.parseInt(filax);
        String columnax = "";
            columnax = JOptionPane.showInputDialog(null,"Escriba el numero de La columna ");
                 int columnaN = 0;
                 columnaN = Integer.parseInt(columnax);
        
        
        if(filaN<=matriz.length && columnaN<=matriz[0].length){
            System.out.print("Elemento de fila"+" "+filax+" "+"y columna"+" "+columnax+" "+"en matriz"+" "+"es: ");
             ObtenerElemento(Listavaloresx,ListaFilas,CCOLUMNAS2,filax,columnax);
        }else{JOptionPane.showMessageDialog(null,"la Fila O Columna ingresada no existe");}
        
        
        }
        
        public void imprimeMODIFICARPOSICION(String route,String filax,String columnax,String numerox){
        
            
            
        int filaN = 0;
        filaN = Integer.parseInt(filax);
        
                 int columnaN = 0;
                 columnaN = Integer.parseInt(columnax);
                 
        
                 if(filaN<=matriz.length && columnaN<=matriz[0].length){
                     ModificaELEMENTO(filaN,columnaN,numerox);
                 createFileRepresentation2(route);
                 
                 }else{
                   JOptionPane.showMessageDialog(null,"la Fila O Columna ingresada no existe");
                 }
        
                 
        }

    public static ArrayList<String> getListavaloresx() {
        return Listavaloresx;
    }

    public static ArrayList<String> getListaFilas() {
        return ListaFilas;
    }

    public static ArrayList<String> getCabezas() {
        return Cabezas;
    }

        
       public static void loadMatriz(int[][] matrizFile,int fila, int columna) throws FileNotFoundException{//CARGA LA MATRIZ LEIDA 		               
           
            long time=0; //Variable para tomar el tiempo total de ejecucion
        long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
           tamañofila=fila;
            tamañocolumna=columna;
            matriz = new String[tamañofila][tamañocolumna];
            Tmatriz = new String[tamañocolumna][tamañofila];
            for (int i=0; i<tamañofila; i++){		
                for(int j=0; j<tamañocolumna; j++){                                         
                    matriz[i][j]=String.valueOf(matrizFile[i][j]);				                                                 					           		
                }							
            }
            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
        System.out.println("Tiempo para cargar la matriz de : "+matriz.length+"  "+ matriz[0].length +"es de: "+ time+" milisegundos");
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
    
   public static void CCOLUMNAS(String[][] x){
     //Saca VALORES FILAS Y CCOLUMNAS DE MATRIZ
     Listavaloresx.clear();
     ListaFilas.clear();
     CCOLUMNAS2.clear();
    //   int[] prueba = new int[1];
        int cuenta = 0;
        int cuenta2 = 0;
        int cuenta3 = 0;
      
       
         
        for(int i=0; i<x[0].length;i++){//recorre columnas
       
             for(int j=0; j<x.length; j++){//recorre filas
                
                if(x[j][i].equalsIgnoreCase("0")){cuenta3++; }//para saber si la columna es vacia
                     
                else{
                     if(cuenta2<1){//entraca solo si encuentra una cabeza de la matriz
                    Cabezas.add(x[j][i]);
                   
                    
                    CCOLUMNAS2.add(cuenta);//llena el arreglo con la cabeza
                   cuenta2++; //suma 1 en cuenta para que no vuelva a entrar a aca
                   
                     }cuenta++; //suma cuenta para tener encuenta el valor de cada valor en la matriz para sacar el ccolumnas
                     
                     Listavaloresx.add(x[j][i]);//se va llenando el arreglo valores
                     String cast;
                     cast = Integer.toString(j);
                   ListaFilas.add(cast);//se va llenando el arreglo filas
                   
            } 
                 
        }if(cuenta3==x.length){//para saber cuando una columna es vacia 
            CCOLUMNAS2.add(cuenta); //se llena ccolumnas con el valor de la variable cuenta que me va contando la posicion de cada cabeza de la matriz
            
      
       }else{}
             
        cuenta3=0;
        cuenta2=0;   
                       }CCOLUMNAS2.add(Listavaloresx.size()+1);
       }
   
  
    
    
     public static void GraficaMatriz(String[][] x){
       //Dibuja una matriz
    
            for (int filas = 0; filas < x.length; filas++) {
                for (int colum = 0; colum < x[filas].length; colum++) {
                   System.out.print(x[filas][colum] + " ");
                }

                System.out.println();
            }
   
   
   }
    

            
        public static void ObtenerMatriz(ArrayList<String> valores, ArrayList<String> filas,ArrayList<Integer> ccolumnas,String route){
        //Obtiene la matriz apartir de su representacion crea la matriz como tal en un arreglo doble
         String [][] Omatriz = new String[tamañofila][tamañocolumna];
          int cont = 0;
          
          int v = 0;
          int v1 = 0;
         // int contador = 0;
          int resta = 0;
          String jj = "";
          
           long time=0; //Variable para tomar el tiempo total de ejecucion
           long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
          for(int i=0; i<ccolumnas.size()-1; i++){
                 
            v= ccolumnas.get(i);
            v1 = ccolumnas.get(i+1);
           resta = v1-v;
             int cont2 = 0;
           if(resta!=0){
               
               
              for(int j=0; j<Omatriz.length; j++){
             if(cont2<resta){
                if(cont!=filas.size()){
                 jj = Integer.toString(j);
                  if(jj.equalsIgnoreCase(filas.get(cont))){
                  
                      Omatriz[j][i] =  valores.get(cont);
                      
                      cont2++;
                      cont++;
                  }else{ Omatriz[j][i] = "0";
                   
                  }
                }else{Omatriz[j][i]= "0";}
                   //System.out.print(jj);
                

              }else{ Omatriz[j][i] = "0";
                 
             }
              
              }
              
          }else{
           
               for(int p=0; p<Omatriz.length; p++){
               
               Omatriz[p][i] = "0";
               }
             }
          
          }
          time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
          System.out.println("Tiempo para obtener la representacion de la matriz \n de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
          
        MATRIZATXT(Omatriz,route);

///////////////////////////////////////////////////////
         }    
       
        
     
        
      
        
        public static void ObtieneColumna(ArrayList<String> valores, ArrayList<String> filas1,ArrayList<Integer> ccolumnas,String Ncolumna){
        
            ArrayList<String> ValorColumna = new ArrayList<>();
           int resta = 0;
           int z,y,q,w;
            z = Integer.parseInt(Ncolumna);
             long time=0; //Variable para tomar el tiempo total de ejecucion
             long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
            if(z<ccolumnas.size()-1){//Este if tiene como fin evitar el desborde y que la variable z(numero de columna)
                //siempre este sobre el tamaño de las ccolumnas-1 en caso de else se sabe que ya son columnas de 0 las siguientes
            y = Integer.parseInt(Ncolumna+1);
            q = ccolumnas.get(z);
            w = ccolumnas.get(z+1);
            
 
                 resta =w-q;
                  //System.out.println(resta);
                if(resta!=0){
                int conta = q;
                int contadorx = 0;
                    for(int i = 0; i<matriz.length; i++){
                    if(contadorx<resta){
                        String ii;
                        
                        ii = Integer.toString(i);
                        // jj =  Integer.parseInt(ccolumnas.get(z));             
                        if(ii.equalsIgnoreCase(filas1.get(q)) && contadorx<resta){
                           
                         
                            ValorColumna.add(valores.get(conta));
                            conta++;
                            contadorx++;
                            q++;
                        }else{ValorColumna.add("0");}
                             
                    }else{ValorColumna.add("0");}
                    }
                  
                }else{
                    
                    for(int l = 0; l<matriz.length; l++){
                       ValorColumna.add("0");
                    }
                }
                ////
            
            }else{ if(z<matriz[0].length){
            // se hace un if para saber si la columna que entra es menor al tamaño de columnas de la matriz
            //ya que los valores que toma z aca estan afuera del ccolumnas entonces ya son columnas de 0s
            for( int l = 0; l<matriz.length; l++){
            
                 ValorColumna.add("0");
                
            }
                
                
            }else{
               
             JOptionPane.showMessageDialog(null,"La columna no existe");
            }
            }
         
            
            for(int i = 0; i<ValorColumna.size(); i++){
                  
               // System.out.println(ValorColumna.get(i));
            }
            
         time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
          System.out.println("Tiempo para obtener la representacion de una columna ingresada de matriz de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
          JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+Ncolumna+"\nLOS VALORES DE ESTA SON: "+ValorColumna.toString(), "NOTIFICACION", 0, FadaImage);
        }
        public static void ObtenerElemento(ArrayList<String> valores, ArrayList<String> filas1,ArrayList<Integer> ccolumnas,String Nfila,String CC){
              
                  String l = "";
                  int columnax = 0;
                  int v,v1,resta,colum;
                  colum = Integer.parseInt(CC);
                  
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
                  for(int i = 0; i<ccolumnas.size()-1; i++){
                   
                      String ii = "";
                      ii = Integer.toString(i);
                       if(ii.equalsIgnoreCase(CC)){
                           
                         
                           columnax = ccolumnas.get(i);
                           int valorC;
                           valorC = columnax;
                                      
                                v= ccolumnas.get(i);
                                v1 = ccolumnas.get(i+1);
                                resta = v1-v;
                           
                          
                        
                          int contador = 0;
                          int contador1 = 0;
                          contador = columnax;
                           for(int j = valorC; j<resta+valorC; j++){
                         
                               l = Integer.toString(j);
                               if(contador==j){
                               
                                   if(filas1.get(j).equalsIgnoreCase(Nfila)){
                                        contador1++;
                                      //System.out.print(valores.get(j));
                                      JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+Nfila+"\nY LA FILA "+CC+"\nEL VALOR RESPECTIVO ES: "+String.valueOf(valores.get(j)), "NOTIFICACION", 0, FadaImage);
                                   }else{contador++;
                                  }
                                   
                               
                               } 
                               
                                    
                               
                               
                           }if(contador1==0){ JOptionPane.showMessageDialog(null, "DADA LA COLUMNA "+Nfila+"\nY LA FILA "+CC+"\nEL VALOR RESPECTIVO ES: "+String.valueOf(0), "NOTIFICACION", 0, FadaImage);}
                     }
                  }
                   time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
                   System.out.println("Tiempo para obtener la un elemento de la matriz de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
            
        
        }
       
        public static void ObtenerFila(ArrayList<String> valores, ArrayList<String> filas1,ArrayList<Integer> ccolumnas,String Nfila){
        //Obtiene fila por medio de la representacion
          ArrayList<String> ye = new ArrayList<>();
          int valorenCC = 0;
        
          int valorenCC1 = 0;
         int contador = 0;
          int resta = 0;
          
      
              int count = 0;
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
              for(int j=0; j<ccolumnas.size()-1; j++){
                 
                  if(j<valores.size()-1){
                  valorenCC= ccolumnas.get(j);
                valorenCC1 = ccolumnas.get(j+1);
                resta = valorenCC1-valorenCC;
              
                if(resta!=0){
              
                      for(int i = valorenCC; i<valorenCC+resta; i++){//este for solo se recorre las veces del numero de elementos que tiene la columna
                      
                            if(i<filas1.size()-1){
                          if(filas1.get(i).equalsIgnoreCase(Nfila)){// si encuentra la fila ingresada en el arreglo fila llena el vector
                          
                              ye.add(valores.get(i));
                             count++;
                          }
                      }else{}
                      }if(count==1){count=0;
                      
                      }else{ye.add("0");//Si no encontro la fila entonces se pone un 0 
                      count=0;}
                      
             
              }else{
                resta=0;
                ye.add("0");
                 }
              }else{ye.add("0");}
              }
               
           
        
          
         // System.out.println(ye.toString());
          
                   time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
                   System.out.println("Tiempo para obtener la representacion de una fila para matriz de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
              JOptionPane.showMessageDialog(null, "DADA LA FILA "+Nfila+"\nLOS VALORES DE ESTA SON: "+ye.toString(), "NOTIFICACION", 0, FadaImage);
        
        }
        
      
      
    
    /////////////////////////////////////////////////////////////////////////////////
        
         
    
    
         public static void ModificaELEMENTO(int fila, int columna, String elemento){
         //POR AHORA LO DEJO QUE MODIFIQUE NUEVOS ARREGLOS DE VALORES FILAS Y CCOLUMNAS
            nuevoVALORES.clear();   //Listavaloresx
            nuevoFILAS.clear();     //ListaFilas
            nuevoCCOLUMNAS.clear();     
               ArrayList<String> Cabezas = new ArrayList<>();
               ArrayList<Integer> columnasVacias = new ArrayList<>();
                matriz[fila][columna] = elemento;//iguala el elemento que entro en la posicion exacta 
         
                int cont = 0;
                int cont2 = 0;
                int cont3 = 0;
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
                for(int i = 0; i<matriz[0].length; i++){
                int b = i;
                    for(int j = 0; j<matriz.length; j++){
             
                         if(!matriz[j][i].equalsIgnoreCase("0")){//si es diferente de 0
                     
                            if(cont<1){//entra aca solo si se trata de una cabeza de la matriz
            
                            Cabezas.add(matriz[j][i]);
                            cont++;
                            nuevoCCOLUMNAS.add(cont3);
                         
                            }cont3++;
                     
                        nuevoVALORES.add(matriz[j][i]);
                        //nuevoCCOLUMNAS.add(j);
                        nuevoFILAS.add(j);
                 
                 
                       }else{cont2++;
                 
                    if(cont2==tamañofila){
                 
                     columnasVacias.add(b);
                     
                     }
                 
                 }
              }cont=0;
              cont2=0;
             }nuevoCCOLUMNAS.add(nuevoVALORES.size());
        
         
    
         
         
                      //nuevoCCOLUMNAS.add(nuevoVALORES.size());
                      
                       time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
                   System.out.println("Tiempo para obtener la representacion comprimida\n por columnas para matriz modificada de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
                


         }
         
          public static void createFileRepresentation(String route){//CREA UN ARCHIVO CON LA REPRESENTACION COORDENADA
        try{      
            
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            generateRepresentation(archivo,escribir); 

            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            //System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

            escribir.close();
        }catch(Exception e){      
            System.out.println("Error al escribir");
        }
    }
          
          public static void generateRepresentation(File archivo, FileWriter escribir) throws IOException{
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("VALORES: "+Listavaloresx.toString()); 
            
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("FILAS: "+ListaFilas.toString()); 
            
            escribir.write(System.getProperty("line.separator"));
           // CCOLUMNAS.remove(CCOLUMNAS.size()-1);
            //CCOLUMNAS.add(Listavaloresx.size());
            //CCOLUMNAS.lastIndexOf(tamañocolumna);
            escribir.write("C. COLUMNAS: "+Arrays.toString(CCOLUMNAS2.toArray())); 
    }
           public static void generateRepresentation2(File archivo, FileWriter escribir) throws IOException{
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("VALORES: "+nuevoVALORES.toString()); 
            
            escribir.write(System.getProperty("line.separator"));       
            escribir.write("FILAS: "+nuevoFILAS.toString()); 
            
            escribir.write(System.getProperty("line.separator"));
           // CCOLUMNAS.remove(CCOLUMNAS.size()-1);
            //CCOLUMNAS.add(Listavaloresx.size());
            //CCOLUMNAS.lastIndexOf(tamañocolumna);
            
            escribir.write("C. COLUMNAS: "+Arrays.toString(nuevoCCOLUMNAS.toArray())); 
    }
         
          
          
          public static void MATRIZATXT(String[][] matri,String route){
  	    ///MATRIZ A TXT
            FileWriter fw = null;
   
  	           long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
   	    try {
    	    fw = new FileWriter(route+".txt");
    	
      	    for (int j=0; j<matri.length; j++){
           
            for(int z = 0; z<matri[0].length; z++){
        	fw.write(matri[j][z]+" ");
      	    }
            fw.write(System.getProperty("line.separator")); //nueva línea
        
    	    }
                  } catch (IOException e) {
     	    e.printStackTrace();
  	    }
  	    finally{
     	        if (fw!=null){
        	try {
           	fw.close();
        	} catch (IOException e) {
            	e.printStackTrace();
        	}
        	fw = null;
     	}
  	}
            
            
            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
          //  System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
}
          
          
             public static void createFileRepresentation2(String route){//CREA UN ARCHIVO CON LA REPRESENTACION COORDENADA
        try{      
            
            File archivo=new File(route+".txt");                        
            FileWriter escribir=new FileWriter(archivo,true);    
            long time=0; //Variable para tomar el tiempo total de ejecucion
            long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo 
            generateRepresentation2(archivo,escribir); 

            time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
           // System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");

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
              public static void ObtieneColumnaAuxiliar(String Ncolumna){
             //metodo auxiliar pero hace lo mismo que ObtieneColumna
            ArrayList<String> ValorColumna = new ArrayList<>();
            columnasX = new int[tamañofila];
             
             
             
             int resta = 0;
             int contadorC = 0;
             
          
            int z,y,q,w;
            z = Integer.parseInt(Ncolumna);
            
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
            
            if(z<CCOLUMNAS2.size()-1){//Este if tiene como fin evitar el desborde y que la variable z(numero de columna)
                //siempre este sobre el tamaño de las ccolumnas-1 en caso de else se sabe que ya son columnas de 0 las siguientes
            y = Integer.parseInt(Ncolumna+1);
            q = CCOLUMNAS2.get(z);
            w = CCOLUMNAS2.get(z+1);
     
                
                 resta =w-q;
                
                if(resta!=0){
                int conta = q;
                int contadorx = 0;
                    for(int i = 0; i<matriz.length; i++){
                    if(contadorx<resta){
                        String ii;
                        
                        ii = Integer.toString(i);
                        // jj =  Integer.parseInt(ccolumnas.get(z));     
                        if(q<ListaFilas.size()){
                        if(ii.equalsIgnoreCase(ListaFilas.get(q)) && contadorx<resta){
                           
                            int cast;
                            cast = Integer.parseInt(Listavaloresx.get(conta));
                            columnasX[contadorC] = cast;
                            contadorC++;
                            conta++;
                            contadorx++;
                            q++;
                        }else{columnasX[contadorC] = 0;
                        contadorC++;}
                    }else{};  
                    }else{columnasX[contadorC] = 0;
                        contadorC++;}
                    }
                  
                }else{
                    
                    for(int l = 0; l<matriz.length; l++){
                       columnasX[l] = 0;
                        
                    }
                }
                ////
            
            }else{ if(z<matriz[0].length){
            // se hace un if para saber si la columna que entra es menor al tamaño de columnas de la matriz
            //ya que los valores que toma z aca estan afuera del ccolumnas entonces ya son columnas de 0s
            //ejemplo si mete una columna donde hay solo 0s y el ccolumnas no la tiene en cuenta por ser la ultima o
            //alguna de las ultimas entonces este for el siguiente se encarga de llenarla de 0s porque el ccolumnas no la tendra en cuenta si 
            //la siguiente columna es de 0s y estas columnas de 0s finalizan la matriz
            //ejemplo 1 2 0 0 0
            //        1 2 0 0 0
            for( int l = 0; l<matriz.length; l++){
            
                columnasX[l] = 0;
                       
                
            }
                
                
            }else{
               
             JOptionPane.showMessageDialog(null,"La columna no existe");
            }
            }
         
          
            
              time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
              //System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
            //System.out.print(Arrays.toString(columnasX));
        
        
        }
              
               public static void ObtenerFilaAuxiliar(String Nfila){
        //metodo auxiliar para sacar la matriz al cuadrado igual a Obtenerfila
          ArrayList<String> ye = new ArrayList<>();
          filasX = new int[tamañocolumna];
          int valorenCC = 0;
        
          int valorenCC1 = 0;
         int contador = 0;
          int resta = 0;
          
      
              int count = 0;
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
              for(int j=0; j<CCOLUMNAS2.size()-1; j++){
                
                  if(j<Listavaloresx.size()-1){
                  valorenCC= CCOLUMNAS2.get(j);
                valorenCC1 = CCOLUMNAS2.get(j+1);
                resta = valorenCC1-valorenCC;
              
                if(resta!=0){
              
                      for(int i = valorenCC; i<valorenCC+resta; i++){
                      if(i<ListaFilas.size()){
                          if(ListaFilas.get(i).equalsIgnoreCase(Nfila)){
                            int cast;
                            cast = Integer.parseInt(Listavaloresx.get(i));
                              filasX[contador] = cast;
                             count++;
                             contador++;
                          }
                      }else{}
                      }
                      if(count==1){count=0;
                      
                      }else{filasX[contador] = 0;
                      contador++;
                      count=0;}
                      
             
              }else{
                resta=0;
                filasX[contador] = 0;
                contador++;
                 }
              }
              }
               
           
        
          
         
              time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
            //  System.out.println("Tiempo para obtener la suma de matrices dada la representacion comprimida\n por filas para matriz de tamaño: "+matriz.length+" es de: "+ time+" milisegundos");
         
            }
               
               
               public static void MatrizCuadrada(String route){
               //SACA LA CUADRADA DE UNA MATRIZ
                ArrayList<Integer> Mcuadrada = new ArrayList<>();
                   long time=0; //Variable para tomar el tiempo total de ejecucion
                   long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
              
                   if(tamañocolumna!=tamañofila){
                   JOptionPane.showMessageDialog(null, "La matriz no es cuadrada, por lo tanto no se puede multiplicar consigo mismo :'v", "NOTIFICACION", 0, FadaImage);
                   
                   }else{
                   
                   for(int i=0;i<tamañocolumna;i++){
                       for(int j=0;j<tamañofila;j++){
                           String si,sj;
                           si = Integer.toString(i);
                           sj = Integer.toString(j);
                            
                           ObtenerFilaAuxiliar(sj);
                           ObtieneColumnaAuxiliar(si);
                         
                                  
                                    if(multiplicador(filasX,columnasX) != 0){
                                    
                       Mcuadrada.add(multiplicador(filasX,columnasX));
                   }
                       }
                   
                       
                   }
                   
                   }
                   
                    time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
                    System.out.println("Tiempo para obtener la representacion de la matriz cuadrada de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
                   
                     try{    
                    
                    File archivo=new File(route+".txt");                        
                    FileWriter escribir=new FileWriter(archivo,true);    
                    escribir.write(System.getProperty("line.separator"));
                    escribir.write("VALORES: "+Arrays.toString(Mcuadrada.toArray())); 

                    escribir.write(System.getProperty("line.separator"));       
                    escribir.write("FILAS: "+Arrays.toString(ListaFilas.toArray())); 

                    escribir.write(System.getProperty("line.separator"));
                   // listaCFilas.remove(CCOLUMNAS2.size()-1);
                    //listaCFilas.add(listaValores.size());
                    //listaCFilas.lastIndexOf(filas);
                    escribir.write("C. COLUMNAS: "+Arrays.toString(CCOLUMNAS2.toArray())); 

                    escribir.close();
              
              }catch(Exception e){                     
                  System.out.println("Error al escribir");             
              } 
               }

               
              public static void ObtenerMatrizT(ArrayList<String> valores, ArrayList<String> filas,ArrayList<Integer> ccolumnas,String route){
        //Obtiene la matriz apartir de su representacion crea la matriz como tal en un arreglo doble
            //Basicamente lleno mi Tmatriz de forma contraria a como lo hago con obtenermatrioz normal para sacar la traspusta
          int cont = 0;
          
          int v = 0;
          int v1 = 0;
         int contador = 0;
         int contador1 = 0;
          int resta = 0;
          String jj = "";
          
           long time=0; //Variable para tomar el tiempo total de ejecucion
           long startTime = System.currentTimeMillis(); //Tiempo inicial del ciclo
          for(int i=0; i<matriz[0].length; i++){
                 if(i<ccolumnas.size()-2){//evitar desborde ya que si se pasa de aca es porque las demas columnas son de os
            contador1=1;
            v= ccolumnas.get(i);
            v1 = ccolumnas.get(i+1);
           resta = v1-v;
             int cont2 = 0;
           if(resta!=0){//indica si las columna es vacia
               
               
              for(int j=0; j<matriz.length; j++){//recorre filas
                  contador=j;
             if(cont2<resta){//evita desborde
                if(cont!=filas.size()){//evita desborde
                 jj = Integer.toString(j);
                  if(jj.equalsIgnoreCase(filas.get(cont))){//
                  
                      //matriz[j][i] =  valores.get(cont);
                      Tmatriz[i][j] = valores.get(cont);//me llena Tmatriz de forma inversa evito el desborde con el if de la linea 898 ya que el tamaño de filas y columnas cuando no es igual genera ese problema
                      cont2++;// ya que si se sale del tamaño de ccolumnas -2 es porque las columnas son de 0s 
                      cont++;
                  }else{ 
                   Tmatriz[i][j] = "0";
                  }
                }

              }else{
                   Tmatriz[i][j] = "0";
             }
              
              }
             
          }else{
           
               for(int p=0; p<matriz.length; p++){
              System.out.print(i);
                Tmatriz[i][p] = "0";
                   
               }
               
               
               
           }
          }else{for(int p=0; p<matriz.length; p++){
               //impirme los 0s que no estan en ccolumnas
              
                Tmatriz[i][p] = "0";
                   
               }}
         
          
          }
         
          time+=((System.currentTimeMillis()-startTime)); //Tiempo total del ordenamiento
          System.out.println("Tiempo para obtener la representacion de la matriz \n de tamaño: "+matriz.length+"   "+matriz[0].length+"  es de: "+ time+" milisegundos");
          ///////////////////////////////////////////////////////
    
         // GraficaMatriz(Tmatriz);
         MATRIZATXT(Tmatriz,route);//se imprime la matriz traspuesta dibujada
        
       CCOLUMNAS(Tmatriz);//llamo a ccolumnas para sacar la representacion
          
              try{    
                    
                    File archivo=new File(route+".txt");                        
                    FileWriter escribir=new FileWriter(archivo,true);    
                    escribir.write(System.getProperty("line.separator"));
                    escribir.write("VALORES: "+Arrays.toString(Listavaloresx.toArray())); 

                    escribir.write(System.getProperty("line.separator"));       
                    escribir.write("FILAS: "+Arrays.toString(ListaFilas.toArray())); 

                    escribir.write(System.getProperty("line.separator"));
                  
                    escribir.write("C. COLUMNAS: "+Arrays.toString(CCOLUMNAS2.toArray())); 

                    escribir.close();
              
              }catch(Exception e){                     
                  System.out.println("Error al escribir");             
              } 
          
        }    
    
     
    
    
}
