package unidades.protoss;

import excepciones.ExcepcionCargaSuperada;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.Danio;

import java.util.ArrayList;
import java.util.List;

public class NaveTransporte extends UnidadProtoss {
    private static int tranporteMax = 8;
    private List<Cargable> unidades;

    public NaveTransporte(){
        super(60,80);
        this.vision = 8;
        this.ubicacion = new Aereo();
        this.suministro=2;
        this.costo=new Costo(200,0);
        this.unidades= new ArrayList<Cargable>();
        this.tiempoDeEntrenamiento = 8;
    }

    @Override
    public void update() {
        this.escudo.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioAire());
    }

    public void cargar(Cargable unidad) throws ExcepcionCargaSuperada { // fijarse de delegar esto
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
        ProxyMapa mapa = ProxyMapa.getInstance();
        // Por el proxy agrego que tiran excepciones
        try {
            mapa.agregar((ColocableEnMapa)unidades.remove(0),coordenadas);
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }
    }

    @Override
    public ColocableEnMapa getClone() {
        return null;// TODO:implementar
    }
}