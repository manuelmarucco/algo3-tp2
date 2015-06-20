package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;
import java.awt.*;

public class PanelUnidadGuerrera extends PanelUnidad{

    private JLabel danioTerrestre;
    private JLabel danioAereo;
    private  JLabel rangoAtaque;


    public PanelUnidadGuerrera(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panel);

    }

    @Override
    protected void crearLabels() {
        super.crearLabels();
        danioTerrestre = new JLabel();
        danioAereo = new JLabel();
        rangoAtaque = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();
        JPanel paneldanioTerrestre = new JPanel();
        JPanel paneldanioAereo = new JPanel();
        JPanel panelrangoAtaque = new JPanel();

        paneldanioTerrestre.setLayout(new BoxLayout(paneldanioTerrestre, BoxLayout.X_AXIS));
        paneldanioAereo.setLayout(new BoxLayout(paneldanioAereo, BoxLayout.X_AXIS));
        panelrangoAtaque.setLayout(new BoxLayout(panelrangoAtaque, BoxLayout.X_AXIS));


        paneldanioTerrestre.add(new JLabel("Danio Terrestre:  "));
        paneldanioTerrestre.add(danioTerrestre);


        paneldanioAereo.add(new JLabel("Danio Aereo:  "));
        paneldanioAereo.add(danioAereo);


        panelrangoAtaque.add(new JLabel("Rango De Ataque:  "));
        panelrangoAtaque.add(rangoAtaque);

        panel.add(paneldanioTerrestre);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(paneldanioAereo);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(panelrangoAtaque);
        panel.add(Box.createRigidArea(new Dimension(10,10)));

    }

    public void setDanioTerrestre(String string){
        danioTerrestre.setText(string);
    }

    public void setDanioAereo(String string){
        danioAereo.setText(string);
    }

    public void setRangoAtaque(String string){
        rangoAtaque.setText(string);
    }

}
