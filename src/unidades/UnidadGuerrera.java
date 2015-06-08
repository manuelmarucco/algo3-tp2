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

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(danio);
    }

    public void atacarTierra(Unidad objetivo) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.atacarTierra(this, objetivo);
    }

    public void atacarAire(Unidad objetivo) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        ProxiDeAtaque.atacarAire(this, objetivo);
    }

    public int getRangoAereo(){
        return this.danio.getRangoAereo();
    }

    public int getRangoTerrestre(){
        return this.danio.getRangoTerrestre();
    }
}
