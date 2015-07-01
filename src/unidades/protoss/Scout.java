package unidades.protoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Aereo;
import unidades.Danio;
import unidades.UnidadGuerrera;

public class Scout extends UnidadGuerrera {

    public Scout(){
        super(new ResistenciaProtoss(150,100),new Danio(8,14,4,4),7,new Aereo(),3,new Costo(300,150),9,5);
    }

    public Scout(Vision visionJugador){
        super(new ResistenciaProtoss(150,100),new Danio(8,14,4,4),7,new Aereo(),3,new Costo(300,150),9,5,visionJugador,0);
    }

    public ColocableEnMapa getClon() {
        ResistenciaProtoss resistenciaProtoss = new ResistenciaProtoss(resistencia.getVidaMaxima(),((ResistenciaProtoss) resistencia).getEscudoActual());

        return new ClonGuerrero(resistenciaProtoss,this.vision,this.ubicacion,this.movilidad,this.transporte,this);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }

    @Override
    public  void recibirEMP(){
        this.resistencia.quitar(this.getEscudo());
    }

}
