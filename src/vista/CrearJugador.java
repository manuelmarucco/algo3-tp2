package vista;

import vista.Actions.SeleccionarRaza;
import vista.auxiliares.IconoColor;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CrearJugador extends JFrame {
    private JPanel panel1;
    private JComboBox raza;
    private JTextField textField1;
    private JComboBox color;
    private ImagePanel imagePanel1;
    private JLabel colorLabel;
    private JLabel razaLabel;
    private JButton aceptarButton;

    private void init(){
        aceptarButton.setIcon(new ImageIcon("src/vista/resourses/botonAceptar.png"));
        aceptarButton.setMargin(new Insets(0, 0, 0, 0));
        aceptarButton.setBorder(null);
        aceptarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        aceptarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        this.add(panel1);
        raza.addItem("Terran");
        raza.addItem("Protoss");
        raza.addActionListener(new SeleccionarRaza(this));
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
        razaLabel.setForeground(new Color(200,207,17));
        color.setFont(font);
        colorLabel.setFont(font);
        colorLabel.setForeground(new Color(200,207,17));
        textField1.setFont(font);
        aceptarButton.setFont(font);
    }

    public CrearJugador(){
        this.init();
    }

    public static void main(String[] args){
        CrearJugador cj = new CrearJugador();
        cj.pack();
        cj.setVisible(true);
    }

    private void createUIComponents() throws IOException, FontFormatException {
        imagePanel1= new ImagePanel("src/vista/resourses/bg-creador.jpg",400,300);
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }
}

