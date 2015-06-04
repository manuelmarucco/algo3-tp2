package unidades.terrran;

import excepciones.EnergiaInsuficiente;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Aereo;
import unidades.Danio;
import unidades.Energia;
import unidades.Unidad;

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
        this.Matar();
    }

    public void EMP(Coordenadas c){
        try {
            this.energia.gastar(100);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        Mapa mapa =SingletonMapa.getInstance();
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){
                Coordenadas coordenadas =new Coordenadas(c.getX()+i, c.getY()+j);
                //TODO: sacar estos casteos
                this.EMP((Unidad)mapa.getTerrestre(coordenadas));//aplicar emp
                this.EMP((Unidad)mapa.getAerea(coordenadas));//aplicar emp
            }
        }
    }

    private void EMP(Unidad d){
        d.recibirEMP();
    }

    public void Radiacion(Daniable objetivo){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        objetivo.irradiar();
    }
    public  void recibirEMP(){
        try {
            this.energia.gastar(this.energia.getEnergiaActual());
        } catch (EnergiaInsuficiente energiaInsuficiente) {}
    }
}
