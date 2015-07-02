package modelo.jugabilidad.auxiliares;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Daniable;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Danio;

import java.util.ArrayList;

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
        try {
            ArrayList<ColocableEnMapa> objetivos = mapa.obtenerUnidadesYConstruccionesEncerradasEnCircunferenciaDe(c, 1);
            for (ColocableEnMapa objetivo:objetivos){
                ((Daniable)objetivo).recibirRadiacion(danio.getDanioTierra());
            }
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }
        /*
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
        */
        this.turnos--;
    }

    public int getTurnos() {
        return turnos;
    }

    public Coordenada getCoordenadas() {
        return c;
    }
}
