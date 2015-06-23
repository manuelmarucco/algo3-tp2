package vista.Actions.accionesConstruir.AccionConstruirEdificiosTerran;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.Actions.WraperAccionConstruir;
import vista.Actions.accionesConstruir.AccionConstruir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AccionConstruirBarraca implements AccionConstruir,ActionListener {
    private JugadorTerran jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    public AccionConstruirBarraca(JugadorTerran jugador, WraperAccionConstruir accionConstruirEnEspera) {
        this.jugador = jugador;
        this.accionConstruirEnEspera = accionConstruirEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionConstruirEnEspera.setAccionConstruir(this);
    }

    @Override
    public void construirEn(Coordenadas coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        jugador.construirBarraca(coordenada);
        accionConstruirEnEspera.setAccionConstruir(null);
    }
}
