package unidades.terrran;

import unidades.*;
import jugabilidad.auxiliares.Costo;

public class Espectro extends Unidad {

    public Espectro(){
        super("Espectro",new Vida(120),7,new Aereo(),new UnidadGuerrera(new Danio(8,20,5,5)),new Costo(150,100),2);
    }
}
