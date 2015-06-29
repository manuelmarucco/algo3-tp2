package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import excepciones.Unidades.ExcepcionMoverfueraDeRango;
import excepciones.Unidades.ExcepcionYaSeMovioLaUnidad;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Unidad;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionMover implements MouseListener, AccionUnidad {
    private Unidad unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionMover(Unidad unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }


    @Override
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        accionActuarEnEspera.setAccionActuar(null);
        unidad.mover(coordenada);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        accionActuarEnEspera.setAccionActuar(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
