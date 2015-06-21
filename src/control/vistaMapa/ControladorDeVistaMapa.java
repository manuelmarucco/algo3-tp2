package control.vistaMapa;

import construcciones.protoss.*;
import construcciones.terran.*;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import recursos.Cristal;
import recursos.Volcan;
import unidades.protoss.*;
import unidades.terrran.*;
import vista.auxiliares.jugador.imagenesMapa.HashMapParaMapa;
import vista.edificios.protoss.*;
import vista.edificios.terran.*;
import vista.paisaje.VistaAire;
import vista.paisaje.VistaNullPosicionTerrestre;
import vista.paisaje.VistaPasto;
import vista.recursos.VistaCristales;
import vista.recursos.VistaVolcan;
import vista.unidades.*;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ControladorDeVistaMapa {

    private HashMapParaMapa<Class, Class> asociadorDeVistasRecursos;
    private HashMapParaMapa<Class, Class> asociadorDeVistasTerrestres;
    private HashMapParaMapa<Class, Class> asociadorDeVistasAereas;
    private ProxyMapa proxyMapa = ProxyMapa.getInstance();

    public ControladorDeVistaMapa() {

        this.crearAsociadorDeClasesTerrestresConSusVistas();
        //this.crearAsociadorDeClasesAereasConSusVistas();
        //this.crearAsociadorDeClasesDeRecursosConSusVistas();

    }

    public JPanel getVistaTerrestreEnPosicion(Coordenadas coordenadas) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaTerrestre(coordenadas);

        // No puedo hacer directamente  Class clase = proxyMapa.obtenerDeCapaTerrestre(coordenadas).getClass;
        // porque el getClass si es null tira un error.
        if (colocable != null){
            clase = colocable.getClass();
        }

        JPanel aDevolver = null;

        try {
            aDevolver = (JPanel) asociadorDeVistasTerrestres.get(clase).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return aDevolver;

    }

    public JPanel getVistaAereaEnPosicion(Coordenadas coordenadas) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaAerea(coordenadas);

        if (colocable != null){
            clase = colocable.getClass();
        }

        JPanel aDevolver = null;

        try {
            aDevolver = (JPanel) asociadorDeVistasAereas.get(clase).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return aDevolver;

    }

    public JPanel getVistaRecursosEnPosicion(Coordenadas coordenadas) {

        Class clase = null;
        ColocableEnMapa colocable = proxyMapa.obtenerDeCapaDeRecursos(coordenadas);

        if (colocable != null){
            clase = colocable.getClass();
        }

        JPanel aDevolver = null;

        try {
            aDevolver = (JPanel) asociadorDeVistasRecursos.get(clase).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return aDevolver;

    }

    private void crearAsociadorDeClasesTerrestresConSusVistas(){

        // Este hashMap devuelve un valor por defecto si se le pide una key = null.
        asociadorDeVistasTerrestres = new HashMapParaMapa<Class, Class>(VistaPasto.class);

        // Unidades.
        // Terran.
        asociadorDeVistasTerrestres.put(Marine.class, VistaMarine.class);
        asociadorDeVistasTerrestres.put(Golliat.class, VistaGolliat.class);
        // Protoss.
        asociadorDeVistasTerrestres.put(Zealot.class, VistaZealot.class);
        asociadorDeVistasTerrestres.put(Dragon.class, VistaDragon.class);

        // Construcciones.
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

        // Paisaje.
        asociadorDeVistasTerrestres.put(NullPosicionTerrestre.class, VistaNullPosicionTerrestre.class);



    }

    private void crearAsociadorDeClasesAereasConSusVistas(){

        // Este hashMap devuelve un valor por defecto si se le pide una key = null.
        asociadorDeVistasAereas = new HashMapParaMapa<Class, Class>(VistaAire.class);

        // Unidades.
        // Terran.
        asociadorDeVistasAereas.put(Espectro.class, VistaEspectro.class);
        asociadorDeVistasAereas.put(NaveCiencia.class, VistaNaveCiencia.class);
        asociadorDeVistasAereas.put(NaveTransporteTerran.class, VistaNaveTransporteTerran.class);
        // Protoss.
        asociadorDeVistasAereas.put(Scout.class, VistaScout.class);
        asociadorDeVistasAereas.put(AltoTemplario.class, VistaAltoTemplario.class);
        asociadorDeVistasAereas.put(NaveTransporteProtoss.class, VistaNaveTransporteProtoss.class);

    }

    private void crearAsociadorDeClasesDeRecursosConSusVistas() {

        // Este hashMap devuelve un valor por defecto si se le pide una key = null.
        asociadorDeVistasAereas = new HashMapParaMapa<Class, Class>(VistaAire.class);

        asociadorDeVistasRecursos.put(Volcan.class, VistaVolcan.class);
        asociadorDeVistasRecursos.put(Cristal.class, VistaCristales.class);

    }

}
