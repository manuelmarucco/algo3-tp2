package vista.panelesDeEstado.panelesDeConstruccion;

import construcciones.protoss.EdificioEnInvocacion;

import javax.swing.*;
import java.awt.*;

public class PanelEdificioEnInvocacion extends PanelConstruccion {
    private JPanel panelTiempoDeConstruccion;
    private EdificioEnInvocacion edificio;


    public PanelEdificioEnInvocacion() {
        this.inicializarPanelesPadre();
    }


    private void inicializarPanelesPadre() {
        super.crearLabels();
        super.crearPaneles();
        this.add(panelPrincipal);
    }

    private void crearPanelTiempoDeConstruccion() {
        panelTiempoDeConstruccion = new JPanel();
        JLabel tituloTiempoDeConstruccion = new JLabel("Invocando...");
        this.setearFuenteDeJLabel(tituloTiempoDeConstruccion, false, Font.TRUETYPE_FONT, 12);

        panelTiempoDeConstruccion.setLayout(new BoxLayout(panelTiempoDeConstruccion, BoxLayout.X_AXIS));
        panelTiempoDeConstruccion.setOpaque(false);
        panelTiempoDeConstruccion.add(tituloTiempoDeConstruccion);

        panelPrincipal.add(panelTiempoDeConstruccion);
    }

    public void mostrarTiempoDeConstruccion(int tiempoDeConstruccionActual, int tiempoDeConstruccionTotal) {
        this.crearPanelTiempoDeConstruccion();

        JProgressBar progressTiempoDeConstruccion = new JProgressBar(0, tiempoDeConstruccionTotal);
        progressTiempoDeConstruccion.setPreferredSize(new Dimension(190, 20));
        progressTiempoDeConstruccion.setMaximumSize(new Dimension(190, 20));
        progressTiempoDeConstruccion.setValue(tiempoDeConstruccionTotal - tiempoDeConstruccionActual);
        progressTiempoDeConstruccion.setStringPainted(true);
        progressTiempoDeConstruccion.setVisible(true);

        progressTiempoDeConstruccion.setString(String.valueOf(tiempoDeConstruccionActual) + " turnos para invocarse");
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(progressTiempoDeConstruccion);
    }

    public void cargarDatosDeEdificioEnConstruccion(EdificioEnInvocacion edificioEnInvocacion) {
        this.edificio = edificioEnInvocacion;
        this.cargarNombre(edificio.getEdificioAConvertirse().getClass().getSimpleName());
        this.cargarVida(String.valueOf(edificio.getVida()));
        this.cargarEscudo(String.valueOf(edificio.getEscudo()));
        this.mostrarTiempoDeConstruccion(edificio.getTiempoDeConstruccionActual(), edificio.getEdificioAConvertirse().getTiempoDeConstruccion());

    }

    @Override
    public void repaint() {
        if (edificio != null) {
            this.panelPrincipal.removeAll();
            this.crearLabels();
            this.crearPaneles();
            this.add(panelPrincipal);
            this.cargarDatosDeEdificioEnConstruccion(this.edificio);
        }
    }

}