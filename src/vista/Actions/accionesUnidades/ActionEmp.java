package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.NaveCiencia;
import vista.Actions.WraperAccionActuar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEmp implements ActionListener, AccionUnidad {
    private NaveCiencia unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionEmp(NaveCiencia unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionActuarEnEspera.setAccionActuar(this);
    }

    @Override
    public void actuarEn(Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo {
        unidad.EMP(coordenada);
        accionActuarEnEspera.setAccionActuar(null);
    }
}
