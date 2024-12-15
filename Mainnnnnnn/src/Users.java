/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50494
 */
public class Users {
    static User[] Jugadores = new User[2];
    int ID = 0;
    
    void agregarPlayer(String Nombre){
        Jugadores[ID] = new User(Nombre);
        ID++;
    }
    
    static User JugadorGanador(){
        if (Jugadores[0].getPuntos() < Jugadores[1].getPuntos()){
            return Jugadores[1];
        }
        
        return Jugadores[0];
    }
    
    static User JugadorPerdedor(){
        if (JugadorGanador().getUser().equals(Jugadores[0].getUser())){
            return Jugadores[1];
        } else {
            return Jugadores[0];
        }
    }

    static void resetPuntos(){
        Jugadores[0].puntos = 0;
        Jugadores[1].puntos = 0;
    } 
}

class User {
    
    String Jugador;
    int puntos;
    
    public User(String Jugador){
        this.Jugador = Jugador;
        this.puntos = 0;
    }
    
    String getUser(){
        if (null != Jugador){
            return Jugador;
        } else {
            return "";
        }
    }
    
    int getPuntos(){
        return puntos;
    }
    
    void sumarPuntos(){
        puntos += 3;
    }
    
}