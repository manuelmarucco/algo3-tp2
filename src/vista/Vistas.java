package vista;

import construcciones.CentroDeSuministros;
import construcciones.protoss.*;
import construcciones.terran.*;
import recursos.Cristal;
import recursos.Volcan;
import unidades.protoss.*;
import unidades.terrran.*;
import vista.edificios.protoss.*;
import vista.edificios.terran.*;
import vista.recursos.VistaCristales;
import vista.recursos.VistaVolcan;
import vista.unidades.*;

import java.util.HashMap;
import java.util.Map;

public class Vistas {
    private static final Map<Class,Class> vistaDibujables=crearVista();
    private static Map crearVista() {
        Map<Class,Class> temp = new HashMap<>();
                    /*unidades*/
        //Terran
        temp.put(Marine.class, VistaMarine.class);
        temp.put(Golliat.class, VistaGolliat.class);
        temp.put(Espectro.class,VistaEspectro.class);
        temp.put(NaveCiencia.class, VistaNaveCiencia.class);
        temp.put(NaveTransporteTerran.class, VistaNaveTransporteTerran.class);
        //protoss
        temp.put(Zealot.class, VistaZealot.class);
        temp.put(AltoTemplario.class, VistaAltoTemplario.class);
        temp.put(Scout.class, VistaScout.class);
        temp.put(Dragon.class, VistaDragon.class);
        temp.put(NaveTransporteProtoss.class, VistaNaveTransporteProtoss.class);
                    /*recursos*/
        temp.put(Cristal.class, VistaCristales.class);
        temp.put(Volcan.class, VistaVolcan.class);
                    /*edificios*/
        //terran
        temp.put(Barraca.class, VistaBarraca.class);
        temp.put(PuertoEstelar.class, VistaPuertoEstelar.class);
        temp.put(CentroDeMineral.class, VistaCentroDeMinerales.class);
        temp.put(CentroDeSuministros.class, VistaCentroDeSuministros.class);
        temp.put(Fabrica.class, VistaFabrica.class);
        temp.put(Refineria.class, VistaRefineria.class);
        //protoss
        temp.put(Acceso.class, VistaAcceso.class);
        temp.put(ArchivosTemplarios.class, VistaArchivosTemplarios.class);
        temp.put(Asimilador.class, VistaAsimilador.class);
        temp.put(NexoMineral.class, VistaNexoMineral.class);
        temp.put(Pilon.class, VistaPilon.class);
        temp.put(PortalEstelar.class, VistaPortalEstelar.class);

        return temp;
    }

    public Class getVista(Class clase){
        return vistaDibujables.get(clase);
    }
}
