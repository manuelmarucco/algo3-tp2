package Actions;

import jugabilidad.utilidadesMapa.Coordenadas;
import vista.CrearJugador;
import vista.VentanaJuego;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionJugar implements ActionListener {

    private VentanaJuego ventanaJuego;
    private String nombreUsado;
    private String colorUsado;

    public AccionJugar(VentanaJuego ventanaJuego){
            this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VentanaJugador ventana1;
        VentanaJugador ventana2;

        nombreUsado= new String();
        colorUsado= new String();
        JButton c = (JButton) (e.getSource());
        c.setVisible(false);
        ventana1=this.crearJugador("Crear Jugador 1",new Coordenadas(4,22));
        ventana2=this.crearJugador("Crear Jugador 2",new Coordenadas(22,4));

        ventanaJuego.agregarVentana(ventana1);
        ventanaJuego.agregarVentana(ventana2);


    }

    private VentanaJugador crearJugador(String tituloJugador,Coordenadas coordenadas){
        CrearJugador crearJugador = new CrearJugador(ventanaJuego,tituloJugador,nombreUsado,colorUsado,coordenadas);
        crearJugador.mostrar();
        nombreUsado=crearJugador.getNombreJugador();
        colorUsado=crearJugador.getColorJugador();
        return crearJugador.getVentana();
    }
}
