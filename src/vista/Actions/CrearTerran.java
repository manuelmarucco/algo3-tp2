package vista.Actions;

import jugabilidad.RazaDeJugador.JugadorTerran;
import vista.CrearJugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.VentanaJugadorTerran;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearTerran implements ActionListener {
    private  VentanaJuego ventanaJuego;
    private String nombreUsado;
    private CrearJugador form;

    public CrearTerran(VentanaJuego ventanaJuego,CrearJugador form,String nombreUsado) {
        this.ventanaJuego=ventanaJuego;
        this.form=form;
        this.nombreUsado=nombreUsado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel label= new JLabel();
        if(form.getNombreJugador().length()<4){
            JOptionPane.showMessageDialog(label, "Ingrese un nombre con 4 o mas letras",
                    "InputError", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(form.getNombreJugador().compareTo(nombreUsado)==0){
            JOptionPane.showMessageDialog(label, "Nombre ya utilizado",
                    "InputError", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JugadorTerran jugador = ventanaJuego.getJuego().crearJugadorTerran(form.getNombreJugador(), form.getColorJugador(), null);
        nombreUsado.concat(form.getNombreJugador());
        form.setVentana(new VentanaJugadorTerran( jugador, ventanaJuego));
        form.dispose();
    }
}
