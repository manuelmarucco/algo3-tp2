package modelo.unidades.protoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Aereo;
import modelo.unidades.Danio;
import modelo.unidades.UnidadGuerrera;

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
