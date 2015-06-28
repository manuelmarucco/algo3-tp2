package vista.Actions.accionesVentanaJugador;

import vista.sonido.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBotonSonido implements ActionListener {
    Sound soundtrack;

    public AccionBotonSonido(Sound soundtrack){
        this.soundtrack = soundtrack;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(soundtrack.isPlaying()){
            soundtrack.stop();
        }else
            soundtrack.playLoop();

    }
}
