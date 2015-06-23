package vista.Actions.accionesConstruir.AccionConstruirEdificiosProtoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.Actions.accionesConstruir.AccionConstruir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionConstruirNexoMineral implements AccionConstruir,ActionListener {

    private JugadorProtoss jugador;
    private AccionConstruir accionConstruirEnEspera;

    public AccionConstruirNexoMineral(JugadorProtoss jugador, AccionConstruir accionConstruirEnEspera) {
        this.jugador = jugador;
        this.accionConstruirEnEspera = accionConstruirEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionConstruirEnEspera = this;
    }

    @Override
    public void construirEn(Coordenadas coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        jugador.construirNexoMineral(coordenada);
        accionConstruirEnEspera = null;
    }

}
