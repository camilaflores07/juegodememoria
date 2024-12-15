/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50494
 */
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Acciones extends GUI{
    //Diccionario de Variables
    static InformacionJuego I = new InformacionJuego();
    static String Validador1, Validador2;
    
    //Valida si la letra esta siendo mostrada o no 
    static boolean letraMostrada = false, letraMostrada2 = false;
    
    //Coordenadas de ambos botones en el arreglo para validacion
    static int rows1, col1, rows2, col2, Cont = 0;
    
    //Para funcion reset
    static final boolean Condicional = false; static final boolean todos = true;

    int turno = 0;
    
    void turnos(){
        if (turno == 0){
            turno = 1;
        } else {
            turno = 0;
        }
    }
    
    void actionRevolver(){
            //Funcion revuelve cartas
            I.cartasAleatorias();
            
            //Funcion restablece los botones
            resetBotones(todos);
            
            //restablece puntos
            Users.resetPuntos();
            
            //Informa al usuario
            JOptionPane.showMessageDialog(null, "Operacion Exitosa: Las cartas han sido revueltas!!!");
    }
    
    void clickButton(JButton boton, int rows,  int col){
            
            //Boton oprimido esta vacio:
            if ("".equals(boton.getText()) ){
                boton.setText(I.Letras[rows][col]);

                //Validar Respuestas
                if (letraMostrada == false){
                    letraMostrada = true;
                    
                    //Copia el string del arreglo letras al validador para validar si es correcto o no
                    Validador1 = I.Letras[rows][col];
                    
                    //Coordenadas del primer boton oprimido
                    rows1 = rows;
                    col1 = col;
                    
                    validarAccion(boton, rows1, col1, rows2, col2);
                            
                } else {
                    letraMostrada2 = true; 
                    Validador2 = I.Letras[rows][col]; 
                    rows2 = rows;
                    col2 = col;
                    
                    validarAccion(boton, rows1, col1, rows2, col2);
                }

            }
            
            //Boton oprimido esta ocupado:
            else {JOptionPane.showMessageDialog(null, "Ya seleccionaste esta carta...");}
           
    }
    
    void SalirButton(){
                JOptionPane.showMessageDialog(null, "Gracias por Jugar!!!");
                System.exit(0);
    }
    
    void deshabilitarBotones(JButton boton, int rows1,  int col1, int rows2, int col2){
        //Deshabilita los botones presionados correctos
            
            //Primer boton oprimido
            ArregloBotones[rows1][col1].setEnabled(false);
            ArregloBotones[rows1][col1].setBackground(Color.GREEN);
            
            //Segundo boton oprimido
            ArregloBotones[rows2][col2].setEnabled(false);
            ArregloBotones[rows2][col2].setBackground(Color.GREEN);
            
        
    } //anadir
    
    void validarAccion(JButton boton, int rows1, int col1, int rows2, int col2){
        
        // Valida hayan dos botones oprimidos - con un boolean
        if (letraMostrada == true && letraMostrada2 == true){
            
            //Opcion correcta
            if (Validador1.equals(Validador2)){
                //Sumar puntos a jugador
                Users.Jugadores[turno].sumarPuntos();
                
                //Mensaje al usuario
                JOptionPane.showMessageDialog(null, "Correcto!!! \nMas 3 puntos a jugador: " + Users.Jugadores[turno].getUser() + "\n Tienes: " + Users.Jugadores[turno].getPuntos() + " puntos");
                             
                deshabilitarBotones(boton, rows1, col1, rows2, col2);
                
                //Restablecen variables
                Validador1 = "";
                Validador2 = "";
                letraMostrada = false;
                letraMostrada2 = false;
            }
            
            //Opcion Incorrecta
            else { 
                //Color
                ArregloBotones[rows1][col1].setBackground(Color.red);
                ArregloBotones[rows2][col2].setBackground(Color.red);
                
                //Mensaje al usuario
                JOptionPane.showMessageDialog(null, "Incorrecto " + Users.Jugadores[turno].getUser() + "!!! \nWOMP WOMP");
                turnos();
                JOptionPane.showMessageDialog(null, "Turno de Jugador: " + Users.Jugadores[turno].getUser());
                
                //Esconder Botones erroneos
                resetBotones(Condicional);
                
                //Restablecen variables
                Validador1 = "";
                Validador2 = "";
                letraMostrada = false;
                letraMostrada2 = false;
            }
            
            //Ganar - Validar si todas las casillas estan correctas
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    
                    //Si la casilla esta deshabilitada esta correcta
                    if (!ArregloBotones[i][j].isEnabled()){
                        
                        Cont++;     // cuenta casillas deshabilitadas
                        
                    }
                }
            }
            
            //Ganar - Si cumple los requisitos manda mesnaje y restablece cartas
            if (Cont > 15){
                JOptionPane.showMessageDialog(null, "Le gana " + Users.JugadorGanador().getUser() + " con un puntaje de: " + Users.JugadorGanador().getPuntos() + " a jugador " + Users.JugadorPerdedor().getUser() + " con un puntaje de: " + Users.JugadorPerdedor().getPuntos());
                actionRevolver();
                resetBotones(todos);
                
            }
            
            Cont = 0;
            
        }
    
    }
  
    void resetBotones(boolean todo){
    //Restablece los Botones

        for (int i = 0; i < 4; i++){ //< - - Filas

            for (int j = 0; j < 4; j++){ //< - - Columnas

                if (todo){

                    //Restablece todos los botones
                    ArregloBotones[i][j].setText("");
                    ArregloBotones[i][j].setEnabled(true);
                    ArregloBotones[i][j].setBackground(Color.cyan);
                    
                } else {

                    //Restablece botones oprimidos habilitados - incorrectos
                    if(ArregloBotones[i][j].isEnabled()){
                        ArregloBotones[i][j].setText("");
                        ArregloBotones[i][j].setBackground(Color.cyan);
                    }
                }
            }
        }
    }
    
} 
    
