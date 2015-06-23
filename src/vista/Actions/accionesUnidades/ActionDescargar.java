package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.UnidadTransporte;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionDescargar implements ActionListener, AccionUnidad {
    private UnidadTransporte unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionDescargar(UnidadTransporte unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionYaActuo, ExcepcionNoSePudoAgregarAlMapa {
        unidad.descargar(coordenada);
        wraperAccionActuar.setAccionActuar(null);
    }
}
