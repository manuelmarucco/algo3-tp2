package vista.Actions.accionesVentanaJugador;

import vista.sonido.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBotonSonido implements ActionListener {
    Sound soundtrack;

    public AccionBotonSonido(Sound soundtrack){
        this.soundtrack = soundtrack;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (soundtrack.isPlaying()) {
            boton.setIcon(new ImageIcon("images/menu/botonSonido/soundOn.png"));
            soundtrack.stop();
        } else{
             boton.setIcon(new ImageIcon("images/menu/botonSonido/soundOff.png"));
             soundtrack.playLoop();
         }
    }
}
