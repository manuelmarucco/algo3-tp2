package vista.Actions.accionesConstruir.AccionConstruirEdificiosProtoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.Actions.accionesVentanaJugador.WraperAccionConstruir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AccionConstruirAcceso implements AccionConstruir,ActionListener {
    private JugadorProtoss jugador;
    private WraperAccionConstruir accionConstruirEnEspera;

    public AccionConstruirAcceso(JugadorProtoss jugador, WraperAccionConstruir accionConstruirEnEspera) {
        this.jugador = jugador;
        this.accionConstruirEnEspera = accionConstruirEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionConstruirEnEspera.setAccionConstruir(this);
    }

    @Override
    public void construirEn(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        jugador.construirAcceso(coordenada);
        accionConstruirEnEspera.setAccionConstruir(null);
    }
}
