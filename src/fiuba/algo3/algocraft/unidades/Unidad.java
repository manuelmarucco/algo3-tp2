package fiuba.algo3.algocraft.unidades;

import auxiliares.Costo;
import fiuba.algo3.algocraft.comandos.Accion;
import interfaces.Actuable;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashMap;

public class Unidad implements Actualizable, ColocableEnMapa {
    private String nombre;
	private ClaseDeUnidad clase;
    private Vida vida;
    private int vision;
    private Ubicacion ubicacion;
    private HashMap<Accion, Actuable> poolDeAcciones;
    private Costo costo;
    private int suministro;

    public Unidad(String nombre,Vida vida, int vision, Ubicacion ubicacion, ClaseDeUnidad clase , Costo costo, int suministro) {
        this.nombre = nombre;
    	this.vida=vida;
        this.vision=vision;
        this.ubicacion =ubicacion;
        this.clase=clase;
        this.costo=costo;
        this.poolDeAcciones=new HashMap<Accion, Actuable>();
        this.clase.agregarMetodosUpdate(poolDeAcciones);
        this.suministro=suministro;
    }

    public Vida getVida() {
        return vida;
    }

    public Costo getCosto(){
        return costo;
    }

    public void update(){
        for(Accion a: this.poolDeAcciones.keySet()){
            poolDeAcciones.get(a).actuar(this);
        }
    }

    public int getVision() {
        return vision;
    }

    public void recibirDanio(Danio danio) {
        this.vida.quitar(this.ubicacion.danioDe(danio));
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public ClaseDeUnidad getClase() {
        return clase;
    }

    public void actuar(Accion accion, Unidad objetivo) {
        this.clase.actuar(accion, objetivo);
    }

    public void agregarAccion(Accion nombre,Actuable accion){
        poolDeAcciones.put(nombre, accion);
    }

    public HashMap<Parametros,Integer>  getParametroDeClase() {
        return this.clase.getParametros();
    }

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {
        this.ubicacion.agregarse(this, mapa, coordenadas);
    }

	public String getNombre() {
		return nombre;
	}

	public int getSuministro() {
		
		return suministro;
	}
}
