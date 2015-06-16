package vista.fondoScroleable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class VentanaPrincipal extends JFrame {

    private JPanel panel;
    private Background label;
    private JScrollPane scrollpane;
    // private Point mousePosition;

    public VentanaPrincipal(){
        this.init();
    }

    private void init() {
        //configuracion del fondo de pantalla
        panel = new JPanel(new GridBagLayout());
        label = new Background("images/menu/background.jpg");
        scrollpane = new JScrollPane(panel);
        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //mousePosition.setLocation(e.getX(),e.getY());
                Rectangle r = new Rectangle(e.getX()-80, e.getY()-80, 120, 120);

                // while(x == e.getX() &&  y == e.getY())
                ((JPanel) e.getSource()).scrollRectToVisible(r);

            }

            ///Para que se mueva mas rapido hay que setearle mas grande los limites del rectangulo
            //---------------
            //Se puede hacer con "mouseDragged" y la unica diferencia es que hay que hacer click,mantener apretado
            //y pararte sobre el borde de la imagen y se mueve solo. Para que funcione bien bien va a ver que meterle
            //unos bordes laterales.
        };

        panel.add(label);
        panel.addMouseMotionListener(doScrollRectToVisible);
        panel.setAutoscrolls(true);
        this.add(scrollpane);
        this.pack();
        this.setSize(this.getWidth() / 2, this.getHeight() / 2);
        this.setVisible(true);

    }
    public static void main(String[] args){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.pack();
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setVisible(true);
    }


}