package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionCasillaVacia;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.*;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface AccionUnidad {
    void actuarEn(Coordenadas coordenada) throws ExcepcionAtacarAUnidadAliada, ExcepcionObjetivoFueraDeRango, ExcepcionMoverfueraDeRango, ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaSeMovioLaUnidad, ExcepcionYaActuo, ExcepcionCargarUnidadEnemiga, ExcepcionCargaSuperada, ExcepcionCasillaVacia;
}
