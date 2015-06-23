package jugabilidad;

import excepciones.Mapa.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.Mapa.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Unidad;

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

    public void agregar(ColocableEnMapa colocable, Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa {

        validarCoordenadas(coordenadas);
        colocable.agregarse(mapa,coordenadas);

    }

    // Obtener ---

    public ArrayList<ColocableEnMapa> obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(Coordenadas centro, int radio)
            throws ExcepcionNoSePudoAgregarAlMapa {

        this.validarCoordenadas(centro);

        return (this.mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(centro, radio));

    }

    public ColocableEnMapa obtenerDeCapaTerrestre(Coordenadas coordenadas){
        return ( this.mapa.obtenerDeCapaTerrestre(coordenadas) );
    }

    public ColocableEnMapa obtenerDeCapaAerea(Coordenadas coordenadas){
        return ( this.mapa.obtenerDeCapaAerea(coordenadas) );
    }

    public ColocableEnMapa obtenerDeCapaDeRecursos(Coordenadas coordenadas){

        return ( this.mapa.obtenerDeCapaDeRecursos(coordenadas) );
    }

    // Remover ---

    public void borrarEnCapaTerrestre(Coordenadas coordenadas){

        this.mapa.borrarEnCapaTerrestre(coordenadas);

    }

    public void borrarEnCapaAerea(Coordenadas coordenadas){

        this.mapa.borrarEnCapaAerea(coordenadas);

    }

    // Mover ---

    public void mover(Coordenadas hasta, ColocableEnMapa unidad)
        throws ExcepcionNoSePudoAgregarAlMapa {

        this.validarCoordenadas(hasta);
        unidad.moverse(hasta, this.mapa);

    }

    // ---

    public boolean posicionAereaOcupada(Coordenadas coordenadas) {

        return (this.mapa.posicionAereaOcupada(coordenadas));
    }

    public boolean posicionTerrestreOcupada(Coordenadas coordenadas) {

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
