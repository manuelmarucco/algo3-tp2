package unidades.terrran;

import interfaces.Atacante;
import interfaces.Daniable;
import jugabilidad.auxiliares.Costo;
import unidades.Aereo;
import unidades.Danio;

public class Espectro extends UnidadTerran implements Atacante {

    private static Danio Danio= new Danio(8,20,5,5);//por si agregan las mejoras a los atributos

    public Espectro(){
        super(120);
        this.vision = 7;
        this.ubicacion = new Aereo();
        this.suministro = 2;
        this.costo=new Costo(150,100);
        this.tiempoDeEntrenamiento = 8;
    }

    @Override
    public void update() {
        //TODO ver si hace algo entre turnos;
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioAire());
    }

    public void atacar(Daniable objetivo){
        objetivo.recibirDanio(Danio);
    }

}
