package modelo.unidades.protoss;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionAtacarAUnidadAliada;
import modelo.excepciones.Unidades.ExcepcionNoPuedeAtacarAire;
import modelo.excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import modelo.excepciones.Unidades.ExcepcionYaActuo;
import modelo.interfaces.Cargable;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Daniable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Danio;
import modelo.unidades.Terrestre;
import modelo.unidades.UnidadGuerrera;

public class Zealot extends UnidadGuerrera implements Cargable {

    public Zealot(Vision visionJugador){
        super(new ResistenciaProtoss(100,60),new Danio(8,0,1,0),7,new Terrestre(),2,new Costo(100,0),4,5,visionJugador,2);
    }

    public Zealot(){
        super(new ResistenciaProtoss(100,60),new Danio(8,0,1,0),7,new Terrestre(),2,new Costo(100,0),4,5);
    }

    public int getEscudo() {
        return ((ResistenciaProtoss)resistencia).getEscudoActual();
    }

    public ColocableEnMapa getClon() {
        ResistenciaProtoss resistenciaProtoss = new ResistenciaProtoss(resistencia.getVidaMaxima(),((ResistenciaProtoss) resistencia).getEscudoActual());

        return new ClonGuerrero(resistenciaProtoss,this.vision,this.ubicacion,this.movilidad,this.transporte,this);
    }

    public void atacarAire(Daniable objetivo) throws ExcepcionObjetivoFueraDeRango, ExcepcionAtacarAUnidadAliada, ExcepcionYaActuo, ExcepcionNoPuedeAtacarAire {
        throw new ExcepcionNoPuedeAtacarAire();
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
