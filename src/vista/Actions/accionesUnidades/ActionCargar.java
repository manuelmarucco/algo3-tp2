package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Unidades.ExcepcionCargaSuperada;
import excepciones.Unidades.ExcepcionCargarUnidadEnemiga;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.UnidadTransporte;
import vista.Actions.WraperAccionActuar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionCargar implements MouseListener, AccionUnidad {
    private UnidadTransporte unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionCargar(UnidadTransporte unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wraperAccionActuar.setAccionActuar(this);
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

    @Override
    public void actuarEn(Coordenada coordenada) throws ExcepcionCargarUnidadEnemiga, ExcepcionCargaSuperada, ExcepcionCasillaVacia, ExcepcionYaActuo {
        unidad.cargar(coordenada);
        wraperAccionActuar.setAccionActuar(null);
    }
}
