package vista.Actions;

import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.CrearJugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.VentanaJugadorProtoss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProtoss implements ActionListener {
    private final Coordenadas coordenadas;
    private VentanaJuego ventanaJuego;
    private String nombreUsado;
    private CrearJugador form;

    public CrearProtoss(VentanaJuego ventanaJuego,CrearJugador form,String nombreUsado,Coordenadas coordenadas) {
        this.ventanaJuego=ventanaJuego;
        this.form=form;
        this.nombreUsado=nombreUsado;
        this.coordenadas=coordenadas;
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
        JugadorProtoss jugador = ventanaJuego.getJuego().crearJugadorProtoss(form.getNombreJugador(), form.getColorJugador());
        nombreUsado=form.getNombreJugador();
        form.setVentana(new VentanaJugadorProtoss( jugador, ventanaJuego));
        form.dispose();
    }
}
