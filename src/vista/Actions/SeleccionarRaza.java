package vista.Actions;

import vista.CrearJugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarRaza implements java.awt.event.ActionListener {

    private final CrearJugador form;

    public SeleccionarRaza(CrearJugador crearJugador){
        this.form=crearJugador;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.paramString()){
            case "protoss":
                form.getAceptarButton().addActionListener(new CrearProtoss());
                break;
            case "terran":
                form.getAceptarButton().addActionListener(new CrearTerran());
        }
    }

    private class CrearProtoss implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO:crear protoss
        }
    }

    private class CrearTerran implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO:crear terran
        }
    }
}
