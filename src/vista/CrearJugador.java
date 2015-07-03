package vista;

import control.Actions.accionesMenu.ActionCerrarCreador;
import control.Actions.accionesMenu.CrearTerran;
import control.Actions.accionesMenu.SeleccionarRaza;
import vista.auxiliares.IconoColor;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class CrearJugador extends JDialog {

    // Atributos -------------------------------------------------------------------------------------------------------


    private JButton aceptarButton;
    private JTextField nombreField;
    private JComboBox color;
    private VentanaJugador ventana;
    private JLayeredPane contenedor;
    private JLabel background;
    private ImagePanel retrato;

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
        return nombreField.getText();
    }

    public String getColorJugador() {
        return ( (IconoColor) color.getSelectedItem()).getNombre();
    }

    public void setVentana(VentanaJugador ventana) {
        this.ventana = ventana;
    }

    public VentanaJugador getVentana() {
        return ventana;
    }

    // Metodos privados ------------------------------------------------------------------------------------------------

    private void init(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado) {

        this.configurarFondo();
        this.configurarContenedor();
        this.iniciarRetratoRaza();
        this.configurarPanelFrontal(ventanaJuego,nombreUsado,colorUsuado);

    }

    private void configurarFondo(){

        ImageIcon imageBackground = new ImageIcon("images/menu/fondos/bg-crearJugador.jpg");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, 400, 300);

    }

    private void configurarContenedor(){

        this.contenedor = new JLayeredPane();
        this.contenedor.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.contenedor.add(this.background, new Integer(50),0);

        this.add(contenedor);

    }

    private void configurarPanelFrontal(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado) {

        JPanel panelFrontal = new JPanel();
        panelFrontal.setLayout(new BoxLayout(panelFrontal, BoxLayout.Y_AXIS));
        panelFrontal.setSize(new Dimension(background.getIcon().getIconWidth(), background.getIcon().getIconHeight()));
        panelFrontal.setLocation(0, 0);
        panelFrontal.setOpaque(false);

        panelFrontal.add(this.crearPanelSuperior(ventanaJuego, nombreUsado, colorUsuado));
        panelFrontal.add(this.crearPanelCentral());
        panelFrontal.add(this.crearPanelInferior(ventanaJuego, nombreUsado, colorUsuado));

        this.contenedor.add( panelFrontal, new Integer(100), 0);

    }

    private void iniciarRetratoRaza(){

        this.retrato = new ImagePanel( "images/menu/retratos/retratoTerran.jpg", 100, 152 );

    }

    // -----------------------------------------------------------------------------------------------------------------

    private JPanel crearPanelSuperior(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado){

        JPanel panelSuperior = new JPanel( new GridLayout(1,2) );
        panelSuperior.setOpaque(false);

        panelSuperior.add( this.crearSeleccionadorDeRaza(ventanaJuego, nombreUsado, colorUsuado) );
        panelSuperior.add( this.crearSeleccionadorDeColor(colorUsuado) );

        return (panelSuperior);

    }

    private JPanel crearPanelCentral(){

        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);

        panelCentral.add( this.retrato );

        this.nombreField = new JTextField("Nombre");
        this.nombreField.setForeground(Color.YELLOW);
        this.nombreField.setOpaque(false);
        this.nombreField.setFont(new Font(nombreField.getName(), Font.BOLD, 16));
        nombreField.setPreferredSize(new Dimension(200,40));

        panelCentral.add( this.nombreField );

        return ( panelCentral );

    }

    private JPanel crearPanelInferior(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado){

        JPanel panelInferior = new JPanel();
        panelInferior.setOpaque(false);

        this.crearBotonAceptar(ventanaJuego, nombreUsado, colorUsuado);
        panelInferior.add(this.crearBotonSalir());
        panelInferior.add( this.aceptarButton );

        return (panelInferior);

    }

    // -----------------------------------------------------------------------------------------------------------------

    private JPanel crearSeleccionadorDeRaza(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado){

        JPanel seleccionadorDeRaza = new JPanel( new GridLayout(2,1) );
        seleccionadorDeRaza.setOpaque(false);

        JLabel textoRaza = new JLabel("Raza");
        textoRaza.setForeground(Color.YELLOW);
        textoRaza.setFont(new Font(textoRaza.getName(), Font.BOLD, 12));

        JComboBox selecionador = new JComboBox();
        selecionador.addItem("Terran");
        selecionador.addItem("Protoss");
        selecionador.addActionListener(new SeleccionarRaza(this,this.retrato,ventanaJuego,colorUsuado,nombreUsado));

        seleccionadorDeRaza.add(textoRaza);
        seleccionadorDeRaza.add(selecionador);

        return ( seleccionadorDeRaza );
    }

    private JPanel crearSeleccionadorDeColor(String colorUsuado){

        JPanel seleccionadorDeColor = new JPanel( new GridLayout(2,1) );
        seleccionadorDeColor.setOpaque(false);

        JLabel textoColor = new JLabel("Color");
        textoColor.setForeground(Color.YELLOW);
        textoColor.setFont(new Font(textoColor.getName(), Font.BOLD, 12));
        this.setColoresDisponiblesParaJugador(colorUsuado);

        seleccionadorDeColor.add(textoColor);
        seleccionadorDeColor.add(this.color);

        return ( seleccionadorDeColor );
    }

    private void setColoresDisponiblesParaJugador(String colorUsuado){

        this.color = new JComboBox();

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

    private void crearBotonAceptar(VentanaJuego ventanaJuego, String nombreUsado, String colorUsuado){

        this.aceptarButton = new JButton();
        this.aceptarButton.setSize(new Dimension(150, 26));

        aceptarButton.setIcon(new ImageIcon("images/menu/botones/botonAceptar.png"));
        aceptarButton.setMargin(new Insets(0, 0, 0, 0));
        aceptarButton.setBackground(new Color(0, 0, 150, 80));
        aceptarButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        aceptarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        aceptarButton.addActionListener(new CrearTerran(ventanaJuego, this, nombreUsado, colorUsuado));

    }

    private JButton crearBotonSalir(){

        JButton botonSalir = new JButton();
        botonSalir.setSize(new Dimension(150, 26));

        botonSalir.setIcon(new ImageIcon("images/menu/botones/botonCancelar.jpg"));
        botonSalir.setMargin(new Insets(0, 0, 0, 0));
        botonSalir.setBackground(new Color(0, 0, 150, 80));
        botonSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
        botonSalir.setHorizontalTextPosition(SwingConstants.CENTER);
        botonSalir.addActionListener(new ActionCerrarCreador(this));

        return ( botonSalir );

    }

}

