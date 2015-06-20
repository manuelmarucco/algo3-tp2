package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;

public class PanelTerminaTurno extends JPanel {

    private JButton terminarTurnoBoton;


    public PanelTerminaTurno(){
        this.init();
    }

    private void init() {
        terminarTurnoBoton = new JButton();
        ImageIcon icon = new ImageIcon( "images/menu/botonTerminarTurno.png" );
        Image img = icon.getImage() ;

        Image resizedimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;

        this.terminarTurnoBoton.setIcon(new ImageIcon(resizedimg));
        this.terminarTurnoBoton.setMargin(new Insets(0, 0, 0, 0));
        //this.terminarTurnoBoton.addActionListener(new AccionJugar(juego));
        //this.terminarTurnoBoton.setBorder(null);

        this.add(terminarTurnoBoton);
    }


}
