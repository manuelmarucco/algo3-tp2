package vista.auxiliares.jugador;

import control.Actions.accionesVentanaJugador.AccionPasarTurno;
import vista.VentanaJuego;

import javax.swing.*;
import java.awt.*;

public class PanelTerminarTurno extends JPanel {

    private JButton terminarTurnoBoton;

    public PanelTerminarTurno(VentanaJuego ventanaJuego){
        this.init(ventanaJuego);
    }

    private void init(VentanaJuego ventanaJuego) {
        terminarTurnoBoton = new JButton();
        ImageIcon icon = new ImageIcon( "images/menu/botones/botonTerminarTurno.png" );
        Image img = icon.getImage() ;

        Image resizedimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;

        this.terminarTurnoBoton.setIcon(new ImageIcon(resizedimg));
        this.terminarTurnoBoton.setMargin(new Insets(0, 0, 0, 0));
        this.terminarTurnoBoton.addActionListener(new AccionPasarTurno(ventanaJuego));

        this.add(terminarTurnoBoton);
    }


}
