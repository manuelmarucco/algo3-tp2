package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.NaveCiencia;
import vista.Actions.WraperAccionActuar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEmp implements MouseListener, AccionUnidad {
    private NaveCiencia unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionEmp(NaveCiencia unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
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

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo {
        unidad.EMP(coordenada);
        accionActuarEnEspera.setAccionActuar(null);
    }
}
