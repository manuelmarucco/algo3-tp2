package unidades;

import excepciones.ExcepcionCargaSuperada;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.LinkedList;
import java.util.Queue;

public abstract class UnidadTransporte extends Unidad {

    private static int tranporteMax = 8;
    private Queue<Cargable> unidades;

    public UnidadTransporte(Resistencia resistencia,int vision, Aereo aereo, int suministros, Costo costo, int tiempoDeEntrenamiento) {
        super(resistencia,vision, aereo, suministros, costo, tiempoDeEntrenamiento);
        this.unidades= new LinkedList<>();
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
        //Mapa mapa=SingletonMapa.getInstance();
        ProxyMapa proxy = ProxyMapa.getInstance();
        //TODO: ver esto
        try {
            proxy.agregar((ColocableEnMapa)unidades.remove(),coordenadas);
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }
    }
}
