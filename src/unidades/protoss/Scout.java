package unidades.protoss;

import unidades.*;
import jugabilidad.auxiliares.Costo;

public class Scout extends Unidad {

    public Scout(){
        super("Scout",new VidaEscudo(100,150),7,new Aereo(),new UnidadGuerrera(new Danio(8,14,4,4)),new Costo(300,150),3);
    }
}
