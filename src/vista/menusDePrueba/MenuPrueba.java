package vista.menusDePrueba;

import excepciones.construicciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import vista.auxiliares.jugador.DisplayNotificaciones;

import javax.swing.*;
import java.awt.*;

public class MenuPrueba{

    private JFrame ventana;
    private JPanel panelNotif;
    private DisplayNotificaciones displayNotificaciones;

    public MenuPrueba(){
        this.crearPanelNotificaciones();
        this.crearVentana();
        this.crearContenedor();
    }

    private void crearContenedor() {
        Container contenedor = ventana.getContentPane();
        SpringLayout layout  = new SpringLayout();
        contenedor.setLayout(layout);

        //Para ubicar el panel de notificacion en el contenedor de la ventana
        layout.putConstraint(SpringLayout.WEST, panelNotif, 50, SpringLayout.WEST, contenedor);
        layout.putConstraint(SpringLayout.NORTH, panelNotif, 100, SpringLayout.NORTH, contenedor);

        contenedor.add(panelNotif);

    }

    private void crearVentana() {
        ventana = new JFrame();
        ventana.setTitle("prueba del panel de notificaciones");
        ventana.setSize(400,400);
        ventana.setLayout(new BoxLayout(ventana.getContentPane(),BoxLayout.Y_AXIS));
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    private void crearPanelNotificaciones() {
        this.panelNotif = new JPanel();
        this.panelNotif.setBackground(Color.black);

        displayNotificaciones = new DisplayNotificaciones();

        this.panelNotif.add(displayNotificaciones,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        MenuPrueba menuPrueba = new MenuPrueba();

        menuPrueba.displayNotificaciones.mostrarNotificacion(new ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso());
    }

}
