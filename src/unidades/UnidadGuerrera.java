package unidades;

import excepciones.Unidades.*;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;

public abstract class UnidadGuerrera extends Unidad {

    protected Danio danio;

    public UnidadGuerrera(Resistencia resistencia,Danio danio,int vision,Ubicacion ubicacion,int suministros,Costo costo,int tiempoDeEntrenamiento,int movilidad,Vision visionJugador,int transporte){
        super(resistencia,vision,ubicacion,suministros,costo,tiempoDeEntrenamiento,movilidad,visionJugador,transporte);
        this.danio=danio;
    }

    public UnidadGuerrera(Resistencia resistencia, Danio danio, int vision, Ubicacion ubicacion, int suministro, Costo costo, int tiempoDeEntrenamiento, int movilidad) {
        super(resistencia,vision,ubicacion,suministro,costo,tiempoDeEntrenamiento,movilidad);
        this.danio=danio;
    }

    public void atacarTierra(Daniable objetivo) throws ExcepcionDeAccionDeUnidad {
        if(!this.accion.puedoActuar())throw new ExcepcionYaActuo();
        ProxiDeAtaque.atacarTierra(this, objetivo);
        this.accion=this.accion.actuo();
    }

    public void atacarAire(Daniable objetivo) throws ExcepcionDeAccionDeUnidad {
        if(!this.accion.puedoActuar())throw new ExcepcionYaActuo();
        ProxiDeAtaque.atacarAire(this, objetivo);
        this.accion=this.accion.actuo();
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

    public void atacar(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        ProxiDeAtaque.atacar(this,coordenada);
        this.accion=this.accion.actuo();
    }
}
