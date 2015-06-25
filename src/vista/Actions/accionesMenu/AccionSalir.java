package vista.Actions.accionesMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionSalir implements ActionListener {
    JFrame ventana;

    public AccionSalir(JFrame ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.dispose();
    }
}
