package modelo.unidades.terrran;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.Cargable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Danio;
import modelo.unidades.Terrestre;
import modelo.unidades.UnidadGuerrera;

public class Golliat extends UnidadGuerrera implements Cargable {

    public Golliat(){
        super(new ResistenciaTerran(125),new Danio(12,10,6,5),8,new Terrestre(),2, new Costo(100,50),6,6);
    }

    public Golliat(Vision visionJugador){
        super(new ResistenciaTerran(125),new Danio(12,10,6,5),8,new Terrestre(),2, new Costo(100,50),6,6,visionJugador,2);
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaTerrestre(this, hasta);

    }

}
