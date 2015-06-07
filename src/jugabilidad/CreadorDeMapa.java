package jugabilidad;

import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Cristal;
import recursos.Volcan;

public class CreadorDeMapa {

    private void agregarMinerales( ProxyMapa mapa ) throws ExcepcionNoSePudoAgregarAlMapa {

        // Recursos en la esquina superior izquierda del mapa.
        Coordenadas coordenadas = new Coordenadas(2,9);
        Cristal cristal = new Cristal();
        mapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(4,7);
        Volcan volcan = new Volcan();
        mapa.agregar(volcan,coordenadas);

        // Recursos en la esquina inferior derecha del mapa.
        coordenadas = new Coordenadas(9,2);
        cristal = new Cristal();
        mapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(7,4);
        volcan = new Volcan();
        mapa.agregar(volcan,coordenadas);

    }
    //TODO: arreglar esto
    /*
    public Mapa crearMapa(){

        Mapa mapa = new Mapa();
        this.agregarMinerales(mapa);

        return mapa;

    }
*/
}
