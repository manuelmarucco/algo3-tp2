package unidades.terrran;

import unidades.*;
import jugabilidad.auxiliares.Costo;

public class Golliat extends Unidad {

    public Golliat(){
        super("Golliat",new Vida(125),8,new Terrestre(),new UnidadGuerrera(new Danio(12,10,6,5)),new Costo(100,50),2);
    }
}
