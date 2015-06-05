package unidades;

import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import interfaces.Entrenable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class Unidad implements Actualizable, ColocableEnMapa , Daniable,Entrenable  {
    protected String nombre;
    protected Vida vida;
    protected int vision;
    protected Ubicacion ubicacion;
    protected Costo costo;
    protected int suministro;
    protected Estado estado;
    private int tiempoDeConstruccion;

    protected Unidad(){
        this.estado=new EstadoNormal();
    }

    public Vida getVida() {
        return vida;
    }

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
    	return tiempoDeConstruccion;
    }
    
    @Override
    public void disminuirTiempoDeEntrenamiento(){
    	tiempoDeConstruccion--;
    }
    
    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {
        this.ubicacion.agregarse(this, mapa, coordenadas);
    }
    
    
    /*
	public String getNombre() {
		return nombre;
	}
*/
	public int getSuministro() {

		return suministro;
	}

    public void Matar() {
        if(this.vida.estaMuerto()){
            //Mapa mapa =SingletonMapa.getInstance();
            //mapa.Quitar(this);
        }
    }
    public void update(){
        this.estado.update(this);
    }
    public void irradiar(){
        this.estado= new EstadoIrradiado();
    }
    public  void recibirEMP(){

    };

}
