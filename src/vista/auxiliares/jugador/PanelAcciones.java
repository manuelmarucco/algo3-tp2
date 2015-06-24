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
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.removeAll();
        button1.setEnabled(false);
        button1.setVisible(false);
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.removeAll();
        button2.setEnabled(false);
        button2.setVisible(false);
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.removeAll();
        button3.setEnabled(false);
        button3.setVisible(false);
        // Boton 4 -----------------------------------------------------------------------------------------------------
        button4.removeAll();
        button4.setEnabled(false);
        button4.setVisible(false);

    }

    public void configurarBotones(UnidadGuerrera unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.setText("Mover");
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setText("Atacar");
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addActionListener(new ActionAtacar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(NaveCiencia unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button2.setText("Mover");
        button2.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.setText("EMP");
        button2.addActionListener(new ActionEmp(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.setText("Radiacion");
        button3.addActionListener(new ActionRadiacion(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(UnidadTransporte unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.setText("Mover");
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.setText("Cargar");
        button2.addActionListener(new ActionCarcar(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.setText("Descarga");
        button3.addActionListener(new ActionDescargar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(AltoTemplario unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.setText("Mover");
        button1.addActionListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.setText("Tormenta psionica");
        button2.addActionListener(new ActionTormentaPsionica(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.setText("Alucinacion");
        button3.addActionListener(new ActionAlucinacion(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(Acceso unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar zealot");
        this.button1.addMouseListener(new ActionEntrenarZealot(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.setText("Entrenar zealot");
        this.button2.addMouseListener(new ActionEntrenarDragon(unidad));
    }

    public void configurarBotones(ArchivosTemplarios unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar alto templario");
        this.button1.addMouseListener(new ActionEntrenarAltoTemplario(unidad));
    }

    public void configurarBotones(PortalEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar scout");
        this.button1.addMouseListener(new ActionEntrenarScout(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.setText("Entrenar nave de transporte");
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteProtoss(unidad));
    }

    public void configurarBotones(Barraca unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar marine");
        this.button1.addMouseListener(new ActionEntrenarMarine(unidad));
    }

    public void configurarBotones(Fabrica unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar golliat");
        this.button1.addMouseListener(new ActionEntrenarGolliat(unidad));
    }

    public void configurarBotones(PuertoEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar nave ciencia");
        this.button1.addMouseListener(new ActionEntrenarNaveCiencia(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.setText("Entrenar nave de transporte");
        this.button3.addMouseListener(new ActionEntrenarNaveTransporteTerran(unidad));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.setText("Entrenar espectro");
        this.button3.addMouseListener(new ActionEntrenarEsprectro(unidad));
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
