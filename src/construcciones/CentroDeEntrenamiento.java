package construcciones;

import excepciones.ExcepcionRecursosInsuficientes;
import excepciones.ExcepcionSuministrosInsuficientes;
import interfaces.Entrenable;
import jugabilidad.Jugador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class CentroDeEntrenamiento extends Construccion{

    protected Queue<Entrenable> colaDeEntrenamiento = new LinkedList<Entrenable>();
    protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<Entrenable>();
    protected Jugador jugador;

    protected void crearUnidad(Entrenable unidad) {

        try {
            jugador.getRecursos().gastarRecursos(unidad.getCosto());
        } catch (ExcepcionRecursosInsuficientes e) {
            e.printStackTrace();
            return;
        }

        try {
            jugador.usarSuministrosDisponibles(unidad.getSuministro());
        } catch (ExcepcionSuministrosInsuficientes e) {
            e.printStackTrace();
        }

        jugador.agregarUnidad(unidad);
        colaDeEntrenamiento.remove();
        //FALTA AGREGARSE AL MAPA

    }

    @Override
    public void update() {

        super.update();

        if(!this.colaDeEntrenamiento.isEmpty()){
            Entrenable unidad= this.colaDeEntrenamiento.peek();

            unidad.disminuirTiempoDeEntrenamiento();

            if(unidad.getTiempoDeEntrenamiento() == 0){
                this.crearUnidad(unidad);
            }
        }
        //this.regenerar.regenerar(this);
    }

}
