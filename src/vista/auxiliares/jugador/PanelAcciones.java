package vista.auxiliares.jugador;

import construcciones.CentroDeRecoleccion;
import construcciones.CentroDeSuministros;
import construcciones.protoss.Acceso;
import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.PortalEstelar;
import construcciones.terran.Barraca;
import construcciones.terran.Fabrica;
import construcciones.terran.PuertoEstelar;
import recursos.Recurso;
import unidades.UnidadGuerrera;
import unidades.UnidadTransporte;
import unidades.protoss.AltoTemplario;
import unidades.terrran.NaveCiencia;
import vista.Actions.WraperAccionActuar;
import vista.Actions.accionesEntrenar.*;
import vista.Actions.accionesUnidades.*;

import javax.swing.*;

public class PanelAcciones extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel;
    private WraperAccionActuar accionActuarEnEspera;

    public  PanelAcciones(WraperAccionActuar accionActuarEnEspera){
        this.accionActuarEnEspera=accionActuarEnEspera;
        init();
    }

    private void init() {
        this.add(panel);
    }

    public void limpiar(){
        button1.setEnabled(false);
        button1.setVisible(false);
        button2.setEnabled(false);
        button2.setVisible(false);
        button3.setEnabled(false);
        button3.setVisible(false);
        button4.setEnabled(false);
        button4.setVisible(false);
    }

    public void configurarBotones(UnidadGuerrera unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addActionListener(new ActionAtacar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(NaveCiencia unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addActionListener(new ActionEmp(unidad, accionActuarEnEspera));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addActionListener(new ActionRadiacion(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(UnidadTransporte unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addActionListener(new ActionCarcar(unidad, accionActuarEnEspera));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addActionListener(new ActionDescargar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(AltoTemplario unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addActionListener(new ActionTormentaPsionica(unidad, accionActuarEnEspera));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addActionListener(new ActionAlucinacion(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(Acceso unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        button1.addMouseListener(new ActionEntrenarZealot(unidad));
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        button2.addMouseListener(new ActionEntrenarDragon(unidad));
    }

    public void configurarBotones(ArchivosTemplarios unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        button1.addMouseListener(new ActionEntrenarAltoTemplario(unidad));
    }

    public void configurarBotones(PortalEstelar unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarScout(unidad));
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteProtoss(unidad));
    }

    public void configurarBotones(Barraca unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        button1.addMouseListener(new ActionEntrenarMarine(unidad));
    }

    public void configurarBotones(Fabrica unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        button1.addMouseListener(new ActionEntrenarGolliat(unidad));
    }

    public void configurarBotones(PuertoEstelar unidad){
        this.limpiar();
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarNaveCiencia(unidad));
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteTerran(unidad));
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarEsprectro(unidad));
    }

    public void configurarBotones(CentroDeSuministros unidad) {
        this.limpiar();
    }

    public void configurarBotones(CentroDeRecoleccion unidad) {
        this.limpiar();
    }

    public void configurarBotones(Recurso recurso) {
        this.limpiar();
    }
}
