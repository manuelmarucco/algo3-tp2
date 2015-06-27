package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.protoss.AltoTemplario;
import vista.Actions.WraperAccionActuar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionAlucinacion implements MouseListener, AccionUnidad {
    private AltoTemplario unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionAlucinacion(AltoTemplario unidad, WraperAccionActuar wraperAccionActuar) {
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
    public void actuarEn(Coordenada coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
        //   unidad.alucinacion(coordenada); //todo cambiar alucinacion
        wraperAccionActuar.setAccionActuar(null);
    }
}
