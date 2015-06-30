package vista.panelesDeEstado.panelesDeUnidad;

import interfaces.Cargable;
import unidades.UnidadTransporte;
import unidades.protoss.ResistenciaProtoss;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Queue;

public class PanelUnidadTransporte extends PanelUnidad{

    private JLabel capacidad;
    private JTree treeUnidadesCargadas;
    private Container contenedorDePanelUnidadCargadas;
    private DefaultMutableTreeNode root;
    private Queue<Cargable> unidadesCargadas;
    private UnidadTransporte unidadTransporte;


    public PanelUnidadTransporte() {
        this.crearLabels();
        this.crearPaneles();
        this.add(panelPrincipal);

        contenedorDePanelUnidadCargadas = new Container();
        contenedorDePanelUnidadCargadas.setLayout(new BoxLayout(contenedorDePanelUnidadCargadas, BoxLayout.Y_AXIS));
        this.panelPrincipal.add(contenedorDePanelUnidadCargadas);
    }

    @Override
    protected void crearLabels() {
        super.crearLabels();
        capacidad = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();

        JPanel panelCapacidad = new JPanel();
        JLabel tituloCapacidad = new JLabel("Capacidad:");

        panelCapacidad.setLayout(new BoxLayout(panelCapacidad, BoxLayout.X_AXIS));
        panelCapacidad.setOpaque(false);

        this.setearFuenteDeJLabel(tituloCapacidad,true,Font.BOLD,12);

        panelCapacidad.add(tituloCapacidad);
        capacidad.setForeground(new Color(200,200,20));
        panelCapacidad.add(capacidad);

        panelPrincipal.add(panelCapacidad);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));


    }

    private void mostrarUnidadesCargadas(Queue<Cargable> unidadesCargadas) {
        if(unidadesCargadas.size() == 0) return;

        this.crearTreeUnidadesCargadas(unidadesCargadas);

        for(Cargable unidad: unidadesCargadas){
            root.add(new DefaultMutableTreeNode(unidad.getClass().getSimpleName()));
        }
    }

    private void crearTreeUnidadesCargadas(Queue<Cargable> unidadesCargadas) {
        root = new DefaultMutableTreeNode(String.valueOf(unidadesCargadas.size())+" unidadTransporte/s cargada/s");
        treeUnidadesCargadas = new JTree(root);
        treeUnidadesCargadas.setOpaque(false);
        treeUnidadesCargadas.setPreferredSize(new Dimension(100,20));


        JScrollPane panelUnidadesCargadas = new JScrollPane(treeUnidadesCargadas);
        panelUnidadesCargadas.setPreferredSize(new Dimension(170,60));
        this.contenedorDePanelUnidadCargadas.add(panelUnidadesCargadas);


        //TODO no logré hacer que sea scrolleable
    }


    private void cargarDatosDeUnidadesCargadas(Queue<Cargable> unidadesCargadas) {
        this.unidadesCargadas = unidadesCargadas;
        this.mostrarUnidadesCargadas(unidadesCargadas);
    }

    public void cargarCapacidad(String string){
        this.capacidad.setText(string);
    }

    public void cargarDatosActualizables(UnidadTransporte unidad) {
        this.unidadTransporte = unidad;
        this.setVida(String.valueOf(unidadTransporte.getVida()));
        this.cargarDatosDeUnidadesCargadas(unidadTransporte.getUnidadesCargadas());
        if(escudo.isVisible()){
            this.setEscudo(String.valueOf(((ResistenciaProtoss) unidadTransporte.getResistencia()).getEscudoActual()));
        }

    }


    @Override
    public void repaint(){
        if(unidadTransporte!= null) {
            this.contenedorDePanelUnidadCargadas.removeAll();
            this.cargarDatosActualizables(this.unidadTransporte);
        }
    }

}
