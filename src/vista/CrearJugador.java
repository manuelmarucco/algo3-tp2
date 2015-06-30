package vista;

import vista.Actions.CrearTerran;
import vista.Actions.SeleccionarRaza;
import vista.auxiliares.IconoColor;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CrearJugador extends JDialog {

    // Atributos -------------------------------------------------------------------------------------------------------

    private JPanel panel1;
    private JComboBox raza;
    private JTextField textField1;
    private JComboBox color;
    private ImagePanel imagePanel1;
    private JLabel colorLabel;
    private JLabel razaLabel;
    private JButton aceptarButton;
    private ImagePanel retrato;
    private VentanaJugador ventana;

    // Metodos publicos ------------------------------------------------------------------------------------------------

    public CrearJugador(VentanaJuego ventanaJuego, String titulo, String nombreUsado, String colorUsado){
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle(titulo);
        this.init(ventanaJuego, nombreUsado, colorUsado);
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void mostrar() {
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
    }

    public String getNombreJugador() {
        return textField1.getText();
    }

    public String getColorJugador() {
        return ((IconoColor)color.getSelectedItem()).getNombre();
    }

    public void setVentana(VentanaJugador ventana) {
        this.ventana = ventana;
    }

    public VentanaJugador getVentana() {
        return ventana;
    }

    // Metodos privados ------------------------------------------------------------------------------------------------

    private void init(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado) {

        aceptarButton.setIcon(new ImageIcon("src/vista/resourses/botonAceptar.png"));
        aceptarButton.setMargin(new Insets(0, 0, 0, 0));
        aceptarButton.setBackground(new Color(0, 0, 150, 80));
        aceptarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        aceptarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        aceptarButton.addActionListener(new CrearTerran(ventanaJuego, this, nombreUsado,colorUsuado));

        this.add(panel1);
        raza.addItem("Terran");
        raza.addItem("Protoss");
        raza.addActionListener(new SeleccionarRaza(this,retrato,ventanaJuego,colorUsuado,nombreUsado));

        this.setColoresDisponiblesParaJugador(colorUsuado);

        this.setFuenteParaLosComponentes();

    }

    private void setFuenteParaLosComponentes(){

        File font_file = new File("src/vista/resourses/StarcraftNormal.ttf");
        Font font = null;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
            font = font.deriveFont(15f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        raza.setFont(font);
        razaLabel.setFont(font);
        razaLabel.setForeground(Color.WHITE);

        color.setFont(font);
        colorLabel.setFont(font);
        colorLabel.setForeground(Color.WHITE);

        textField1.setFont(font);

        aceptarButton.setFont(font);

    }

    private void setColoresDisponiblesParaJugador(String colorUsuado){

        Icon icon;
        if(colorUsuado.compareTo("rojo")!=0) {
            icon = new IconoColor(java.awt.Color.red, "rojo");
            color.addItem(icon);
        }
        if(colorUsuado.compareTo("azul")!=0) {
            icon = new IconoColor(java.awt.Color.BLUE, "azul");
            color.addItem(icon);
        }
        if(colorUsuado.compareTo("verde")!=0) {
            icon = new IconoColor(Color.GREEN, "verde");
            color.addItem(icon);
        }
        if(colorUsuado.compareTo("amarillo")!=0) {
            icon = new IconoColor(Color.YELLOW, "amarillo");
            color.addItem(icon);
        }
        if(colorUsuado.compareTo("cian")!=0) {
            icon = new IconoColor(Color.CYAN, "cian");
            color.addItem(icon);
        }

    }

    private void createUIComponents() throws IOException, FontFormatException {
        imagePanel1= new ImagePanel("src/vista/resourses/bg-creador.jpg",400,300);
        retrato = new ImagePanel("src/vista/resourses/retratoTerran.jpg",100,152);
    }

}

