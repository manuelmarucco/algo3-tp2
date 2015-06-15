package Actions;

import jugabilidad.Juego;
import vista.CrearJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionJugar implements ActionListener {

        Juego juego;

        public AccionJugar(Juego juego){
            this.juego = juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.crearJugador("Crear Jugador 2");
            this.crearJugador("Crear Jugador 1");

            JButton c = (JButton) (e.getSource());
            c.setVisible(false);

        }

        private void crearJugador(String tituloJugador){
            CrearJugador jugador = new CrearJugador(juego,tituloJugador);
            jugador.mostrar();
        }
}
