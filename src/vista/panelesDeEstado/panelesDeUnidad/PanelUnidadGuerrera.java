package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;
import java.awt.*;

public class PanelUnidadGuerrera extends PanelUnidad{

    private JLabel danioTerrestre;
    private JLabel danioAereo;
    private  JLabel rangoAtaqueTerrestre;
    private  JLabel rangoAtaqueAereo;


    public PanelUnidadGuerrera(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panePrincipal);

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

        paneldanioTerrestre.setLayout(new BoxLayout(paneldanioTerrestre, BoxLayout.X_AXIS));
        paneldanioAereo.setLayout(new BoxLayout(paneldanioAereo, BoxLayout.X_AXIS));
        panelrangoAtaqueTerrestre.setLayout(new BoxLayout(panelrangoAtaqueTerrestre, BoxLayout.X_AXIS));
        panelrangoAtaqueAereo.setLayout(new BoxLayout(panelrangoAtaqueAereo, BoxLayout.X_AXIS));


        paneldanioTerrestre.add(new JLabel("Danio Terrestre:  "));
        paneldanioTerrestre.add(danioTerrestre);


        paneldanioAereo.add(new JLabel("Danio Aereo:  "));
        paneldanioAereo.add(danioAereo);


        panelrangoAtaqueTerrestre.add(new JLabel("Rango De Ataque Terrestre:  "));
        panelrangoAtaqueTerrestre.add(rangoAtaqueTerrestre);

        panelrangoAtaqueAereo.add(new JLabel("Rango De Ataque Aereo:  "));
        panelrangoAtaqueAereo.add(rangoAtaqueAereo);

        panePrincipal.add(paneldanioTerrestre);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panePrincipal.add(paneldanioAereo);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panePrincipal.add(panelrangoAtaqueTerrestre);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panePrincipal.add(panelrangoAtaqueAereo);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));

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

}
