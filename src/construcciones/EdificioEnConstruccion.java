package construcciones;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
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

    public Coordenadas getCoordenadasDeConstruccion(){
        return this.coordenadasDeConstruccion;
    }

    public void disminuirTiempoDeConstruccion() {
        this.tiempoDeConstruccion--;
    }

    public int getTiempoDeConstruccion() {
        return tiempoDeConstruccion;
    }

    public Construible finalizarConstruccion() {
        Mapa mapa = SingletonMapa.getInstance();
        mapa.borrarTerrestre(coordenadasDeConstruccion);
        return construccionAConvertirse;
    }

    public Coordenadas getCoordenada() {
        return coordenadasDeConstruccion;
    }

    @Override
    public void agregarse( Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        Mapa mapa = SingletonMapa.getInstance();
        this.agregarse(mapa,coordenadas);

    }

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) throws ExcepcionPosicionOcupada {

            mapa.agregarEnCapaTerrestre(this, coordenadas);
    }
}
