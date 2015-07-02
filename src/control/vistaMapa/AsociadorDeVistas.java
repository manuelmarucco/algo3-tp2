package control.vistaMapa;


import modelo.construcciones.EdificioEnConstruccion;
import modelo.construcciones.protoss.*;
import modelo.construcciones.terran.*;
import modelo.jugabilidad.auxiliares.TormentaPsionica;
import modelo.jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import modelo.recursos.Cristal;
import modelo.recursos.Volcan;
import modelo.unidades.protoss.*;
import modelo.unidades.terrran.*;
import vista.VistaTormentaPsionica;
import vista.auxiliares.jugador.imagenesMapa.HashMapParaMapa;
import vista.edificios.protoss.*;
import vista.edificios.terran.*;
import vista.paisaje.VistaAire;
import vista.paisaje.VistaNullPosicionTerrestre;
import vista.paisaje.VistaPasto;
import vista.recursos.VistaCristales;
import vista.recursos.VistaVolcan;
import vista.unidades.*;

public class AsociadorDeVistas {

    public  HashMapParaMapa<Class, Class> crearAsociadorDeClasesDePoderesConSusVistas() {
        HashMapParaMapa<Class, Class> asociador = new HashMapParaMapa<Class, Class>(VistaAire.class);
        asociador.put(TormentaPsionica.class, VistaTormentaPsionica.class);

        return  (asociador);
    }

    public HashMapParaMapa<Class, Class> crearAsociadorDeClasesTerrestresConSusVistas(){

        HashMapParaMapa<Class, Class> asociador = new HashMapParaMapa<Class, Class>(VistaPasto.class);

        // Unidades ----------------------------------------------------------------------------------------------------

        // Terran.
        asociador.put(Marine.class, VistaMarine.class);
        asociador.put(Golliat.class, VistaGolliat.class);
        // Protoss.
        asociador.put(ClonGuerrero.class, VistaClonGuerrero.class);
        asociador.put(ClonMagico.class, VistaClonMagico.class);
        asociador.put(ClonTransporte.class, VistaClonTransporte.class);
        asociador.put(Zealot.class, VistaZealot.class);
        asociador.put(Dragon.class, VistaDragon.class);
        asociador.put(AltoTemplario.class, VistaAltoTemplario.class);

        // Construcciones ----------------------------------------------------------------------------------------------

        // Terran.
        asociador.put(CentroDeMineral.class, VistaCentroDeMinerales.class);
        asociador.put(Refineria.class, VistaRefineria.class);
        asociador.put(Barraca.class, VistaBarraca.class);
        asociador.put(DepositoDeSuministros.class, VistaDepositoDeSuministros.class);
        asociador.put(Fabrica.class, VistaFabrica.class);
        asociador.put(PuertoEstelar.class, VistaPuertoEstelar.class);
        // Protoss.
        asociador.put(NexoMineral.class, VistaNexoMineral.class);
        asociador.put(Asimilador.class, VistaAsimilador.class);
        asociador.put(Pilon.class, VistaPilon.class);
        asociador.put(Acceso.class, VistaAcceso.class);
        asociador.put(PortalEstelar.class, VistaPortalEstelar.class);
        asociador.put(ArchivosTemplarios.class, VistaArchivosTemplarios.class);
        //Edificio en Construccion
        asociador.put(EdificioEnConstruccion.class, VistaEdificioEnConstruccion.class);
        asociador.put(EdificioEnInvocacion.class, VistaEdificioEnInvocacion.class);

        // Paisaje -----------------------------------------------------------------------------------------------------
        asociador.put(NullPosicionTerrestre.class, VistaNullPosicionTerrestre.class);

        return  (asociador);

    }

    public HashMapParaMapa<Class, Class> crearAsociadorDeClasesAereasConSusVistas(){

        HashMapParaMapa<Class, Class> asociador = new HashMapParaMapa<Class, Class>(VistaAire.class);

        // Unidades.
        // Terran.
        asociador.put(Espectro.class, VistaEspectro.class);
        asociador.put(NaveCiencia.class, VistaNaveCiencia.class);
        asociador.put(NaveTransporteTerran.class, VistaNaveTransporteTerran.class);
        // Protoss.
        asociador.put(Scout.class, VistaScout.class);
        asociador.put(NaveTransporteProtoss.class, VistaNaveTransporteProtoss.class);
        asociador.put(ClonGuerrero.class, VistaClonGuerrero.class);
        asociador.put(ClonMagico.class, VistaClonMagico.class);
        asociador.put(ClonTransporte.class, VistaClonTransporte.class);

        return  (asociador);

    }

    public HashMapParaMapa<Class, Class> crearAsociadorDeClasesDeRecursosConSusVistas() {

        HashMapParaMapa<Class, Class> asociador = new HashMapParaMapa<Class, Class>(VistaAire.class);

        asociador.put(Volcan.class, VistaVolcan.class);
        asociador.put(Cristal.class, VistaCristales.class);

        return  (asociador);

    }

}
