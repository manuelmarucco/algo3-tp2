package jugabilidad.auxiliares;

import interfaces.Daniable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Danio;

public class TormentaPsionica {

    private int turnos;
    private Danio danio;
    private Coordenada c;

    public TormentaPsionica(Coordenada c){
        this.c = c;
        this.danio = new Danio(100,100,1,1);
        this.turnos=2;
    }
    public void update() {
        ProxyMapa mapa = ProxyMapa.getInstance();
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                Coordenada coordenada =new Coordenada(c.getX()+i, c.getY()+j);
                if(mapa.posicionAereaOcupada(coordenada)){
                    Daniable objetivo = (Daniable)mapa.obtenerDeCapaAerea(coordenada);
                    if(objetivo!=null) objetivo.recibirRadiacion(danio.getDanioAire());
                }
                if(mapa.posicionTerrestreOcupada(coordenada)) {
                    Daniable objetivo = (Daniable) mapa.obtenerDeCapaAerea(coordenada);
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
