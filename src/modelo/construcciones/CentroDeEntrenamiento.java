package modelo.construcciones;

import modelo.excepciones.ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeEdificio;
import modelo.excepciones.ExcepcionNoSePuedeEntrenarUnidadPorRecursosInsuficientes;
import modelo.excepciones.ExcepcionNoSePuedeEntrenarUnidadPorSuministrosInsuficientes;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.excepciones.construcciones.ExcepcionRecursosInsuficientes;
import modelo.excepciones.construcciones.ExcepcionSuministrosInsuficientes;
import modelo.interfaces.Entrenable;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

import java.util.LinkedList;
import java.util.Queue;

public abstract class CentroDeEntrenamiento extends Construccion{

    protected Queue<Entrenable> colaDeEntrenamiento = new LinkedList<>();
    protected Jugador jugador;

    private void crearUnidad(Entrenable unidad) throws ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeEdificio {
        boolean agregadoAlMapa = false;
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada coordenadaDeEdificio = mapa.getCoordenada(this);
        Coordenada coordenadaDeUnidad = new Coordenada(coordenadaDeEdificio.getX()-1,coordenadaDeEdificio.getY()-1);

        while(!agregadoAlMapa) {
            try {
                mapa.agregar(unidad, coordenadaDeUnidad);
                agregadoAlMapa = true;
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {
                if(!this.modicarCoordenadaAlrededorDeEdificio(coordenadaDeUnidad)){
                   throw new ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeEdificio();
                }
                //Se modifica la coordenada de tal manera que la unidad se ubique alrededor del edificio.
                //Si no puede ubicarlo en ninguna de las posiciones de alrededor, entonces no lo agrega y devuelve
                //la excepcion
            }
        }
        jugador.agregarUnidad(unidad);
        colaDeEntrenamiento.remove();

    }

    private boolean modicarCoordenadaAlrededorDeEdificio(Coordenada coordenadaDeUnidad) {
        ProxyMapa mapa = ProxyMapa.getInstance();
        Coordenada coordenadaDeEdificio = mapa.getCoordenada(this);

        if(coordenadaDeUnidad.getX()<1+coordenadaDeEdificio.getX()){
                    coordenadaDeUnidad.aumentarX(1);
        }
        else {
            coordenadaDeUnidad.aumentarX(-2);
            if (coordenadaDeUnidad.getY() < 1 + coordenadaDeEdificio.getY()) {
                coordenadaDeUnidad.aumentarY(1);
            } else return false;
        }

        return true;

        }


    protected void validarCreacionUnidad(Entrenable unidad) throws ExcepcionNoSePuedeEntrenarUnidad {
        try {
            jugador.getRecursos().gastarRecursos(unidad.getCosto());
        } catch (ExcepcionRecursosInsuficientes e) {
            throw new ExcepcionNoSePuedeEntrenarUnidadPorRecursosInsuficientes();
        }

        try {
            jugador.usarSuministrosDisponibles(unidad.getSuministro());
        } catch (ExcepcionSuministrosInsuficientes e) {
            throw new ExcepcionNoSePuedeEntrenarUnidadPorSuministrosInsuficientes();
        }
    }

    @Override
    public void update() {

        super.update();

        if(!this.colaDeEntrenamiento.isEmpty()){
            Entrenable unidad= this.colaDeEntrenamiento.peek();

            unidad.disminuirTiempoDeEntrenamientoActual();

            if(unidad.getTiempoDeEntrenamientoActual() == 0){
                try {
                    this.crearUnidad(unidad);
                   // this.colaDeEntrenamiento.poll();
                } catch (ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeEdificio e) {
                    e.printStackTrace();
                }
            }
        }
        //this.regenerar.regenerar(this);
    }

    public Queue<Entrenable> getColaDeEntrenamiento(){
        return colaDeEntrenamiento;
    }


}
