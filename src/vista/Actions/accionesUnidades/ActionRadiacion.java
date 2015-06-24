package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.NaveCiencia;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionRadiacion implements ActionListener, AccionUnidad {
    private NaveCiencia unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionRadiacion(NaveCiencia unidad, WraperAccionActuar WraperAccionActuar){
        this.unidad = unidad;
        this.wraperAccionActuar = WraperAccionActuar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wraperAccionActuar.setAccionActuar(this);
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo {
        unidad.Radiacion(coordenada);
        wraperAccionActuar.setAccionActuar(null);
    }
}
