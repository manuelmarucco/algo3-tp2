package unidades;

import excepciones.EnergiaInsuficiente;
import jugabilidad.auxiliares.Costo;

public abstract class UnidadMagica extends Unidad{

    protected Energia energia;

    public UnidadMagica(Resistencia resistencia, Energia energia, int vision, Ubicacion aereo, int suministros, Costo costo, int tiempoDeEntrenamiento) {
        super(resistencia,vision,aereo,suministros,costo,tiempoDeEntrenamiento);
        this.energia=energia;
    }

    @Override
    public void update() {
        this.energia.regenerar();
    }

    public  void recibirEMP(){
        try {
            this.energia.gastar(this.energia.getEnergiaActual());
        } catch (EnergiaInsuficiente energiaInsuficiente) {}
    }
}
