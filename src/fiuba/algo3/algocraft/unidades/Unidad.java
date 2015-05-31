package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;
import interfaces.Actuable;

import java.util.HashMap;

public class Unidad implements Regenerable {
    private ClaseDeUnidad clase;
    private Vida vida;
    private int vision;
    private Ubicacion ubicacion;
    private Regeneracion regenerar;
    private HashMap<Accion, Actuable> poolDeAcciones;

    public Unidad(Vida vida, int vision, Ubicacion ubicacion, ClaseDeUnidad clase) {
        this(vida, vision, ubicacion, clase, new NoRegenerar());
    }

    public Unidad(Vida vida, int vision, Ubicacion ubicacion, ClaseDeUnidad clase, Regeneracion regenerar) {
        this.vida=vida;
        this.vision=vision;
        this.regenerar=regenerar;
        this.ubicacion =ubicacion;
        this.clase=clase;
    }

    public Vida getVida() {
        return vida;
    }

    public void update(){
        this.regenerar.regenerar(this);
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
}
