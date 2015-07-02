package modelo.interfaces;

import modelo.excepciones.Unidades.ExcepcionNoSePUedeClonarALaUnidad;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;

public interface Clonable {
    ColocableEnMapa getClon() throws ExcepcionNoSePuedeClonarEdificio, ExcepcionNoSePUedeClonarALaUnidad;
}
