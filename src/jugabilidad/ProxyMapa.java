package jugabilidad;

import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionPosicionOcupada;
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

    public void agregar(ColocableEnMapa colocable, Coordenadas coordenadas) {

        try {
            validarCoordenadas(coordenadas);
        } catch (ExcepcionCoordenadaXIngresadaFueraDelMapa e1) {
            e1.printStackTrace();
        } catch (ExcepcionCoordenadaYIngresadaFueraDelMapa e2) {
            e2.printStackTrace();
        }

        try {
            colocable.agregarse(coordenadas);
        } catch (ExcepcionNoSePudoAgregarAlMapa e) {
            e.printStackTrace();
        }

    }

    // Metodos de Mapa ----

    public void agregarEnCapaTerrestre(ColocableEnMapa colocable, Coordenadas coordenadas)
            throws ExcepcionPosicionOcupada{
        this.mapa.agregarEnCapaTerrestre(colocable, coordenadas);
    }

    public void agregarEnCapaAerea(ColocableEnMapa colocable, Coordenadas coordenadas)
            throws ExcepcionPosicionOcupada{
        this.mapa.agregarEnCapaAerea(colocable,coordenadas);
    }

    public void agregarEnCapaDeRecursos(ColocableEnMapa colocable, Coordenadas coordenadas){
        this.mapa.agregarEnCapaDeRecursos(colocable, coordenadas);
    }

    // Obtener ---

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
