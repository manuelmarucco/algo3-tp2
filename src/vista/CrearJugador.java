package vista;

import jugabilidad.Juego;
import vista.Actions.CrearTerran;
import vista.Actions.SeleccionarRaza;
import vista.auxiliares.IconoColor;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CrearJugador extends JDialog {
    private JPanel panel1;
    private JComboBox raza;
    private JTextField textField1;
    private JComboBox color;
    private ImagePanel imagePanel1;
    private JLabel colorLabel;
    private JLabel razaLabel;
    private JButton aceptarButton;
    private ImagePanel retrato;

    public CrearJugador(Juego j, String titulo, String nombreUsado){
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle(titulo);
        this.init(j,nombreUsado);
    }

    private void init(Juego j, String nombreUsado) {
        aceptarButton.setIcon(new ImageIcon("src/vista/resourses/botonAceptar.png"));
        aceptarButton.setMargin(new Insets(0, 0, 0, 0));
        aceptarButton.setBorder(null);
        aceptarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        aceptarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        aceptarButton.addActionListener(new CrearTerran(j,this,nombreUsado));
        this.add(panel1);
        raza.addItem("Terran");
        raza.addItem("Protoss");
        raza.addActionListener(new SeleccionarRaza(this,retrato,j,nombreUsado));
        Icon icon = new IconoColor(java.awt.Color.red,"rojo");
        color.addItem(icon);
        icon = new IconoColor(java.awt.Color.BLUE,"azul");
        color.addItem(icon);
        icon = new IconoColor(Color.GREEN,"verde");
        color.addItem(icon);
        icon = new IconoColor(Color.YELLOW,"amarillo");
        color.addItem(icon);
        icon = new IconoColor(Color.CYAN,"cian");
        color.addItem(icon);
        File font_file = new File("src/vista/resourses/StarcraftNormal.ttf");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
            font = font.deriveFont(15f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    private void createUIComponents() throws IOException, FontFormatException {
        imagePanel1= new ImagePanel("src/vista/resourses/bg-creador.jpg",400,300);
        retrato = new ImagePanel("src/vista/resourses/retratoTerran.jpg",100,152);
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
        return color.getSelectedItem().toString();
    }
}

