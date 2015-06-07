package unidades;

import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import interfaces.Entrenable;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class Unidad implements Actualizable, ColocableEnMapa , Daniable,Entrenable  {
    protected Resistencia resistencia;
    protected int vision;
    protected Ubicacion ubicacion;
    protected Costo costo;
    protected int suministro;
    protected EstadoUnidad estado;
    protected int tiempoDeEntrenamiento;

    protected Unidad(Resistencia resistencia,int vision,Ubicacion ubicacion,int suministro,Costo costo,int tiempoDeEntrenamiento){
        this.resistencia= resistencia;
        this.estado=new EstadoNormal();
        this.vision=vision;
        this.ubicacion=ubicacion;
        this.suministro=suministro;
        this.costo=costo;
        this.tiempoDeEntrenamiento=tiempoDeEntrenamiento;
    }

    public Resistencia getVida() {
        return resistencia;
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
    public void agregarse(Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa{

       ProxyMapa proxyMapa = ProxyMapa.getInstance();
       proxyMapa.agregarEnCapaTerrestre(this, coordenadas);

    }

    @Override
	public int getSuministro() {

		return suministro;
	}

    protected void matar() {
        if(this.resistencia.estaMuerto()){
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

    public ColocableEnMapa getClone() {
        return null;
    }
}
