package vista.Actions.accionesConstruir.AccionConstruirEdificiosTerran;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.Actions.accionesConstruir.AccionConstruir;
import vista.auxiliares.jugador.BotoneraDeConstruccionesTerran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AccionConstruirPuertoEstelar implements AccionConstruir,ActionListener {
    BotoneraDeConstruccionesTerran botonera;

    public AccionConstruirPuertoEstelar(BotoneraDeConstruccionesTerran botonera) {
        this.botonera = botonera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botonera.setAccionConstruirEnEspera(this);
    }

    @Override
    public void construirEn(Coordenadas coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        botonera.getJugador().construirPuertoEstelar(coordenada);
        botonera.setAccionConstruirEnEspera(null);
    }
}
