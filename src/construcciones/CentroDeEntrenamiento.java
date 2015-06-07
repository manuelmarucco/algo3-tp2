package construcciones;

import excepciones.ExcepcionNoSePuedeEntrenarUnidad;
import excepciones.ExcepcionRecursosInsuficientes;
import excepciones.ExcepcionSuministrosInsuficientes;
import interfaces.Entrenable;
import jugabilidad.Jugador;

import java.util.LinkedList;
import java.util.Queue;

public abstract class CentroDeEntrenamiento extends Construccion{

    protected Queue<Entrenable> colaDeEntrenamiento = new LinkedList<>();
   // protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<>();
    protected Jugador jugador;

    protected void crearUnidad(Entrenable unidad) {

        jugador.agregarUnidad(unidad);
        colaDeEntrenamiento.remove();
        //FALTA AGREGARSE AL MAPA

    }

    protected void validarCreacionUnidad(Entrenable unidad) throws ExcepcionNoSePuedeEntrenarUnidad {
        try {
            jugador.getRecursos().gastarRecursos(unidad.getCosto());
        } catch (ExcepcionRecursosInsuficientes e) {
            e.printStackTrace();
            throw new ExcepcionNoSePuedeEntrenarUnidad();
        }

        try {
            jugador.usarSuministrosDisponibles(unidad.getSuministro());
        } catch (ExcepcionSuministrosInsuficientes e) {
            e.printStackTrace();
            throw new ExcepcionNoSePuedeEntrenarUnidad();
        }
    }

    @Override
    public void update() {

       // super.update();

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
