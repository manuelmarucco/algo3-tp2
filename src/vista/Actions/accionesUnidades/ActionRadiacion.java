package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.terrran.NaveCiencia;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.sonido.SonidosDelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionRadiacion implements MouseListener, AccionUnidad {
    private NaveCiencia unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionRadiacion(NaveCiencia unidad, WraperAccionActuar WraperAccionActuar){
        this.unidad = unidad;
        this.wraperAccionActuar = WraperAccionActuar;
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
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionCasillaVacia {
        unidad.Radiacion(coordenada);
        wraperAccionActuar.setAccionActuar(null);
        SonidosDelJuego.getInstance().reproducirRadiacion();
    }
}
