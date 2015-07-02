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

public class Marine extends UnidadGuerrera implements Cargable {

    public Marine(){
        super(new ResistenciaTerran(40),new Danio(6,6,4,4),7,new Terrestre(),1,new Costo(50,0),3,5);
    }

    public Marine(Vision visionJugador){
        super(new ResistenciaTerran(40),new Danio(6,6,4,4),7,new Terrestre(),1,new Costo(50,0),3,5,visionJugador,1);
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaTerrestre(this, hasta);

    }

}
