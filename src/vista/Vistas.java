package vista;

import construcciones.terran.Barraca;
import recursos.Cristal;
import recursos.Volcan;
import unidades.protoss.*;
import unidades.terrran.*;
import vista.edificios.terran.VistaBarraca;
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
        return temp;
    }

    public Class getVista(Class clase){
        return vistaDibujables.get(clase);
    }
}
