package unidades;

import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class Unidad implements Actualizable, ColocableEnMapa , Daniable {
    protected String nombre;
    protected Vida vida;
    protected int vision;
    protected Ubicacion ubicacion;
    protected Costo costo;
    protected int suministro;


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
