package vista.auxiliares.jugador.botones;

import control.BufferImagenes;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class CuadroInformacionRecursos extends JFrame {

    private JPanel contenedor;
    private BufferImagenes bufferImagenes;

    // Para construcciones ---------------------------------------------------------------------------------------------
    public CuadroInformacionRecursos(String cristalNecesario, String gasNecesario){

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("images/menu/boton.png")));
        this.setLayout(new FlowLayout());

        this.bufferImagenes = new BufferImagenes();

        this.contenedor = new JPanel(new GridLayout(1,3,0,1));
        this.contenedor.setOpaque(false);

        this.contenedor.add(this.armarLabelTituloCosto());
        this.contenedor.add(this.armarLabelCristaleNecesario(cristalNecesario));
        this.contenedor.add(this.armarLabelGasNecesario(gasNecesario));

        this.add(contenedor);

    }

    // Para unidades ---------------------------------------------------------------------------------------------------
    public CuadroInformacionRecursos(String cristalNecesario, String gasNecesario, String suministroNecesario){

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("images/menu/boton.png")));
        this.setLayout(new FlowLayout());

        this.bufferImagenes = new BufferImagenes();

        this.contenedor = new JPanel(new GridLayout(1,4,0,1));
        this.contenedor.setOpaque(false);

        this.contenedor.add(this.armarLabelTituloCosto());
        this.contenedor.add(this.armarLabelCristaleNecesario(cristalNecesario));
        this.contenedor.add(this.armarLabelGasNecesario(gasNecesario));
        this.contenedor.add(this.armarLabelSuministroNecesario(suministroNecesario));

        this.add(contenedor);

    }

    // Para magias -----------------------------------------------------------------------------------------------------
    public CuadroInformacionRecursos(String energiaNecesaria){

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("images/menu/boton.png")));
        this.setLayout(new FlowLayout());

        this.bufferImagenes = new BufferImagenes();

        this.contenedor = new JPanel(new GridLayout(1,2,0,1));
        this.contenedor.setOpaque(false);

        this.contenedor.add(this.armarLabelTituloCosto());
        this.contenedor.add(this.armarLabelEnergiaNecesaria(energiaNecesaria));

        this.add(contenedor);

    }

    // Metodos privados ------------------------------------------------------------------------------------------------

    private Component armarLabelTituloCosto() {
        JLabel titulo = new JLabel("Costo: ");
        titulo.setForeground(new Color(200,200,20)); Map attributes = titulo.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titulo.setFont(titulo.getFont().deriveFont(attributes));
        titulo.setOpaque(false);
        return titulo;
    }

    private JPanel armarLabelCristaleNecesario(String cristalNecesario){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon( this.bufferImagenes.obtenerImagen("iconoCristal") );
        label.setText(cristalNecesario);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

    private JPanel armarLabelGasNecesario(String gasNecesario){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon( this.bufferImagenes.obtenerImagen("iconoGas") );
        label.setText(gasNecesario);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

    private JPanel armarLabelSuministroNecesario(String suministroNecesario){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon( this.bufferImagenes.obtenerImagen("iconoSuministro") );
        label.setText(suministroNecesario);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

    private JPanel armarLabelEnergiaNecesaria(String energiaNecesaria){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon( this.bufferImagenes.obtenerImagen("iconoEnergia") );
        label.setText(energiaNecesaria);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

}
