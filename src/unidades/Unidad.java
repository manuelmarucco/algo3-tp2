package unidades;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import interfaces.Entrenable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class Unidad implements Actualizable, ColocableEnMapa , Daniable,Entrenable  {
    protected Vida vida;
    protected int vision;
    protected Ubicacion ubicacion;
    protected Costo costo;
    protected int suministro;
    protected EstadoUnidad estado;
    protected int tiempoDeEntrenamiento;

    protected Unidad(){
        this.estado=new EstadoNormal();
    }

    public Vida getVida() {
        return vida;
    }
    
    @Override
    public Costo getCosto(){
        return costo;
    }

    public int getVision() {
        return vision;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    
    @Override
    public int getTiempoDeEntrenamiento(){
    	return tiempoDeEntrenamiento;
    }
    
    @Override
    public void disminuirTiempoDeEntrenamiento(){
    	tiempoDeEntrenamiento--;
    }

    // TODO: No se como arreglar este.
    @Override
    public void agregarse(Coordenadas coordenadas) throws ExcepcionPosicionOcupada {

       //ProxyMapa proxyMapa = ProxyMapa.getInstance();
       //proxyMapa.agregarse(coordenadas);

    }

    @Override
	public int getSuministro() {

		return suministro;
	}

    protected void matar() {
        if(this.vida.estaMuerto()){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
        }
    }

    public void update(){
        this.estado.update(this);
    }

    public void irradiar(){
        this.estado= new EstadoIrradiado();
    }

    public  void recibirEMP(){}

}
