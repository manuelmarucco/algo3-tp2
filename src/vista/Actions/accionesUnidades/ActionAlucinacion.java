package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.protoss.AltoTemplario;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAlucinacion implements ActionListener, AccionUnidad {
    private AltoTemplario unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionAlucinacion(AltoTemplario unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango {
        //   unidad.alucinacion(coordenada); //todo cambiar alucinacion
        wraperAccionActuar.setAccionActuar(null);
    }
}
