
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50494
 */
public class InformacionJuego {
   //Diccionario
    
        //Para Metodo burbuja
        public String temp;

        //Arreglo de letras
        public String[][] Letras = {
            {"A", "A", "E", "E"},
            {"B", "B", "F", "F"},
            {"C", "C", "G", "G"},
            {"D", "D", "H", "H"}
        };

        public Random R = new Random();
        public int P1 = R.nextInt(4), P2 = R.nextInt(4);
        
        
    //Funcion
    void cartasAleatorias(){
        //Arreglos asegura que numeros no se repitan
        
            //Para P2 (Coordenadas de columnas)
            int[] V = {-1, -1, -1, -1}; 
        
            //Para P1 (Coordenadas de Filas)
            int[] Vfilas = {-1, -1, -1, -1}; 
        
        // Ciclo revuele las letras dentro del arreglo
        
        //Filas - - - >
        for (int i = 0; i < 4; i++){
            
                //Columnas - - - >
                for (int j = 0; j < 4; j++){

                    //Metodo burbuja
                    temp = Letras[i][j];
                    Letras[i][j] = Letras[P1][P2];
                    Letras[P1][P2] = temp;

                    //Establecer arreglo para filtrar numeros aleatorios (Columnas)
                    V[j] = P2;     

                        //Asegurar que ningun numero se repita
                        for (int x = 0; x <3; x++){
                            
                            //Si el numero aleatorio es igual a un numero ya establecido, repite
                            if ( V[3] == P2 || V[2] == P2 || V[1] == P2 || V[0] == P2){ 
                                P2 = R.nextInt(4);
                            }
                        }
                } // < - - - Columnas

            //Establecer arreglo para filtrar numeros aleatorios (Filas)
            Vfilas[i] = P1;
           
            //Ingresa otra numero aleatorio para las fila asegurando que ningun numero se repita
            for (int x = 0; x <3; x++){
                
                //Si el numero random es igual a un numero ya establecido, repite
                if ( Vfilas[3] == P1 || Vfilas[2] == P1 || Vfilas[1] == P1 || Vfilas[0] == P1){
                    P1 = R.nextInt(4);
                }
            }

        } // < - - - Filas
        
        //Respuestas...
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(" " + Letras[i][j]);
            }
            System.out.println("");
        }
    }
   
}
