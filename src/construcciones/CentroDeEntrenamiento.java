package construcciones;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import excepciones.construicciones.ExcepcionRecursosInsuficientes;
import excepciones.construicciones.ExcepcionSuministrosInsuficientes;
import interfaces.Entrenable;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.LinkedList;
import java.util.Queue;

public abstract class CentroDeEntrenamiento extends Construccion{

    protected Queue<Entrenable> colaDeEntrenamiento = new LinkedList<>();
   // protected ArrayList<Entrenable> unidadesCreadas = new ArrayList<>();
    protected Jugador jugador;

    private void crearUnidad(Entrenable unidad) {
        boolean agregadoAlMapa = false;
        int x = -1,y = -1;
        ProxyMapa mapa = ProxyMapa.getInstance();

        Coordenadas c = mapa.getCoordenada(this);
        while(!agregadoAlMapa) {
            ProxyMapa proxyMapa = ProxyMapa.getInstance();
            try {
                proxyMapa.agregar(unidad, new Coordenadas(c.getX()+x,c.getY()+y));
                agregadoAlMapa = true;
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {

                if(y<1) y++;
                else {
                    y = -1;
                    if (x<1) x++;
                    else e.printStackTrace();
                }
                //Si no pudo agregarlo alrededor no lo agrega
            }
        }
        jugador.agregarUnidad(unidad);
        colaDeEntrenamiento.remove();

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
