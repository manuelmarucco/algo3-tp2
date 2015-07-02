package modelo.unidades;

import modelo.excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;

public abstract class UnidadMagica extends Unidad{

    protected Energia energia;

    public UnidadMagica(Resistencia resistencia, Energia energia, int vision, Ubicacion aereo, int suministros, Costo costo, int tiempoDeEntrenamiento,int movilidad, Vision visionJugador,int transporte) {
        super(resistencia,vision,aereo,suministros,costo,tiempoDeEntrenamiento,movilidad,visionJugador,transporte);
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

    public int getEnergiaActual(){
        return this.energia.getEnergiaActual();
    }

    public Energia getEnergia(){
        return energia;
    }

}
