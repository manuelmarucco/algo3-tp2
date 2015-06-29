package interfaces;

import excepciones.Unidades.ExcepcionNoSePUedeClonarALaUnidad;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;

public interface Clonable {
    ColocableEnMapa getClon() throws ExcepcionNoSePuedeClonarEdificio, ExcepcionNoSePUedeClonarALaUnidad;
}
