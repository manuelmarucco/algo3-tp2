package construcciones;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class EdificioEnConstruccion implements ColocableEnMapa{
    private Coordenadas coordenadasDeConstruccion;
    private Construible construccionAConvertirse;
    private int tiempoDeConstruccion;

    public EdificioEnConstruccion(Coordenadas coordenadas, Construible construccion){
        this.coordenadasDeConstruccion = coordenadas;
        this.construccionAConvertirse = construccion;
        this.tiempoDeConstruccion = construccion.getTiempoDeConstruccion();
    }
/*
    public Coordenadas getCoordenadasDeConstruccion(){
        return this.coordenadasDeConstruccion;
    }
*/
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
    public void agregarse( Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }
}
