package vista.Actions.accionesConstruir.AccionConstruirEdificiosProtoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.auxiliares.jugador.BotoneraDeConstruccionesProtoss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionConstruirAsimilador implements AccionConstruir,ActionListener {
    BotoneraDeConstruccionesProtoss botonera;

    public AccionConstruirAsimilador(BotoneraDeConstruccionesProtoss botonera) {
        this.botonera = botonera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonera.setAccionConstruirEnEspera(this);
    }

    @Override
    public void construirEn(Coordenadas coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        botonera.getJugador().construirAsimilador(coordenada);
        botonera.setAccionConstruirEnEspera(null);
    }
}