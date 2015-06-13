package vista;

import vista.auxiliares.IconoColor;

import javax.swing.*;
import java.awt.*;

public class CrearJugador extends JFrame {
    private JComboBox Raza;
    private JPanel panel1;
    private JTextField Nombre;
    private JComboBox color;

    private void init(){
        this.add(panel1);
        Raza.addItem("Terran");
        Raza.addItem("Protoss");
        Icon icon = new IconoColor(java.awt.Color.red,"rojo");
        color.addItem(icon);
        icon = new IconoColor(java.awt.Color.BLUE,"azul");
        color.addItem(icon);
        icon = new IconoColor(Color.GREEN,"verde");
        color.addItem(icon);
        icon = new IconoColor(Color.YELLOW,"amarillo");
        color.addItem(icon);
        icon = new IconoColor(Color.CYAN,"cian");
        color.addItem(icon);
    }

    public CrearJugador(){
        this.init();
    }

    public static void main(String[] args){
        CrearJugador cj = new CrearJugador();
        cj.pack();
        cj.setVisible(true);
    }
}

