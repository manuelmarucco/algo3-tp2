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
    private WraperAccionActuar WraperAccionActuar;

    public ActionRadiacion(NaveCiencia unidad, WraperAccionActuar WraperAccionActuar){
        this.unidad = unidad;
        this.WraperAccionActuar = WraperAccionActuar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo {
        unidad.Radiacion(coordenada);
            WraperAccionActuar.setAccionActuar(null);
    }
}
