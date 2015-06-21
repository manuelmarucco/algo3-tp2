package vista.Actions.accionesConstruir;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface AccionConstruir {
    void construirEn(Coordenadas coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa;
}
