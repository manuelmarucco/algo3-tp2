package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import jugabilidad.utilidadesMapa.Coordenada;

public interface AccionUnidad {
    void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa, ExcepcionCasillaVacia;
}
