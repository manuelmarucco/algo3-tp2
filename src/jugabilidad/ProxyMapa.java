package jugabilidad;

import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;

public class ProxyMapa {

    // Atributos ----

    private static ProxyMapa proxy;
    private Mapa mapa = new Mapa();
    private int coordenadaXMaxima;
    private int coordenadaYMaxima;

    // Metodos ---

    public static ProxyMapa getInstance(){
        if(proxy==null){
            proxy=new ProxyMapa();
        }
        return proxy;
    }

    private ProxyMapa(){

    }

    public void setCoordenadasMaximas(int coordenadaXMaxima, int coordenadaYMaxima){

        this.coordenadaXMaxima = coordenadaXMaxima;
        this.coordenadaYMaxima = coordenadaYMaxima;

    }

    // Metodos de mapa ----

    public void agregar(ColocableEnMapa colocable, Coordenadas coordenadas)
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa{

        validarCoordenadas(coordenadas);
        mapa.agregar(colocable, coordenadas);

    }

    public boolean posicionAereaOcupada(Coordenadas coordenadas)
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa {

        validarCoordenadas(coordenadas);
        return (this.mapa.posicionAereaOcupada(coordenadas));
    }

    public boolean posicionTerrestreOcupada(Coordenadas coordenadas)
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa {

        validarCoordenadas(coordenadas);
        return (this.mapa.posicionTerrestreOcupada(coordenadas));

    }

    public Coordenadas getCoordenada(final ColocableEnMapa daniable){

        return ( this.mapa.getCoordenada(daniable) );
    }

    public void quitar(Unidad unidad){
        this.mapa.quitar(unidad);
    }

    // Metodos Privados

    private void validarCoordenadas(Coordenadas coordenadas)
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa {
        if ( coordenadas.getX() > coordenadaXMaxima ) {
            throw new ExcepcionCoordenadaXIngresadaFueraDelMapa();
        }
        if ( coordenadas.getY() > coordenadaYMaxima ) {
            throw new ExcepcionCoordenadaYIngresadaFueraDelMapa();
        }
    }

}
