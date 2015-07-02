package vista.auxiliares.jugador;



import modelo.construcciones.CentroDeRecoleccion;
import modelo.construcciones.CentroDeSuministros;
import modelo.construcciones.protoss.Acceso;
import modelo.construcciones.protoss.ArchivosTemplarios;
import modelo.construcciones.protoss.PortalEstelar;
import modelo.construcciones.terran.Barraca;
import modelo.construcciones.terran.Fabrica;
import modelo.construcciones.terran.PuertoEstelar;
import modelo.recursos.Recurso;
import modelo.unidades.UnidadGuerrera;
import modelo.unidades.UnidadTransporte;
import modelo.unidades.protoss.AltoTemplario;
import modelo.unidades.protoss.ClonGuerrero;
import modelo.unidades.protoss.ClonMagico;
import modelo.unidades.protoss.ClonTransporte;
import modelo.unidades.terrran.NaveCiencia;
import control.Actions.accionesEntrenar.*;
import control.Actions.accionesUnidades.*;
import control.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.auxiliares.jugador.botones.BotonConInformacionDesplegable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class PanelAcciones extends JPanel {

    private JPanel panel;

    private BotonConInformacionDesplegable button1;
    private BotonConInformacionDesplegable button2;
    private BotonConInformacionDesplegable button3;

    private WraperAccionActuar accionActuarEnEspera;

    public  PanelAcciones(WraperAccionActuar accionActuarEnEspera){
        this.accionActuarEnEspera=accionActuarEnEspera;
        this.createUIComponents();
        this.init();
    }

    private void init() {
        this.panel = new JPanel(new GridLayout(2,2,1,1));
        this.panel.setOpaque(false);

        this.panel.add(this.button1);
        this.panel.add(this.button2);
        this.panel.add(this.button3);

        this.setOpaque(false);
        this.add(panel);
        this.limpiar();
    }

    public void limpiar(){
        // Boton 1 -----------------------------------------------------------------------------------------------------
        for( ActionListener al : button1.getActionListeners() ) {
            this.button1.removeActionListener(al);
        }
        for( MouseListener al : button1.getMouseListeners() ) {
            this.button1.removeMouseListener(al);
        }
        this.button1.setEnabled(false);
        this.button1.setVisible(false);
        this.button1.eliminarInformacionDesplegable();
        // Boton 2 -----------------------------------------------------------------------------------------------------
        for( ActionListener al : button2.getActionListeners() ) {
            this.button2.removeActionListener(al);
        }
        for( MouseListener al : button2.getMouseListeners() ) {
            this.button2.removeMouseListener(al);
        }
        this.button2.setEnabled(false);
        this.button2.setVisible(false);
        this.button2.eliminarInformacionDesplegable();
        // Boton 3 -----------------------------------------------------------------------------------------------------
        for( ActionListener al : button3.getActionListeners() ) {
            this.button3.removeActionListener(al);
        }
        for( MouseListener al : button3.getMouseListeners() ) {
            this.button3.removeMouseListener(al);
        }
        this.button3.setEnabled(false);
        this.button3.setVisible(false);
        this.button3.eliminarInformacionDesplegable();
    }

    public void configurarBotones(UnidadGuerrera unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setText("Mover");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setText("Atacar");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionAtacar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(NaveCiencia unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setText("Mover");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.actualizarCaracteristicas("EMP", "100");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEmp(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.actualizarCaracteristicas("Radiacion", "75");
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.addMouseListener(new ActionRadiacion(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(UnidadTransporte unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setText("Mover");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.setText("Cargar");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionCargar(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.setText("Descarga");
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.addMouseListener(new ActionDescargar(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(AltoTemplario unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.setText("Mover");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.actualizarCaracteristicas("Tormenta psionica", "75");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionTormentaPsionica(unidad, accionActuarEnEspera));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.actualizarCaracteristicas("Alucinacion", "100");
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.addMouseListener(new ActionAlucinacion(unidad, accionActuarEnEspera));

    }

    public void configurarBotones(Acceso unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar zealot", "100", "0", "2");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarZealot(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.actualizarCaracteristicas("Entrenar Dragon", "125", "50", "2");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarDragon(unidad));
    }

    public void configurarBotones(ArchivosTemplarios unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar Alto Templario", "50", "150", "2");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarAltoTemplario(unidad));
    }

    public void configurarBotones(PortalEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar Scout", "300", "150", "3");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarScout(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.actualizarCaracteristicas("Entrenar Nave de Transporte", "200", "0", "2");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteProtoss(unidad));
    }

    public void configurarBotones(Barraca unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar Marine", "50", "0", "1");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarMarine(unidad));
    }

    public void configurarBotones(Fabrica unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar Golliat", "100", "50", "2");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarGolliat(unidad));
    }

    public void configurarBotones(PuertoEstelar unidad){
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        this.button1.actualizarCaracteristicas("Entrenar Nave Ciencia", "100", "225", "2");
        this.button1.setEnabled(true);
        this.button1.setVisible(true);
        this.button1.addMouseListener(new ActionEntrenarNaveCiencia(unidad));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        this.button2.actualizarCaracteristicas("Entrenar Nave de Transporte", "100", "100", "2");
        this.button2.setEnabled(true);
        this.button2.setVisible(true);
        this.button2.addMouseListener(new ActionEntrenarNaveTransporteTerran(unidad));
        // Boton 3 -----------------------------------------------------------------------------------------------------
        this.button3.actualizarCaracteristicas("Entrenar Espectro", "150", "100", "2");
        this.button3.setEnabled(true);
        this.button3.setVisible(true);
        this.button3.addMouseListener(new ActionEntrenarEspectro(unidad));
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

    public void configurarBotones(ClonGuerrero unidad) {
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setText("Mover");
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
        // Boton 2 -----------------------------------------------------------------------------------------------------
        button2.setText("Atacar");
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionAtacarClon(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(ClonMagico unidad) {
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setText("Mover");
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
    }

    public void configurarBotones(ClonTransporte unidad) {
        this.limpiar();
        // Boton 1 -----------------------------------------------------------------------------------------------------
        button1.setText("Mover");
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad, accionActuarEnEspera));
    }

    private void createUIComponents() {
        this.button1 = new BotonConInformacionDesplegable("a","a");
        this.button2 = new BotonConInformacionDesplegable("a","a");
        this.button3 = new BotonConInformacionDesplegable("a","a");
    }
}
