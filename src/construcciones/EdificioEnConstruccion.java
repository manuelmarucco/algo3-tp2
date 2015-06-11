package construcciones;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class EdificioEnConstruccion implements ColocableEnMapa, Daniable {
    private Coordenadas coordenadasDeConstruccion;
    private Construible construccionAConvertirse;
    private int tiempoDeConstruccion;

    public EdificioEnConstruccion(Coordenadas coordenadas, Construible construccion){
        this.coordenadasDeConstruccion = coordenadas;
        this.construccionAConvertirse = construccion;
        this.tiempoDeConstruccion = construccion.getTiempoDeConstruccion();
    }

    public void disminuirTiempoDeConstruccion() {
        this.tiempoDeConstruccion--;
    }

    public int getTiempoDeConstruccion() {
        return tiempoDeConstruccion;
    }

    public Construible finalizarConstruccion() {
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.borrarEnCapaTerrestre(coordenadasDeConstruccion);
        return construccionAConvertirse;
    }

    public Coordenadas getCoordenada() {
        return coordenadasDeConstruccion;
    }

    @Override
    public void agregarse(Mapa mapa ,Coordenadas coordenadas) throws ExcepcionPosicionOcupada {

        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }

    @Override
    public void recibirDanio(int danio) {
        ProxyMapa mapa = ProxyMapa.getInstance();

        ((Daniable) construccionAConvertirse).recibirDanio(danio);
        if(this.getVida()==0){
            mapa.borrarEnCapaTerrestre(coordenadasDeConstruccion);
        }
    }

    public int getVida() {
        return ((Construccion)construccionAConvertirse).getVida();
    }

}
