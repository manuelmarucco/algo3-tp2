package control.Actions.accionesConstruir.AccionConstruirEdificiosProtoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import control.Actions.accionesConstruir.AccionConstruir;
import control.Actions.accionesVentanaJugador.WraperAccionConstruir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionConstruirPortalEstelar implements AccionConstruir,ActionListener {
    private JugadorProtoss jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    public AccionConstruirPortalEstelar(JugadorProtoss jugador, WraperAccionConstruir accionConstruirEnEspera) {
        this.jugador = jugador;
        this.accionConstruirEnEspera = accionConstruirEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionConstruirEnEspera.setAccionConstruir(this);
    }

    @Override
    public void construirEn(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        jugador.construirPortalEstelar(coordenada);
        accionConstruirEnEspera.setAccionConstruir(null);
    }
}