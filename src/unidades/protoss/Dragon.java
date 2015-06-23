package unidades.protoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

public class Dragon extends UnidadGuerrera implements Cargable {

    public Dragon(){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6);
    }

    public Dragon(Vision visionJugador){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6,visionJugador,4);
    }

    public ColocableEnMapa getClone() {
        return new ClonGuerrero((ResistenciaProtoss)this.resistencia,this.vision,this.ubicacion,this.movilidad,this.transporte);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaTerrestre(this, hasta);

    }
}
