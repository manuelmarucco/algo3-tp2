package modelo.unidades.protoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.interfaces.Cargable;
import modelo.interfaces.Clonable;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Danio;
import modelo.unidades.Terrestre;
import modelo.unidades.UnidadGuerrera;

public class Dragon extends UnidadGuerrera implements Cargable, Clonable {

    public Dragon(){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6);
    }

    public Dragon(Vision visionJugador){
        super(new ResistenciaProtoss(100, 80), new Danio(20, 20, 4, 4), 8, new Terrestre(), 2, new Costo(125, 50), 6,6,visionJugador,4);
    }

    public ColocableEnMapa getClon() throws ExcepcionNoSePuedeClonarEdificio{
        ResistenciaProtoss resistenciaProtoss = new ResistenciaProtoss(resistencia.getVidaMaxima(),((ResistenciaProtoss) resistencia).getEscudoActual());

        return new ClonGuerrero(resistenciaProtoss,this.vision,this.ubicacion,this.movilidad,this.transporte,this);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaTerrestre(this, hasta);

    }

    @Override
    public  void recibirEMP(){
        this.resistencia.quitar(this.getEscudo());
    }
}
