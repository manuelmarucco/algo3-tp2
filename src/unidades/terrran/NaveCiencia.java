package unidades.terrran;

import excepciones.EnergiaInsuficiente;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.Danio;
import unidades.Energia;

public class NaveCiencia extends UnidadTerran{

    private  Energia energia= new Energia(200,50,10);//por si agregan las mejoras a los atributos

    public NaveCiencia(){
        super(200);
        this.vision = 10;
        this.ubicacion = new Aereo();
        this.suministro = 2;
        this.costo=new Costo(100,225);
    }

    @Override
    public void update() {
        this.energia.regenerar();
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.vida.quitar(danio.getDanioAire());
    }

    public void EMP(Coordenadas coordenadas){
        try {
            this.energia.gastar(100);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        //TODO: implementar
    }

    public void Radiacion(Coordenadas coordenadas){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        //TODO: implementar
    }
}
