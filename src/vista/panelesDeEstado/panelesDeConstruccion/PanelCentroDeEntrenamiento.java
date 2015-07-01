package vista.panelesDeEstado.panelesDeConstruccion;

import interfaces.Entrenable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Queue;

public class PanelCentroDeEntrenamiento extends PanelConstruccion {
    private  JTree treeColaDeEntrenamiento;
    private DefaultMutableTreeNode root;
    private JPanel panelTiempoDeEntrenamientoDeUnidad;
    private Queue<Entrenable> colaDeEntrenamiento;
    private Container contenedorColaYTiempo;


    public PanelCentroDeEntrenamiento(){
        super();
        contenedorColaYTiempo = new Container();
        contenedorColaYTiempo.setLayout(new BoxLayout(contenedorColaYTiempo, BoxLayout.Y_AXIS));
        this.panelPrincipal.add(contenedorColaYTiempo);
    }

    private void mostrarColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {
        if(colaDeEntrenamiento.size() == 0) return;

        this.crearTreeColaDeEntrenamiento(colaDeEntrenamiento);
        this.mostrarTiempoDeEntrenamiento(colaDeEntrenamiento.peek());

        for(Entrenable unidad: colaDeEntrenamiento){
            root.add(new DefaultMutableTreeNode(unidad.getClass().getSimpleName()));
        }
    }

    private void crearTreeColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {
        root = new DefaultMutableTreeNode(String.valueOf("Entrenando "+colaDeEntrenamiento.size())+" unidad/s");
        treeColaDeEntrenamiento = new JTree(root);
        treeColaDeEntrenamiento.setOpaque(false);
        treeColaDeEntrenamiento.setPreferredSize(new Dimension(100,20));


        JScrollPane panelColaDeEntrenamiento = new JScrollPane(treeColaDeEntrenamiento);
        panelColaDeEntrenamiento.setPreferredSize(new Dimension(170,60));
        this.contenedorColaYTiempo.add(panelColaDeEntrenamiento);


        //TODO no logro hacer que sea scrolleable
    }

    private void mostrarTiempoDeEntrenamiento(Entrenable unidad){
        int tiempoDeEntrenamientoTotal = unidad.getTiempoDeEntrenamientoTotal();
        int tiempoDeEntrenamientoActual = unidad.getTiempoDeEntrenamientoActual();

        this.crearLabelDeUnidadEnEntrenamiento(unidad.getClass().getSimpleName());

        JProgressBar progressTiempoDeEntrenamiento = new JProgressBar(0,tiempoDeEntrenamientoTotal);
        progressTiempoDeEntrenamiento.setPreferredSize(new Dimension(190, 20));
        progressTiempoDeEntrenamiento.setMaximumSize(new Dimension(190, 20));
        progressTiempoDeEntrenamiento.setValue(tiempoDeEntrenamientoTotal - tiempoDeEntrenamientoActual);
        progressTiempoDeEntrenamiento.setStringPainted(true);
        progressTiempoDeEntrenamiento.setVisible(true);

        progressTiempoDeEntrenamiento.setString(String.valueOf(tiempoDeEntrenamientoActual) + " turnos para entrenar");

        this.contenedorColaYTiempo.add(Box.createRigidArea(new Dimension(10, 10)));
        this.contenedorColaYTiempo.add(progressTiempoDeEntrenamiento);

    }


    private void crearLabelDeUnidadEnEntrenamiento(String nombreDeUnidad) {
        this.panelTiempoDeEntrenamientoDeUnidad = new JPanel();
        JLabel tituloEntrenando = new JLabel("Entrenando "+nombreDeUnidad+"...");

        this.panelTiempoDeEntrenamientoDeUnidad.setLayout(new BoxLayout(panelTiempoDeEntrenamientoDeUnidad, BoxLayout.X_AXIS));
        this.panelTiempoDeEntrenamientoDeUnidad.setOpaque(false);
        this.setearFuenteDeJLabel(tituloEntrenando,false,Font.ITALIC,12);
        this.panelTiempoDeEntrenamientoDeUnidad.add(tituloEntrenando);

        this.contenedorColaYTiempo.add(Box.createRigidArea(new Dimension(10, 10)));
        this.contenedorColaYTiempo.add(this.panelTiempoDeEntrenamientoDeUnidad);

    }

    @Override
    public void repaint(){
        if(this.colaDeEntrenamiento!= null) {
            this.contenedorColaYTiempo.removeAll();
            this.cargarDatosDeColaDeEntrenamiento(this.colaDeEntrenamiento);
        }
    }


    public void cargarDatosDeColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {
        this.colaDeEntrenamiento = colaDeEntrenamiento;
        this.mostrarColaDeEntrenamiento(colaDeEntrenamiento);
    }
}
