package Actions;

import jugabilidad.Juego;
import vista.CrearJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionJugar implements ActionListener {

        Juego juego;
        String nombreUsado;
        public AccionJugar(Juego juego){
            this.juego = juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            nombreUsado= new String();
            JButton c = (JButton) (e.getSource());
            c.setVisible(false);
            this.crearJugador("Crear Jugador 1");
            this.crearJugador("Crear Jugador 2");
        }

        private void crearJugador(String tituloJugador){
            CrearJugador jugador = new CrearJugador(juego,tituloJugador,nombreUsado);
            jugador.mostrar();
            nombreUsado=jugador.getNombreJugador();

        }
}
