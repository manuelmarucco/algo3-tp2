package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionMoverfueraDeRango;
import excepciones.Unidades.ExcepcionYaSeMovioLaUnidad;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coco on 20/06/15.
 */
public class ActionMover implements ActionListener, AccionUnidad {
    private Unidad unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionMover(Unidad unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionMoverfueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaSeMovioLaUnidad {
        unidad.mover(coordenada);
        accionActuarEnEspera.setAccionActuar(null);
    }
}
