package unidades.protoss;

import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import unidades.Ubicacion;
import unidades.Unidad;

public class Clon extends Unidad implements ColocableEnMapa {

    public Clon(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion,int movilidad) {
        super(resistencia,vision,ubicacion,0,new Costo(0,0),0,movilidad);
    }

    @Override
    public void recibirDanio(int danio) {
        this.resistencia.quitar(danio);
    }
    @Override
    public void matar(){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
    }

    public  void recibirEMP(){
        this.matar();
    }
}
