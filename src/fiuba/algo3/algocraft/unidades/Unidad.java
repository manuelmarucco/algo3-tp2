package fiuba.algo3.algocraft.unidades;

import fiuba.algo3.algocraft.comandos.Accion;

public class Unidad {
    private Danio danio;
    private ClaseDeUnidad clase;
    private Vida vida;
    private int vision;
    private Ubicacion ubicacion;
    private Regenerable regenerar;

    public Unidad(Vida vida, int vision) {
        this.vida=vida;
        this.vision=vision;
    }

    public Unidad(Vida vida, Danio danio, int vision, Ubicacion ubicacion, ClaseDeUnidad clase) {
        this(vida, danio, vision, ubicacion, clase, new NoRegenerar());
    }
    public Unidad(Vida vida, Danio danio, int vision, Ubicacion ubicacion, ClaseDeUnidad clase, Regenerable regenerar) {
        this.vida=vida;
        this.danio = danio;
        this.vision=vision;
        this.regenerar=regenerar;
        this.ubicacion =ubicacion;
        this.clase=clase;
    }

    public Vida getVida() {
        return vida;
    }

    public Danio getDanio() {
        return danio;
    }

    public int getVision() {
        return vision;
    }

    public void recibirDanio(Unidad atacante) {
        this.vida.quitar(this.ubicacion.danioDe(atacante.getDanio()));
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public ClaseDeUnidad getClase() {
        return clase;
    }

    public void actuar(Accion accion, Unidad objetivo) {
        this.clase.actuar(accion,objetivo,this);
    }
}
