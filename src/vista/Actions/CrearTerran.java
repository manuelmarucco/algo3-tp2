package vista.Actions;

import jugabilidad.Juego;
import vista.CrearJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearTerran implements ActionListener {
    private final Juego juego;
    private String nombreUsado;
    private CrearJugador form;

    public CrearTerran(Juego juego,CrearJugador form,String nombreUsado) {
        this.juego=juego;
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
        juego.crearJugadorTerran(form.getNombreJugador(),form.getColorJugador(),null);
        nombreUsado.concat(form.getNombreJugador());
        form.dispose();
    }
}
