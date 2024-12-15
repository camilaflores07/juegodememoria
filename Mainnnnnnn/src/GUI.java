/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 50494
 */
import java.awt.*;
import javax.swing.*;

public class GUI {
    
    //Inicializar Clases
    static Acciones B = new Acciones();
    static Users U = new Users();
    
    //Configuracion de Labels
    void setTituloLabel(){
        Titulo.setSize(210, 60);
        Titulo.setForeground(Color.WHITE);
        Titulo.setFont(new Font(Titulo.getFont().getName(), Font.PLAIN, 35));
        Titulo.setText(" JUEGO DE MEMORIA ");
    }
    
    
    //Establecimiento de Botones
    void setRevolverBoton(){
        //Caracteristicas del boton
        Revolver.setSize(68, 20);
        Revolver.setBackground(Color.ORANGE);
        Revolver.setText("Revolver Cartas");
        
        //Action
        Revolver.addActionListener(e -> B.actionRevolver());
    }
    
    public JButton crearBotones(int rows, int col){
        //Crea Boton nuevo
        JButton boton = new JButton();
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font(boton.getFont().getName(), Font.PLAIN, 30));
                        
        //Agrega action listener a este boton individual
        boton.addActionListener(e -> B.clickButton(boton, rows, col));
        
        return boton;
    }
    
    void iniciarBotones(){
        for (int rows = 0; rows < 4; rows++){ // Coordenada de Filas
            
            for (int col = 0; col < 4; col++){ // Coordenada de Columnas
                
                //Llama funcion crear y lo mete en un Arreglo de botones
                ArregloBotones[rows][col] = crearBotones(rows, col);
                
                //Establece colo y agrega al panel de botonens
                ArregloBotones[rows][col].setBackground(Color.cyan);
                PanelButt.add(ArregloBotones[rows][col]);
            
            }
        }
    }
    
    void setSalirBoton(){
        //Configuracion boton salir
        Salir.setSize(68, 68);
        Salir.addActionListener(e -> B.SalirButton());
        Salir.setBackground(Color.red);
        
            //Texto de boton
            Salir.setText("Salir");
            Salir.setForeground(Color.WHITE);
            Salir.setFont(new Font(Salir.getFont().getName(), Font.PLAIN, 15));
        
    }
    
    
    //Establecimiento Paneles
     
    public String establecerJugadores(int i){
        String Nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador " + (i + 1));
        
        if (U.Jugadores[0] != null){
            if (!Nombre.equals(U.Jugadores[0].getUser())){
                U.agregarPlayer(Nombre);
                JOptionPane.showMessageDialog(null, "Usuarios agregado existosamente!");
                return Nombre;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario en uso");
                return establecerJugadores(i);
            }
        } else {
            U.agregarPlayer(Nombre);
            return Nombre;
        }
        
        
    }

    void setPanelTitulo(){
        panelTitulo.add(Titulo);
        panelTitulo.add(Revolver);
        panelTitulo.setBackground(Color.BLACK);
        panelTitulo.setLayout(new GridLayout(2, 1, 0, 5));
        
        
        setTituloLabel();
        setRevolverBoton();       
    }
    
    void setPanel2(){
        //Caracteristicas panel de abajo
        AnuncioPanel.setSize(170, 210);
        AnuncioPanel.setVisible(true);
        AnuncioPanel.setBackground(Color.GRAY);
        AnuncioPanel.setLayout(new GridLayout(3, 1, 2, 0));
        
        //Salir
        AnuncioPanel.add(Salir);
        
        //Jugador 1
        AnuncioPanel.add(new JLabel("Jugador 1: " + establecerJugadores(0)));      
        
        //Jugadore 2
        AnuncioPanel.add(new JLabel("Jugador 2: " + establecerJugadores(1)));
        
        
    }
    
    void setPanel(){
        //Caracteristicas Panel de juego
        PanelButt.setSize(210, 450);
        PanelButt.setLayout(new GridLayout(4, 4, 5, 5));
        PanelButt.setBackground(Color.BLACK);
        
        //Botones dentro de Panel de juego
        iniciarBotones();
        
        //Tamano de botones
        setSalirBoton();
    }
  
    void refresh(){
        J.removeAll();
        J.revalidate();
        J.repaint();
        
        Frame();
    }
    
    //Frame
    void Frame(){
        //Frame
        J.setSize(600,600);
        J.setVisible(true);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLayout(new GridLayout(3, 1, 0, 3));
        
        //Agregar Paneles al frame
        J.add(panelTitulo);
        J.add(PanelButt);
        J.add(AnuncioPanel);
        
        //Configuracion de paneles
        setPanel();
        setPanelTitulo();
        setPanel2();
    }
    
    
    //Frame & Panel de botones
    static JFrame J = new JFrame();
    static JPanel PanelButt = new JPanel();
    static JPanel AnuncioPanel = new JPanel();
    static JPanel panelTitulo = new JPanel();
    
        //Botones
        static JButton[][] ArregloBotones = new JButton[4][4];
        static JButton Salir = new JButton();
        static JButton Revolver = new JButton();
        
        //Labels
        static JLabel Titulo = new JLabel();
        

}

