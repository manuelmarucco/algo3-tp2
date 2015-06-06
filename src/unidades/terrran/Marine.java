package unidades.terrran;

import excepciones.ExcepcionObjetivoFueraDeRango;
import interfaces.Atacante;
import interfaces.Cargable;
import interfaces.Daniable;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Danio;
import unidades.Terrestre;

public class Marine extends UnidadTerran implements Atacante, Cargable {

    private static Danio Danio= new Danio(6,6,4,4);//por si agregan las mejoras a los atributos

    public Marine(){
        super(40);
        this.vision = 7;
        this.ubicacion = new Terrestre();
        this.suministro = 1;
        this.costo=new Costo(50,0);
        this.tiempoDeEntrenamiento = 3;
    }

    @Override
    public void update() {
        //TODO ver si hace algo entre turnos;
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioTierra());
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(Danio);
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }

    public void atacarTierra(Coordenadas origen, Coordenadas destino) throws ExcepcionObjetivoFueraDeRango {
        if(origen.distacina(destino) < Marine.Danio.getRangoTerrestre()){
            this.atacar((Daniable)SingletonMapa.getInstance().obtenerDeCapaTerrestre(destino));
        }
        else throw new ExcepcionObjetivoFueraDeRango();
    }

    public void atacarAire(Coordenadas origen, Coordenadas destino) throws ExcepcionObjetivoFueraDeRango {
        if(origen.distacina(destino)<Danio.getRangoAereo()){
            this.atacar((Daniable)SingletonMapa.getInstance().obtenerDeCapaAerea(destino));
        }
        else throw new ExcepcionObjetivoFueraDeRango();
    }
}
