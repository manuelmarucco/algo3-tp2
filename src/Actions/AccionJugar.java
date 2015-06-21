package Actions;

import jugabilidad.Juego;
import vista.CrearJugador;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionJugar implements ActionListener {

        Juego juego;
        String nombreUsado;
    private VentanaJugador ventana1;
    private VentanaJugador ventana2;

    public AccionJugar(Juego juego){
            this.juego = juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            nombreUsado= new String();
            JButton c = (JButton) (e.getSource());
            c.setVisible(false);
            ventana1=this.crearJugador("Crear Jugador 1");
            ventana2=this.crearJugador("Crear Jugador 2");
            ventana1.setVisible(true);
            ventana1.pack();
            ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ventana1.setExtendedState(JFrame.MAXIMIZED_HORIZ);
            ventana2.setVisible(true);
            ventana2.pack();
            ventana2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ventana2.setExtendedState(JFrame.MAXIMIZED_HORIZ);

        }

        private VentanaJugador crearJugador(String tituloJugador){
            CrearJugador crearJugador = new CrearJugador(juego,tituloJugador,nombreUsado);
            crearJugador.mostrar();
            nombreUsado=crearJugador.getNombreJugador();
            return crearJugador.getVentana();
        }
}
