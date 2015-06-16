package jugabilidad.auxiliares;

import interfaces.Daniable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Danio;

public class TormentaPsionica {

    private int turnos;
    private Danio danio;
    private Coordenadas c;

    public TormentaPsionica(Coordenadas c){
        this.c = c;
        this.danio = new Danio(100,100,1,1);
        this.turnos=2;
    }
    public void update() {
        ProxyMapa mapa = ProxyMapa.getInstance();
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                Coordenadas coordenadas =new Coordenadas(c.getX()+i, c.getY()+j);
                if(mapa.posicionAereaOcupada(coordenadas)){
                    Daniable objetivo = (Daniable)mapa.obtenerDeCapaAerea(coordenadas);
                    if(objetivo!=null) objetivo.recibirRadiacion(danio.getDanioAire());
                }
                if(mapa.posicionTerrestreOcupada(coordenadas)) {
                    Daniable objetivo = (Daniable) mapa.obtenerDeCapaAerea(coordenadas);
                    if (objetivo!=null) objetivo.recibirRadiacion(danio.getDanioTierra());
                }
            }
        }
        this.turnos--;
    }

    public int getTurnos() {
        return turnos;
    }
}
