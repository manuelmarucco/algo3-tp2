package vista.panelesDeEstado.panelesDeUnidad;

import modelo.unidades.UnidadMagica;
import modelo.unidades.protoss.ResistenciaProtoss;

import javax.swing.*;
import java.awt.*;

public class PanelUnidadMagica extends PanelUnidad {

    private JLabel energiaActual;
    private JLabel energiaTotal;
    private UnidadMagica unidadMagica;


    public PanelUnidadMagica() {
        this.crearLabels();
        this.crearPaneles();

        this.add(panelPrincipal);

    }

    @Override
    protected void crearLabels() {
        super.crearLabels();
        energiaActual = new JLabel();
        energiaTotal = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();
        JPanel panelenergiaActual = new JPanel();
        JPanel panelenergiaTotal = new JPanel();
        JLabel tituloEnergiaActual  = new JLabel("Energia Actual: ");
        JLabel tituloEnergiaTotal  = new JLabel("Energia Total: ");

        panelenergiaActual.setLayout(new BoxLayout(panelenergiaActual, BoxLayout.X_AXIS));
        panelenergiaActual.setOpaque(false);
        panelenergiaTotal.setLayout(new BoxLayout(panelenergiaTotal, BoxLayout.X_AXIS));
        panelenergiaTotal.setOpaque(false);


        this.setearFuenteDeJLabel(tituloEnergiaActual,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloEnergiaTotal,true,Font.BOLD,12);

        panelenergiaActual.add(tituloEnergiaActual);
        energiaActual.setForeground(new Color(200,200,20));
        panelenergiaActual.add(energiaActual);


        panelenergiaTotal.add(tituloEnergiaTotal);
        energiaTotal.setForeground(new Color(200,200,20));
        panelenergiaTotal.add(energiaTotal);


        panelPrincipal.add(panelenergiaActual);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(panelenergiaTotal);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));

    }

    public void setEnergiaActual(String string) {
        energiaActual.setText(string);
    }


    public void setEnergiaTotal(String string) {
        energiaTotal.setText(string);
    }

    public void cargarDatosActualizables(UnidadMagica unidadMagica){
        this.unidadMagica = unidadMagica;
        this.setVida(String.valueOf(unidadMagica.getVida()));
        this.setEnergiaActual(String.valueOf(unidadMagica.getEnergiaActual()));
        if(escudo.isVisible()){
            this.setEscudo(String.valueOf(((ResistenciaProtoss) unidadMagica.getResistencia()).getEscudoActual()));
        }
    }
    @Override
    public void repaint(){
        if(unidadMagica!= null) {
            this.cargarDatosActualizables(this.unidadMagica);
        }
    }
}
