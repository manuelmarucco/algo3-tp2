package jugabilidad.extrasJuego;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import recursos.Cristal;
import recursos.Volcan;

public class CreadorDeMapa {

    private void agregarMineralesAlMapa() throws ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        // Recursos en la esquina superior izquierda del mapa.
        Coordenadas coordenadas = new Coordenadas(2,19);
        Cristal cristal = new Cristal();
        proxyMapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(4,16);
        Volcan volcan = new Volcan();
        proxyMapa.agregar(volcan,coordenadas);

        // Recursos en la esquina inferior derecha del mapa.
        coordenadas = new Coordenadas(19,2);
        cristal = new Cristal();
        proxyMapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(16,4);
        volcan = new Volcan();
        proxyMapa.agregar(volcan,coordenadas);

    }

    private void agregarZonasExclusivamenteAereasAlMapa() throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        Coordenadas coordenadas = new Coordenadas(9,10);
        NullPosicionTerrestre nulo = new NullPosicionTerrestre();

        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(10,10);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(9,11);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(10,11);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(11,12);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(10,12);
        proxyMapa.agregar(nulo, coordenadas);

    }

    public ProxyMapa crearMapa(){

        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        try {
            this.agregarMineralesAlMapa();
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }
        try {
            this.agregarZonasExclusivamenteAereasAlMapa();
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }

        return proxyMapa;

    }



}
