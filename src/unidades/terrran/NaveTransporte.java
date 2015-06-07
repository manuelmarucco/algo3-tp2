package unidades.terrran;

import excepciones.ExcepcionCargaSuperada;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.Danio;

import java.util.LinkedList;
import java.util.Queue;

public class NaveTransporte extends UnidadTerran {

    private static int tranporteMax = 8;
    private Queue<Cargable> unidades;

    public NaveTransporte(){
        super(150);
        this.vision = 8;
        this.ubicacion = new Aereo();
        this.suministro = 2;
        this.costo=new Costo(100,100);
        this.unidades= new LinkedList<>();
        this.tiempoDeEntrenamiento = 7;
    }

    @Override
    public void update() {
       //TODO:ver si hace algo
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioAire());
    }

    public void cargar(Cargable unidad) throws ExcepcionCargaSuperada {
        int cargaTotal=0;
        for(Cargable a:unidades){
            cargaTotal+=a.getTransporte();
        }
        cargaTotal+=unidad.getTransporte();
        if(cargaTotal>tranporteMax) throw new ExcepcionCargaSuperada();
        unidades.add(unidad);
        unidad.quitarse();
    }

    public void descargar(Coordenadas coordenadas){
        Mapa mapa=SingletonMapa.getInstance();
        mapa.agregar((ColocableEnMapa)unidades.remove(),coordenadas);
    }
}