package vista.Actions.accionesMenu;

import jugabilidad.utilidadesMapa.Coordenada;
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
        ventana1=this.crearJugador("Crear Jugador 1",new Coordenada(4,22)); //TODO estas coordenadas las tiene que obtener del txt de bases o del propio juego (ver en MenuPrincipal--> constructor --> new Juego(2))
        ventana2=this.crearJugador("Crear Jugador 2",new Coordenada(22,4));

        ventanaJuego.agregarVentana(ventana1);
        ventanaJuego.agregarVentana(ventana2);


    }

    private VentanaJugador crearJugador(String tituloJugador,Coordenada coordenadaDeBase){
        CrearJugador crearJugador = new CrearJugador(ventanaJuego,tituloJugador,nombreUsado,colorUsado, coordenadaDeBase);
        crearJugador.mostrar();
        nombreUsado=crearJugador.getNombreJugador();
        colorUsado=crearJugador.getColorJugador();
        return crearJugador.getVentana();
    }
}
