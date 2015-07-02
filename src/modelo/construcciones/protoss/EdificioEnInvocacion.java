package modelo.construcciones.protoss;

import modelo.construcciones.Construccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.interfaces.Clonable;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Construible;
import modelo.interfaces.Daniable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.Clon;

public class EdificioEnInvocacion implements ColocableEnMapa, Daniable , Clonable {
    private Coordenada coordenadaDeConstruccion;
    private Construible construccionAConvertirse;
    private int tiempoDeConstruccion;

    public EdificioEnInvocacion(Coordenada coordenada, Construible construccion){
        this.coordenadaDeConstruccion = coordenada;
        this.construccionAConvertirse = construccion;
        this.tiempoDeConstruccion = construccion.getTiempoDeConstruccion();
    }

    public void disminuirTiempoDeConstruccion() {
        this.tiempoDeConstruccion--;
    }

    public int getTiempoDeConstruccionActual() {
        return tiempoDeConstruccion;
    }

    public Construible finalizarConstruccion() {
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.borrarEnCapaTerrestre(coordenadaDeConstruccion);
        return construccionAConvertirse;
    }

    public Coordenada getCoordenada() {
        return coordenadaDeConstruccion;
    }

    @Override
    public void agregarse(Mapa mapa ,Coordenada coordenada) throws ExcepcionPosicionOcupada {

        mapa.agregarEnCapaTerrestre(this, coordenada);

    }

    @Override
    public void recibirDanio(int danio) {
        ProxyMapa mapa = ProxyMapa.getInstance();

        ((Daniable) construccionAConvertirse).recibirDanio(danio);
        if(this.getVida()==0){
            mapa.borrarEnCapaTerrestre(coordenadaDeConstruccion);
        }
    }

    public int getVida() {
        return ((Construccion)construccionAConvertirse).getVida();
    }

    public int getEscudo() {
        return ((IEdificioProtoss)construccionAConvertirse).getEscudo();
    }

    public void recibirRadiacion(int danio){}

    public  void recibirEMP(){}

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

    }

    public Construccion getEdificioAConvertirse() {
        return (Construccion)construccionAConvertirse;
    }

    @Override
    public Clon getClon() throws ExcepcionNoSePuedeClonarEdificio {
        throw new ExcepcionNoSePuedeClonarEdificio();
    }

}
