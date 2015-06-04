package unidades.terrran;

import unidades.Unidad;
import unidades.Vida;


public abstract class UnidadTerran extends Unidad {

    public UnidadTerran(int vida){
        this.vida= new Vida(vida);
    }
}
