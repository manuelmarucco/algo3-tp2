package control.Actions.accionesMenu;

import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import vista.CrearJugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProtoss implements ActionListener {
    private VentanaJuego ventanaJuego;
    private String nombreUsado;
    private String colorUsado;
    private CrearJugador form;

    public CrearProtoss(VentanaJuego ventanaJuego, CrearJugador form, String nombreUsado, String colorUsado) {
        this.ventanaJuego=ventanaJuego;
        this.form=form;
        this.nombreUsado=nombreUsado;
        this.colorUsado=colorUsado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label= new JLabel();
        if(form.getNombreJugador().trim().length()<4){
            JOptionPane.showMessageDialog(label, "Ingrese un nombre con 4 o mas letras",
                    "InputError", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(form.getNombreJugador().compareTo(nombreUsado)==0){
            JOptionPane.showMessageDialog(label, "Nombre ya utilizado",
                    "InputError", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JugadorProtoss jugador = ventanaJuego.getJuego().crearJugadorProtoss(form.getNombreJugador(), form.getColorJugador());
        nombreUsado.concat(form.getNombreJugador());
        colorUsado.concat(form.getColorJugador());

        form.setVentana(new VentanaJugadorProtoss( jugador, ventanaJuego, jugador.getCoordenadaDeBase()));
        form.dispose();
    }
}
