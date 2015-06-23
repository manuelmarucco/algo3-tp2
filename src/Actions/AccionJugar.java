package Actions;

import vista.CrearJugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionJugar implements ActionListener {

    private VentanaJuego ventanaJuego;
    private String nombreUsado;

    public AccionJugar(VentanaJuego ventanaJuego){
            this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VentanaJugador ventana1;
        VentanaJugador ventana2;

        nombreUsado= new String();
        JButton c = (JButton) (e.getSource());
        c.setVisible(false);
        ventana1=this.crearJugador("Crear Jugador 1");
        ventana2=this.crearJugador("Crear Jugador 2");

        ventanaJuego.agregarVentana(ventana1);
        ventanaJuego.agregarVentana(ventana2);


    }

    private VentanaJugador crearJugador(String tituloJugador){
        CrearJugador crearJugador = new CrearJugador(ventanaJuego,tituloJugador,nombreUsado);
        crearJugador.mostrar();
        nombreUsado=crearJugador.getNombreJugador();
        return crearJugador.getVentana();
    }
}
