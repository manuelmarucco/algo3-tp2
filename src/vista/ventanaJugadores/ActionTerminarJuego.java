package vista.ventanaJugadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTerminarJuego implements ActionListener {
    JFrame ventana;

    public ActionTerminarJuego(JFrame ventana){
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.dispose();
        System.exit(0);
    }
}
