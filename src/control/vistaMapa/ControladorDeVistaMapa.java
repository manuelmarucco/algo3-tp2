package control.vistaMapa;

import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.ProxyDeHechizos;
import vista.IVista;
import vista.ParselaAccionable;
import vista.auxiliares.ImagePanel;
import vista.auxiliares.jugador.extrasMapa.HashMapParaMapa;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ControladorDeVistaMapa {

    private AsociadorDeVistas asociadorDeVistas;

    private HashMapParaMapa<Class, Class> asociadorDeVistasRecursos;
    private HashMapParaMapa<Class, Class> asociadorDeVistasTerrestres;
    private HashMapParaMapa<Class, Class> asociadorDeVistasAereas;
    private HashMap<Coordenada,ImagePanel> capaSuperior=new HashMap<>();
    private HashMapParaMapa<Class, Class> asociadorDeVistasPoderes;

    private ProxyMapa proxyMapa = ProxyMapa.getInstance();

    public ControladorDeVistaMapa() {

        this.asociadorDeVistas = new AsociadorDeVistas();

        this.asociadorDeVistasRecursos = this.asociadorDeVistas.crearAsociadorDeClasesDeRecursosConSusVistas();
        this.asociadorDeVistasTerrestres = this.asociadorDeVistas.crearAsociadorDeClasesTerrestresConSusVistas();
        this.asociadorDeVistasAereas = this.asociadorDeVistas.crearAsociadorDeClasesAereasConSusVistas();
        this.asociadorDeVistasPoderes = this.asociadorDeVistas.crearAsociadorDeClasesDePoderesConSusVistas();

    }

    public JPanel armarPanelTerrestre(int cantidadTilesHorizontales, int cantidadTilesVerticales, VentanaJugador ventana){

        JPanel panelTerrestre = new JPanel(new GridLayout(25,25));
        panelTerrestre.setPreferredSize(new Dimension(1600, 1600));
        panelTerrestre.setBounds(0, 0, 25 * 64, 25 * 64);
        panelTerrestre.setOpaque(false);

        for (int j = 0; j < cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < cantidadTilesVerticales; i++){

                Coordenada coordenada = new Coordenada( i + 1, cantidadTilesHorizontales - j );
                ImagePanel vista = (ImagePanel) this.getVistaTerrestreEnPosicion(coordenada, ventana);
                panelTerrestre.add(vista);
                if(proxyMapa.posicionTerrestreOcupada(coordenada))
                    capaSuperior.put(coordenada,vista);
            }

        }

        return (panelTerrestre);

    }

    public JPanel armarPanelDeRecursos(int cantidadTilesHorizontales, int cantidadTilesVerticales, VentanaJugador ventana){

        JPanel panelDeRecursos = new JPanel(new GridLayout(25,25));
        panelDeRecursos.setPreferredSize(new Dimension(1600,1600));
        panelDeRecursos.setBounds(0,0,1600,1600);
        panelDeRecursos.setOpaque(false);

        for (int j = 0; j < cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < cantidadTilesVerticales; i++){

                Coordenada coordenada = new Coordenada( i + 1, cantidadTilesHorizontales - j );
                ImagePanel vista = (ImagePanel) this.getVistaRecursosEnPosicion(coordenada, ventana);

                vista.setOpaque(false);
                panelDeRecursos.add(vista);
                capaSuperior.put(coordenada, vista);
            }

        }

        return (panelDeRecursos);

    }

    public JPanel armarPanelAereo(int cantidadTilesHorizontales, int cantidadTilesVerticales, VentanaJugador ventana){

        JPanel panelAereo = new JPanel(new GridLayout(25,25));
        panelAereo.setPreferredSize(new Dimension(1600, 1600));
        panelAereo.setBounds(0, 0, 1600, 1600);
        panelAereo.setOpaque(false);

        for (int j = 0; j < cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < cantidadTilesVerticales; i++){

                Coordenada coordenada = new Coordenada( i + 1, cantidadTilesHorizontales - j );
                ImagePanel vista = (ImagePanel) this.getVistaAereaEnPosicion(coordenada, ventana);
                vista.setOpaque(false);
                panelAereo.add(vista);
                if(proxyMapa.posicionAereaOcupada(coordenada))
                    capaSuperior.put(coordenada, vista);
            }

        }

        return (panelAereo);

    }

    public JPanel armarPanelAccionable(int cantidadTilesHorizontales, int cantidadTilesVerticales, VentanaJugador ventana){

        JPanel panelAccionable = new JPanel(new GridLayout(25,25));
        panelAccionable.setPreferredSize(new Dimension(1600,1600));
        panelAccionable.setBounds(0, 0, 1600, 1600);
        panelAccionable.setBackground(new Color(0, 0, 0, 0));
        panelAccionable.setOpaque(false);

        for (int j = 0; j < cantidadTilesHorizontales; j++ ) {

            for (int i = 0; i < cantidadTilesVerticales; i++) {

                JPanel parsela = new JPanel();
                parsela.setBackground(new Color(0, 0, 0, 0));
                Coordenada coordenada = new Coordenada(i + 1, cantidadTilesHorizontales - j);

                parsela.addMouseListener(new ParselaAccionable(ventana, coordenada, (IVista) capaSuperior.get(coordenada)));

                panelAccionable.add(parsela);

            }

        }

        return (panelAccionable);

    }

    public JPanel armarPanelDeVisionDisponible(int cantidadTilesHorizontales, int cantidadTilesVerticales, Jugador jugador){

        JPanel panelDeVision = new JPanel(new GridLayout(25,25));
        panelDeVision.setPreferredSize(new Dimension(1600,1600));
        panelDeVision.setBounds(0, 0, 1600, 1600);
        panelDeVision.setBackground(new Color(0, 0, 0, 0));
        panelDeVision.setOpaque(false);

        Vision visibilidad = jugador.getVisibilidad();

        for (int j = 0; j < cantidadTilesHorizontales; j++ ) {

            for (int i = 0; i < cantidadTilesVerticales; i++) {

                JPanel parsela = new JPanel();
                parsela.setBackground(Color.BLACK);

                Coordenada coordenada = new Coordenada(i + 1, cantidadTilesHorizontales - j);

                if (visibilidad.esVisible(coordenada)){
                    parsela.setVisible(false);
                } else {
                    parsela.setVisible(true);
                }

                panelDeVision.add(parsela);

            }

        }

        return (panelDeVision);
    }

    @SuppressWarnings("all")
    public JPanel armarPanelPoderes(int cantidadTilesHorizontales, int cantidadTilesVerticales,VentanaJugador ventana) {
        JPanel panelPoderes = new JPanel(new GridLayout(25,25));
        panelPoderes.setPreferredSize(new Dimension(1600, 1600));
        panelPoderes.setBounds(0, 0, 25 * 64, 25 * 64);
        panelPoderes.setOpaque(false);
        for (int j = 0; j < cantidadTilesHorizontales; j++ ){

            for (int i = 0; i < cantidadTilesVerticales; i++){
                Coordenada coordenada = new Coordenada( i + 1, cantidadTilesHorizontales - j );
                for(Jugador jugador: ProxyDeHechizos.getJugadores()){
                    try {
                        Object poder=jugador.getPodereActivado(coordenada);
                        Class clase=null;
                        if(poder!=null) {
                            clase = poder.getClass();
                        }
                        Constructor constructor = asociadorDeVistasPoderes.get(clase).getConstructor(ColocableEnMapa.class, VentanaJugador.class);
                        panelPoderes.add((ImagePanel) constructor.newInstance(null, ventana));
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        return (panelPoderes);
    }

    // Metodos Privados ------------------------------------------------------------------------------------------------

    @SuppressWarnings("all")
    private JPanel getVistaTerrestreEnPosicion(Coordenada coordenada, VentanaJugador ventana) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaTerrestre(coordenada);

        // No puedo hacer directamente  Class clase = proxyMapa.obtenerDeCapaTerrestre(coordenada).getClass;
        // porque el getClass si es null tira un error.
        if (colocable != null){
            clase = colocable.getClass();
        }

        JPanel aDevolver = null;

        try {
            Constructor constructor = asociadorDeVistasTerrestres.get(clase).getConstructor(ColocableEnMapa.class,VentanaJugador.class);
            aDevolver = (JPanel) constructor.newInstance(colocable, ventana);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return aDevolver;

    }

    @SuppressWarnings("all")
    private JPanel getVistaAereaEnPosicion(Coordenada coordenada, VentanaJugador ventana) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaAerea(coordenada);

        if (colocable != null){
            clase = colocable.getClass();
        }

        ImagePanel aDevolver = null;

        try {
            Constructor constructor = asociadorDeVistasAereas.get(clase).getConstructor(ColocableEnMapa.class,VentanaJugador.class);
            aDevolver = (ImagePanel) constructor.newInstance(colocable, ventana);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return aDevolver;

    }

    @SuppressWarnings("all")
    private JPanel getVistaRecursosEnPosicion(Coordenada coordenada, VentanaJugador ventana) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaDeRecursos(coordenada);

        if (colocable != null){
            clase = colocable.getClass();
        }

        ImagePanel aDevolver = null;

        try {
            Constructor constructor = asociadorDeVistasRecursos.get(clase).getConstructor(ColocableEnMapa.class,VentanaJugador.class);
            aDevolver = (ImagePanel) constructor.newInstance(colocable, ventana);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

            e.printStackTrace();

        }

        return aDevolver;

    }

}
