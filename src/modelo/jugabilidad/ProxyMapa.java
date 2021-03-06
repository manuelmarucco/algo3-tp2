package modelo.jugabilidad;

import modelo.excepciones.Mapa.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import modelo.excepciones.Mapa.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Unidad;

import java.util.ArrayList;

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

    public static void resetear(){
        proxy=null;
    }

    public void setCoordenadasMaximas(int coordenadaXMaxima, int coordenadaYMaxima){

        this.coordenadaXMaxima = coordenadaXMaxima;
        this.coordenadaYMaxima = coordenadaYMaxima;

    }

    // Agregar ----

    public void agregar(ColocableEnMapa colocable, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa {

        validarCoordenadas(coordenada);
        colocable.agregarse(mapa, coordenada);

    }

    // Obtener ---

    public ArrayList<ColocableEnMapa> obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(Coordenada centro, int radio)
            throws ExcepcionNoSePudoAgregarAlMapa {

        this.validarCoordenadas(centro);
        return (this.mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(centro, radio));

    }

    public ColocableEnMapa obtenerDeCapaTerrestre(Coordenada coordenada){
        return ( this.mapa.obtenerDeCapaTerrestre(coordenada) );
    }

    public ColocableEnMapa obtenerDeCapaAerea(Coordenada coordenada){
        return ( this.mapa.obtenerDeCapaAerea(coordenada) );
    }

    public ColocableEnMapa obtenerDeCapaDeRecursos(Coordenada coordenada){

        return ( this.mapa.obtenerDeCapaDeRecursos(coordenada) );
    }

    // Remover ---

    public void borrarEnCapaTerrestre(Coordenada coordenada){

        this.mapa.borrarEnCapaTerrestre(coordenada);

    }

    // Mover ---

    public void mover(Coordenada hasta, ColocableEnMapa unidad)
        throws ExcepcionNoSePudoAgregarAlMapa {

        this.validarCoordenadas(hasta);
        unidad.moverse(hasta, this.mapa);

    }

    // ---

    public boolean posicionAereaOcupada(Coordenada coordenada) {

        return (this.mapa.posicionAereaOcupada(coordenada));
    }

    public boolean posicionTerrestreOcupada(Coordenada coordenada) {

        return (this.mapa.posicionTerrestreOcupada(coordenada));

    }

    public Coordenada getCoordenada(final ColocableEnMapa daniable){

        return ( this.mapa.getCoordenada(daniable) );
    }

    public void quitar(Unidad unidad){

        this.mapa.quitar(unidad);

    }

    // Metodos Privados

    private void validarCoordenadas(Coordenada coordenada)
            throws ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa {
        if ( coordenada.getX() > coordenadaXMaxima ) {
            throw new ExcepcionCoordenadaXIngresadaFueraDelMapa();
        }
        if ( coordenada.getY() > coordenadaYMaxima ) {
            throw new ExcepcionCoordenadaYIngresadaFueraDelMapa();
        }
    }

}
