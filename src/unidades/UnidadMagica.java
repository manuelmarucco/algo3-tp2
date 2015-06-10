package unidades;

import excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;

public abstract class UnidadMagica extends Unidad{

    protected Energia energia;

    public UnidadMagica(Resistencia resistencia, Energia energia, int vision, Ubicacion aereo, int suministros, Costo costo, int tiempoDeEntrenamiento,int movilidad, Vision visionJugador) {
        super(resistencia,vision,aereo,suministros,costo,tiempoDeEntrenamiento,movilidad,visionJugador);
        this.energia=energia;
    }
    public UnidadMagica(Resistencia resistencia, Energia energia, int vision, Ubicacion aereo, int suministros, Costo costo, int tiempoDeEntrenamiento,int movilidad) {
        super(resistencia,vision,aereo,suministros,costo,tiempoDeEntrenamiento,movilidad);
        this.energia=energia;
    }

    @Override
    public void update() {
        super.update();
        this.energia.regenerar();
    }

    public  void recibirEMP(){
        try {
            this.energia.gastar(this.energia.getEnergiaActual());
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {}
    }

    public int getEnergia(){
        return this.energia.getEnergiaActual();
    }
}
