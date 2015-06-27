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
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class PanelAcciones extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel;
    private WraperAccionActuar accionActuarEnEspera;

    public  PanelAcciones(WraperAccionActuar accionActuarEnEspera){
        this.accionActuarEnEspera=accionActuarEnEspera;
        init();
    }

    private void init() {
        this.add(panel);
        this.limpiar();
    }

    public void limpiar(){
        for( ActionListener al : button1.getActionListeners() ) {
            button1.removeActionListener(al);
        }
        for( MouseListener al : button1.getMouseListeners() ) {
            button1.removeMouseListener(al);
        }
        button1.setEnabled(false);
        button1.setVisible(false);
        for( ActionListener al : button2.getActionListeners() ) {
            button2.removeActionListener(al);
        }
        for( MouseListener al : button2.getMouseListeners() ) {
            button2.removeMouseListener(al);
        }
        button2.setEnabled(false);
        button2.setVisible(false);
        for( ActionListener al : button3.getActionListeners() ) {
            button3.removeActionListener(al);
        }
        for( MouseListener al : button3.getMouseListeners() ) {
            button3.removeMouseListener(al);
        }
        button3.setEnabled(false);
        button3.setVisible(false);
    }

    public void configurarBotones(UnidadGuerrera unidad){
        this.limpiar();
        button1.setText("Mover");
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        button2.setText("Atacar");
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionAtacar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(NaveCiencia unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        button1.setText("Mover");
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionEmp(unidad, accionActuarEnEspera));
        button2.setText("EMP");
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addMouseListener(new ActionRadiacion(unidad, accionActuarEnEspera));
        button3.setText("Radiacion");
    }

    public void configurarBotones(UnidadTransporte unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.setText("Mover");
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.setText("Cargar");
        button2.addMouseListener(new ActionCargar(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.setText("Descarga");
        button3.addMouseListener(new ActionDescargar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(AltoTemplario unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        button1.setText("Mover");
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionTormentaPsionica(unidad, accionActuarEnEspera));
        button2.setText("Tormenta psionica");
        // Boton 3 -----------------------------------------------------------------------------------------------------
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addMouseListener(new ActionAlucinacion(unidad, accionActuarEnEspera));
        button3.setText("Alucinacion");
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
        this.button2.setText("Entrenar Dragon");
        this.button2.addMouseListener(new ActionEntrenarDragon(unidad));
    }

    public void configurarBotones(ArchivosTemplarios unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar Alto Templario");
        this.button1.addMouseListener(new ActionEntrenarAltoTemplario(unidad));
    }

    public void configurarBotones(PortalEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar Scout");
        this.button1.addMouseListener(new ActionEntrenarScout(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.setText("Entrenar Nave de Transporte");
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteProtoss(unidad));
    }

    public void configurarBotones(Barraca unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar Marine");
        this.button1.addMouseListener(new ActionEntrenarMarine(unidad));
    }

    public void configurarBotones(Fabrica unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar Golliat");
        this.button1.addMouseListener(new ActionEntrenarGolliat(unidad));
    }

    public void configurarBotones(PuertoEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.setText("Entrenar Nave Ciencia");
        this.button1.addMouseListener(new ActionEntrenarNaveCiencia(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.setText("Entrenar Nave de Transporte");
        this.button3.addMouseListener(new ActionEntrenarNaveTransporteTerran(unidad));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.setText("Entrenar Espectro");
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
