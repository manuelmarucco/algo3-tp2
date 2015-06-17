package jugabilidad.extrasJuego;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import recursos.Cristal;
import recursos.Volcan;

import java.util.ArrayList;

public class CreadorDeMapa {

    //TODO refactor de manera tal de recibir en el constructor la cantidad de jugadores Y VALIDARLA
    // y generar el mapa en base a eso, reveer base uno y base dos

    private void agregarMineralesAlMapa() throws ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        // Recursos en la esquina superior izquierda del mapa.
        Coordenadas coordenadas = new Coordenadas(3,23);
        Cristal cristal = new Cristal();
        proxyMapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(5,21);
        Volcan volcan = new Volcan();
        proxyMapa.agregar(volcan,coordenadas);

        // Recursos en la esquina inferior derecha del mapa.
        coordenadas = new Coordenadas(21,5);
        cristal = new Cristal();
        proxyMapa.agregar(cristal,coordenadas);

        coordenadas = new Coordenadas(23,3);
        volcan = new Volcan();
        proxyMapa.agregar(volcan,coordenadas);

    }

    private void agregarZonasExclusivamenteAereasAlMapa() throws ExcepcionNoSePudoAgregarAlMapa {

        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        Coordenadas coordenadas = new Coordenadas(12,12);
        NullPosicionTerrestre nulo = new NullPosicionTerrestre();

        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(12,13);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(13,12);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(13,13);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(13,14);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(14,13);
        proxyMapa.agregar(nulo, coordenadas);

        coordenadas = new Coordenadas(14,14);
        proxyMapa.agregar(nulo, coordenadas);

    }

    public ProxyMapa crearMapa(){

        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(25,25);

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

    public ArrayList<Coordenadas> obtenerCoordenadasDeLasBases(){

        ArrayList<Coordenadas> bases = new ArrayList<>();

        Coordenadas baseUno = new Coordenadas(4,22);
        bases.add(baseUno);

        Coordenadas baseDos = new Coordenadas(22,4);
        bases.add(baseDos);

        return ( bases );

    }



}
