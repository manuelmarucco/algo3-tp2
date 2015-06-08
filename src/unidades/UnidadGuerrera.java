package unidades;

import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;

public abstract class UnidadGuerrera extends Unidad {

    protected Danio danio;

    public UnidadGuerrera(Resistencia resistencia,Danio danio,int vision,Ubicacion ubicacion,int suministros,Costo costo,int tiempoDeEntrenamiento){
        super(resistencia,vision,ubicacion,suministros,costo,tiempoDeEntrenamiento);
        this.danio=danio;
    }

    public void atacarTierra(Daniable objetivo) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.atacarTierra(this, objetivo);
    }

    public void atacarAire(Daniable objetivo) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.atacarAire(this, objetivo);
    }

    public int getRangoAereo(){
        return this.danio.getRangoAereo();
    }

    public int getRangoTerrestre(){
        return this.danio.getRangoTerrestre();
    }

    public int getDanioTerrestre() {
        return danio.getDanioTierra();
    }

    public int getDanioAereo() {
        return danio.getDanioAire();
    }
}
