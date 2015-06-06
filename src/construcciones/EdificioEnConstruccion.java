package construcciones;

import interfaces.Construible;
import jugabilidad.utilidadesMapa.Coordenadas;

public class EdificioEnConstruccion {
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
        return construccionAConvertirse;
    }

    public Coordenadas getCoordenada() {
        return coordenadasDeConstruccion;
    }
}
