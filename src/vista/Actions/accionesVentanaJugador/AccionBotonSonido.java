package vista.Actions.accionesVentanaJugador;

import vista.sonido.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBotonSonido implements ActionListener {
    private Sound soundtrack;
    private Boolean accionSilenciarSonido;

    public AccionBotonSonido(Sound soundtrack){
        this.soundtrack = soundtrack;
        accionSilenciarSonido = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (soundtrack.isPlaying()) {
            boton.setIcon(new ImageIcon("images/menu/botonSonido/soundOn.png"));
            accionSilenciarSonido = true;
            soundtrack.stop();
        } else{
             boton.setIcon(new ImageIcon("images/menu/botonSonido/soundOff.png"));//se el pone la imagen de soundOff porque el usuario ve que el boton silencia el sonido
             accionSilenciarSonido = false;
             soundtrack.playLoop();
         }
    }

    public boolean isAccionSilenciarOn(){
        return accionSilenciarSonido;
    }
}
