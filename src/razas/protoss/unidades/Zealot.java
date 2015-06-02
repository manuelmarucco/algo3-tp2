package razas.protoss.unidades;

import jugabilidad.auxiliares.Costo;
import manejoDeUnidades.*;

public class Zealot extends Unidad {

    public Zealot(){
        super("Zealot",new VidaEscudo(60,100), 7, new Terrestre(), new UnidadGuerrera(new Danio(8,0, 1,0)),new Costo(100,0),2);
    }
}
