package vista;

import jugabilidad.Juego;
import vista.Actions.accionesMenu.AccionJugar;
import vista.Actions.accionesMenu.AccionSalir;
import vista.auxiliares.ImagePanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton jugarBoton;
    private JButton salirBoton;

    private VentanaJuego ventanaJuego;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {

        //inicializacion del juego en general
        ventanaJuego = new VentanaJuego(new Juego(2));

        //configuracion del boton "Jugar"
        ImageIcon boton = new ImageIcon("images/menu/botonJugar.png");
        jugarBoton.setIcon(boton);
       // jugarBoton.setPreferredSize(new Dimension(boton.getIconWidth(),boton.getIconHeight()));
        salirBoton.setBackground(new Color(0,0,150,80));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
       // jugarBoton.setBorder(null);
        jugarBoton.addActionListener(new AccionJugar(ventanaJuego));


        //configuracion del boton "Jugar"
        salirBoton.setIcon(new ImageIcon("images/menu/salirBoton.png"));
      //  salirBoton.setPreferredSize(new Dimension(boton.getIconWidth(),boton.getIconHeight()));
        salirBoton.setBackground(new Color(0,0,150,80));
        salirBoton.setMargin(new Insets(0, 0, 0, 0));
        // jugarBoton.setBorder(null);
        salirBoton.addActionListener(new AccionSalir(this));

        //configuracion del fondo de pantalla
        this.add(background);

    }

    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setVisible(true);
    }

    private void createUIComponents() throws IOException, FontFormatException {
        imageBackground = new ImagePanel("images/menu/background.jpg",1280,720);
    }

    public void soundplay(String wavefile) throws Exception {
        File soundFile = new File(wavefile);
        AudioInputStream soundIn = AudioSystem.getAudioInputStream(soundFile);
        AudioFormat format = soundIn.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip clip = (Clip)AudioSystem.getLine(info);
        clip.open(soundIn);
        clip.start();
        while(clip.isRunning())
        {
            Thread.yield();
        }

    }


}
