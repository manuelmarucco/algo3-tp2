package control.vistaMapa;

import construcciones.EdificioEnConstruccion;
import construcciones.protoss.*;
import construcciones.terran.*;
import interfaces.ColocableEnMapa;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import recursos.Cristal;
import recursos.Volcan;
import unidades.protoss.*;
import unidades.terrran.*;
import vista.IVista;
import vista.ParselaAccionable;
import vista.auxiliares.ImagePanel;
import vista.auxiliares.jugador.imagenesMapa.HashMapParaMapa;
import vista.edificios.VistaEdificioEnConstruccion;
import vista.edificios.protoss.*;
import vista.edificios.terran.*;
import vista.paisaje.VistaAire;
import vista.paisaje.VistaNullPosicionTerrestre;
import vista.paisaje.VistaPasto;
import vista.recursos.VistaCristales;
import vista.recursos.VistaVolcan;
import vista.unidades.*;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ControladorDeVistaMapa {

    private HashMapParaMapa<Class, Class> asociadorDeVistasRecursos;
    private HashMapParaMapa<Class, Class> asociadorDeVistasTerrestres;
    private HashMapParaMapa<Class, Class> asociadorDeVistasAereas;
    private HashMap<Coordenada,ImagePanel> capaSuperior=new HashMap<>();
    private ProxyMapa proxyMapa = ProxyMapa.getInstance();

    public ControladorDeVistaMapa() {

        this.crearAsociadorDeClasesTerrestresConSusVistas();
        this.crearAsociadorDeClasesAereasConSusVistas();
        this.crearAsociadorDeClasesDeRecursosConSusVistas();

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
        panelAereo.setPreferredSize(new Dimension(1600,1600));
        panelAereo.setBounds(0,0,1600,1600);
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

                parsela.addMouseListener(new ParselaAccionable(ventana, coordenada,(IVista) capaSuperior.get(coordenada)));

                panelAccionable.add(parsela);

            }

        }

        return (panelAccionable);

    }

    public JPanel armarPanelDeVisionDisponible(int cantidadTilesHorizontales, int cantidadTilesVerticales, Jugador jugador){

        JPanel panelDeVision = new JPanel(new GridLayout(25,25));
        panelDeVision.setPreferredSize(new Dimension(1600,1600));
        panelDeVision.setBounds(0,0,1600,1600);
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

    // Metodos Privados ------------------------------------------------------------------------------------------------

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
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

    // Cargador de Hash Maps -------------------------------------------------------------------------------------------

    private void crearAsociadorDeClasesTerrestresConSusVistas(){

        asociadorDeVistasTerrestres = new HashMapParaMapa<Class, Class>(VistaPasto.class);

        //////////////////// Unidades.
        // Terran.
        asociadorDeVistasTerrestres.put(Marine.class, VistaMarine.class);
        asociadorDeVistasTerrestres.put(Golliat.class, VistaGolliat.class);
        // Protoss.
        asociadorDeVistasTerrestres.put(Zealot.class, VistaZealot.class);
        asociadorDeVistasTerrestres.put(Dragon.class, VistaDragon.class);
        asociadorDeVistasTerrestres.put(AltoTemplario.class, VistaAltoTemplario.class);

        ///////////////////// Construcciones.
        // Terran.
        asociadorDeVistasTerrestres.put(CentroDeMineral.class, VistaCentroDeMinerales.class);
        asociadorDeVistasTerrestres.put(Refineria.class, VistaRefineria.class);
        asociadorDeVistasTerrestres.put(Barraca.class, VistaBarraca.class);
        asociadorDeVistasTerrestres.put(DepositoDeSuministros.class, VistaDepositoDeSuministros.class);
        asociadorDeVistasTerrestres.put(Fabrica.class, VistaFabrica.class);
        asociadorDeVistasTerrestres.put(PuertoEstelar.class, VistaPuertoEstelar.class);
        // Protoss.
        asociadorDeVistasTerrestres.put(NexoMineral.class, VistaNexoMineral.class);
        asociadorDeVistasTerrestres.put(Asimilador.class, VistaAsimilador.class);
        asociadorDeVistasTerrestres.put(Pilon.class, VistaPilon.class);
        asociadorDeVistasTerrestres.put(Acceso.class, VistaAcceso.class);
        asociadorDeVistasTerrestres.put(PortalEstelar.class, VistaPortalEstelar.class);
        asociadorDeVistasTerrestres.put(ArchivosTemplarios.class, VistaArchivosTemplarios.class);
        //Edificio en Construccion
        asociadorDeVistasTerrestres.put(EdificioEnConstruccion.class, VistaEdificioEnConstruccion.class);
        // Paisaje.////////////////
        asociadorDeVistasTerrestres.put(NullPosicionTerrestre.class, VistaNullPosicionTerrestre.class);



    }

    private void crearAsociadorDeClasesAereasConSusVistas(){

        asociadorDeVistasAereas = new HashMapParaMapa<Class, Class>(VistaAire.class);

        // Unidades.
        // Terran.
        asociadorDeVistasAereas.put(Espectro.class, VistaEspectro.class);
        asociadorDeVistasAereas.put(NaveCiencia.class, VistaNaveCiencia.class);
        asociadorDeVistasAereas.put(NaveTransporteTerran.class, VistaNaveTransporteTerran.class);
        // Protoss.
        asociadorDeVistasAereas.put(Scout.class, VistaScout.class);
        asociadorDeVistasAereas.put(NaveTransporteProtoss.class, VistaNaveTransporteProtoss.class);

    }

    private void crearAsociadorDeClasesDeRecursosConSusVistas() {

        asociadorDeVistasRecursos = new HashMapParaMapa<Class, Class>(VistaAire.class);

        asociadorDeVistasRecursos.put(Volcan.class, VistaVolcan.class);
        asociadorDeVistasRecursos.put(Cristal.class, VistaCristales.class);

    }

}
