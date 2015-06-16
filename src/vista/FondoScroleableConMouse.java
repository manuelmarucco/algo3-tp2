package vista;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class FondoScroleableConMouse extends JFrame {

    private JPanel panel;
    private JLabel label;

    public FondoScroleableConMouse(){
        this.init();
    }

    private void init() {
        //configuracion del fondo de pantalla
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new FileInputStream("images/menu/backgroundParaScrolear.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JPanel panel = new JPanel(new BorderLayout());
        panel = new JPanel();
        label = new JLabel(new ImageIcon(bi));

        panel.add(label);
        MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Rectangle r = new Rectangle(e.getX()-35, e.getY()-35, 70, 70); //no pregunten por los limites
                ((JPanel) e.getSource()).scrollRectToVisible(r);

            }
        };
        panel.addMouseMotionListener(doScrollRectToVisible);

        panel.setAutoscrolls(true);
        this.add(new JScrollPane(panel));
        this.pack();
        this.setSize(this.getWidth() / 2, this.getHeight() / 2);
        this.setVisible(true);

    }

    public static void main(String[] args){
        FondoScroleableConMouse ventanaPrincipal = new FondoScroleableConMouse();
        ventanaPrincipal.pack();
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaPrincipal.setVisible(true);
    }


}
