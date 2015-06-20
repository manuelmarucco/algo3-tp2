package vista.auxiliares.jugador;

import unidades.UnidadGuerrera;
import unidades.UnidadTransporte;
import unidades.protoss.AltoTemplario;
import unidades.terrran.NaveCiencia;
import vista.Actions.*;

import javax.swing.*;

public class PanelAcciones extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel;

    public  PanelAcciones(){
        init();
    }

    private void init() {
        this.add(panel);
    }

    private void limpiar(){
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
        button1.addMouseListener(new ActionMover(unidad));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionAtacar(unidad));
    }

    public void configurarBotones(NaveCiencia unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionEmp(unidad));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addMouseListener(new ActionRadiacion(unidad));
    }

    public void configurarBotones(UnidadTransporte unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionCarcar(unidad));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addMouseListener(new ActionDescargar(unidad));
    }

    public void configurarBotones(AltoTemplario unidad){
        this.limpiar();
        button1.setEnabled(true);
        button1.setVisible(true);
        button1.addMouseListener(new ActionMover(unidad));
        button2.setEnabled(true);
        button2.setVisible(true);
        button2.addMouseListener(new ActionTormentaPsionica(unidad));
        button3.setEnabled(true);
        button3.setVisible(true);
        button3.addMouseListener(new ActionAlucinacion(unidad));
    }

}
