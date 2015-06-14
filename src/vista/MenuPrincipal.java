package vista;

import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton jugarBoton;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        //configuracion del boton "Jugar"
        jugarBoton.setIcon(new ImageIcon("images/menu/botonJugar.png"));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
        jugarBoton.setBorder(null);
        jugarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearJugador jugador1 = new CrearJugador();
                jugador1.Mostra();
                JButton c = (JButton) (e.getSource());
                c.setVisible(false);
            }
        });

        //configuracion del fondo de pantalla
        this.add(background);
    }

    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setVisible(true);
    }
    private void createUIComponents() throws IOException, FontFormatException {
        imageBackground = new ImagePanel("images/menu/background.jpg",1280,720);
    }


}