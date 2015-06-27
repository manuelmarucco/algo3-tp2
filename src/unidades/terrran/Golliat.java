package unidades.terrran;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.Cargable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Danio;
import unidades.Terrestre;
import unidades.UnidadGuerrera;

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
