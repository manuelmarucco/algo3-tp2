package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.UnidadGuerrera;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAtacar implements ActionListener, AccionUnidad {
    private UnidadGuerrera unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionAtacar(UnidadGuerrera unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
        unidad.atacar(coordenada);
        accionActuarEnEspera.setAccionActuar(null);
    }
}
