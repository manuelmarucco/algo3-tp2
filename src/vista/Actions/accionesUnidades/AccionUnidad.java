package vista.Actions.accionesUnidades;

import modelo.excepciones.Mapa.ExcepcionCasillaVacia;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.*;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

public interface AccionUnidad {
    void actuarEn(Coordenada coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionMoverfueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaSeMovioLaUnidad, ExcepcionYaActuo, ExcepcionCargarUnidadEnemiga, ExcepcionCargaSuperada, ExcepcionCasillaVacia, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeClonarEdificio;
}
