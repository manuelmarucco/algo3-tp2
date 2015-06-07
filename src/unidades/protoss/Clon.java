package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import unidades.Danio;
import unidades.Escudo;
import unidades.Ubicacion;
import unidades.Vida;

public class Clon extends Unidad implements ColocableEnMapa {

    public Clon(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion) {
        super(resistencia,vision,ubicacion,0,new Costo(0,0),0);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioAire());
        this.matar();
    }
    @Override
    public void matar(){
        if(((ResistenciaProtoss)resistencia).getEscudoActual()==0){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
        }
    }

    public  void recibirEMP(){
        this.matar();
    }
}
