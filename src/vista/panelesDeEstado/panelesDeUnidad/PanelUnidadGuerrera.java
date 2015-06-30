package vista.panelesDeEstado.panelesDeUnidad;

import unidades.UnidadGuerrera;
import unidades.protoss.ResistenciaProtoss;

import javax.swing.*;
import java.awt.*;

public class PanelUnidadGuerrera extends PanelUnidad{

    private JLabel danioTerrestre;
    private JLabel danioAereo;
    private  JLabel rangoAtaqueTerrestre;
    private  JLabel rangoAtaqueAereo;
    private UnidadGuerrera unidadGuerrera;


    public PanelUnidadGuerrera(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panelPrincipal);

    }

    @Override
    protected void crearLabels() {
        super.crearLabels();
        danioTerrestre = new JLabel();
        danioAereo = new JLabel();
        rangoAtaqueTerrestre = new JLabel();
        rangoAtaqueAereo = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();
        JPanel paneldanioTerrestre = new JPanel();
        JPanel paneldanioAereo = new JPanel();
        JPanel panelrangoAtaqueTerrestre = new JPanel();
        JPanel panelrangoAtaqueAereo = new JPanel();
        JLabel tituloDanioTerrestre = new JLabel("Danio Terrestre:");
        JLabel tituloDanioAereo = new JLabel("Danio Aereo:");
        JLabel tituloRangoAtaqueTerrestre = new JLabel("Rango De Ataque Terrestre:");
        JLabel tituloRangoAtaqueAereo = new JLabel("Rango De Ataque Aereo:");

        paneldanioTerrestre.setLayout(new BoxLayout(paneldanioTerrestre, BoxLayout.X_AXIS));
        paneldanioTerrestre.setOpaque(false);
        paneldanioAereo.setLayout(new BoxLayout(paneldanioAereo, BoxLayout.X_AXIS));
        paneldanioAereo.setOpaque(false);
        panelrangoAtaqueTerrestre.setLayout(new BoxLayout(panelrangoAtaqueTerrestre, BoxLayout.X_AXIS));
        panelrangoAtaqueTerrestre.setOpaque(false);
        panelrangoAtaqueAereo.setLayout(new BoxLayout(panelrangoAtaqueAereo, BoxLayout.X_AXIS));
        panelrangoAtaqueAereo.setOpaque(false);


        this.setearFuenteDeJLabel(tituloDanioTerrestre,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloDanioAereo,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloRangoAtaqueTerrestre,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloRangoAtaqueAereo,true,Font.BOLD,12);

        paneldanioTerrestre.add(tituloDanioTerrestre);
        danioTerrestre.setForeground(new Color(200,200,20));
        paneldanioTerrestre.add(danioTerrestre);


        paneldanioAereo.add(tituloDanioAereo);
        danioAereo.setForeground(new Color(200,200,20));
        paneldanioAereo.add(danioAereo);


        panelrangoAtaqueTerrestre.add(tituloRangoAtaqueTerrestre);
        rangoAtaqueTerrestre.setForeground(new Color(200,200,20));
        panelrangoAtaqueTerrestre.add(rangoAtaqueTerrestre);

        panelrangoAtaqueAereo.add(tituloRangoAtaqueAereo);
        rangoAtaqueAereo.setForeground(new Color(200,200,20));
        panelrangoAtaqueAereo.add(rangoAtaqueAereo);

        panelPrincipal.add(paneldanioTerrestre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(paneldanioAereo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(panelrangoAtaqueTerrestre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(panelrangoAtaqueAereo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));

    }

    public void setDanioTerrestre(String string){
        danioTerrestre.setText(string);
    }

    public void setDanioAereo(String string){
        danioAereo.setText(string);
    }

    public void setRangoAtaqueTerrestre(String string){
        rangoAtaqueTerrestre.setText(string);
    }
    public void setRangoAtaqueAereo(String string){
        rangoAtaqueAereo.setText(string);
    }

    public void cargarDatosActualizables(UnidadGuerrera unidadGuerrera){
        this.unidadGuerrera = unidadGuerrera;
        this.setVida(String.valueOf(unidadGuerrera.getVida()));
        if(escudo.isVisible()){
            this.setEscudo(String.valueOf(((ResistenciaProtoss) unidadGuerrera.getResistencia()).getEscudoActual()));
        }
    }
    @Override
    public void repaint(){
        if(unidadGuerrera!= null) {
            this.cargarDatosActualizables(this.unidadGuerrera);
        }
    }

}
