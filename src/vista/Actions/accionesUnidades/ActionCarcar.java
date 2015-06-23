package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Unidades.ExcepcionCargaSuperada;
import excepciones.Unidades.ExcepcionCargarUnidadEnemiga;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.UnidadTransporte;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCarcar implements ActionListener, AccionUnidad {
    private UnidadTransporte unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionCarcar(UnidadTransporte unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionCargarUnidadEnemiga, ExcepcionCargaSuperada, ExcepcionCasillaVacia, ExcepcionYaActuo {
        unidad.cargar(coordenada);
        wraperAccionActuar.setAccionActuar(null);
    }
}
