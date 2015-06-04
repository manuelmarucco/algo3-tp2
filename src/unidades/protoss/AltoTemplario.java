package unidades.protoss;

import unidades.Danio;
import unidades.Energia;
import unidades.Terrestre;

public class AltoTemplario extends UnidadProtoss{

    private static Energia energia= new Energia(200,50,10);//por si agregan las mejoras a los atributos

    public AltoTemplario(){
        super(40,40);
        this.vision = 7;
        this.ubicacion = new Terrestre();
        this.suministro = 2;
    }

    @Override
    public void update() {
        this.energia.regenerar();
        this.escudo.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioTierra());
    }

    public void tormentaPsionica(){
        //TODO: implementar
    }

    public void alucinacion(){
        //TODO: implementar
    }
}
