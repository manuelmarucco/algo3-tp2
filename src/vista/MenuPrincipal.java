package vista;

import Actions.AccionJugar;
import jugabilidad.Juego;
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

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        //inicializacion del juego en general
        Juego juego = new Juego();
        //configuracion del boton "Jugar"
        jugarBoton.setIcon(new ImageIcon("images/menu/botonJugar.png"));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
        jugarBoton.setBorder(null);
        //jugarBoton.setOpaque(falxse);
        jugarBoton.addActionListener(new AccionJugar(juego));
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
