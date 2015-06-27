package construcciones;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;

public class EdificioEnConstruccion implements ColocableEnMapa, Daniable {
    private Coordenada coordenadaDeConstruccion;
    private Construible construccionAConvertirse;
    private int tiempoDeConstruccion;

    public EdificioEnConstruccion(Coordenada coordenada, Construible construccion){
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

    public void recibirRadiacion(int danio){}

    public  void recibirEMP(){}

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

    }

    public Construccion getEdificioAConvertirse() {
        return (Construccion)construccionAConvertirse;
    }
}
