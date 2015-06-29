package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import jugabilidad.utilidadesMapa.Coordenada;

public interface AccionUnidad {
    void actuarEn(Coordenada coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionMoverfueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaSeMovioLaUnidad, ExcepcionYaActuo, ExcepcionCargarUnidadEnemiga, ExcepcionCargaSuperada, ExcepcionCasillaVacia, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeClonarEdificio;
}
