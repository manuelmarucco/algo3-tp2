package unidades;

import excepciones.ExcepcionAtacarAUnidadAliada;
import excepciones.ExcepcionObjetivoFueraDeRango;
import interfaces.Daniable;
import interfaces.Entrenable;
import jugabilidad.Jugador;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class UnidadGuerrera extends Unidad {

    protected Danio danio;

    public UnidadGuerrera(Resistencia resistencia,Danio danio,int vision,Ubicacion ubicacion,int suministros,Costo costo,int tiempoDeEntrenamiento){
        super(resistencia,vision,ubicacion,suministros,costo,tiempoDeEntrenamiento);
        this.danio=danio;
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(danio);
    }

    public void atacarTierra(Coordenadas origen, Coordenadas destino) throws ExcepcionObjetivoFueraDeRango {
        if(origen.distacina(destino) < this.danio.getRangoTerrestre()){
            this.atacar((Daniable) SingletonMapa.getInstance().obtenerDeCapaTerrestre(destino));
        }
        else throw new ExcepcionObjetivoFueraDeRango();
    }

    public void atacarAire(Coordenadas origen, Coordenadas destino) throws ExcepcionObjetivoFueraDeRango {
        if(origen.distacina(destino)<danio.getRangoAereo()){
            this.atacar((Daniable)SingletonMapa.getInstance().obtenerDeCapaAerea(destino));
        }
        else throw new ExcepcionObjetivoFueraDeRango();
    }

    public void atacarAire(Coordenadas origen, Coordenadas destino, Jugador duenio) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        if(duenio.buscarUnidad((Entrenable)SingletonMapa.getInstance().obtenerDeCapaAerea(destino))){
            throw new ExcepcionAtacarAUnidadAliada();
        }
        else{
            atacarAire(origen,destino);
        }
    }

    public void atacarTierra(Coordenadas origen, Coordenadas destino, Jugador duenio) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada {
        if(duenio.buscarUnidad((Entrenable)SingletonMapa.getInstance().obtenerDeCapaTerrestre(destino))){
            throw new ExcepcionAtacarAUnidadAliada();
        }
        else{
            atacarTierra(origen,destino);
        }
    }
}
