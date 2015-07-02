package control.Actions.accionesConstruir.AccionConstruirEdificiosTerran;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import control.Actions.accionesConstruir.AccionConstruir;
import control.Actions.accionesVentanaJugador.WraperAccionConstruir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AccionConstruirFabrica implements AccionConstruir,ActionListener {
    private JugadorTerran jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    public AccionConstruirFabrica(JugadorTerran jugador, WraperAccionConstruir accionConstruirEnEspera) {
        this.jugador = jugador;
        this.accionConstruirEnEspera = accionConstruirEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionConstruirEnEspera.setAccionConstruir(this);
    }

    @Override
    public void construirEn(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        jugador.construirFabrica(coordenada);
        accionConstruirEnEspera.setAccionConstruir(null);
    }
}