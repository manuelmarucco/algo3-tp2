package modelo.unidades.protoss;

import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.unidades.Unidad;
import modelo.unidades.Estado.NoActuo;
import modelo.unidades.Ubicacion;

public class Clon extends Unidad implements ColocableEnMapa {

    private final Unidad unidad;

    public Clon(ResistenciaProtoss resistencia, int vision, Ubicacion ubicacion,int movilidad,int transporte,Unidad unidad) {
        super(resistencia,vision,ubicacion,0,new Costo(0,0),0,movilidad,null,transporte);
        this.unidad=unidad;
    }

    @Override
    public void recibirDanio(int danio) {
        this.resistencia.quitar(danio);
    }
    
    @Override
    public void matar(){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
            this.resistencia.quitar(resistencia.getVidaActual());
    }

    public  void recibirEMP(){
        this.matar();
    }

    public int getEscudo(){
        return ((ResistenciaProtoss)this.resistencia).getEscudoActual();
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void update(){
        this.estado.update(this);
        this.accion=new NoActuo();
    }
}
