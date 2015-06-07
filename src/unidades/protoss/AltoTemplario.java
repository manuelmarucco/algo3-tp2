package unidades.protoss;

import excepciones.EnergiaInsuficiente;
import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Energia;
import unidades.Terrestre;

public class AltoTemplario extends UnidadProtoss implements Cargable {

    private Energia energia= new Energia(200,50,10);//por si agregan las mejoras a los atributos

    public AltoTemplario(){
        super(40,40);
        this.vision = 7;
        this.ubicacion = new Terrestre();
        this.suministro = 2;
        this.costo=new Costo(50,150);
        this.tiempoDeEntrenamiento = 7;
    }

    @Override
    public void update() {
        super.update();
        this.energia.regenerar();
        this.escudo.regenerar();
    }

    public void tormentaPsionica(Coordenadas c){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        ProxyMapa mapa = ProxyMapa.getInstance();
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){
                Coordenadas coordenadas =new Coordenadas(c.getX()+i, c.getY()+j);
                mapa.obtenerDeCapaTerrestre(coordenadas);//aplicar tormenta
                mapa.obtenerDeCapaAerea(coordenadas);//aplicar tormenta
            }
        }
        //TODO: implementar
    }

    public void alucinacion(UnidadProtoss objetivo,Coordenadas destino1,Coordenadas destino2){
        try {
            this.energia.gastar(100);
            ProxyMapa mapa = ProxyMapa.getInstance();
            // Por el proxy agrego que tiran excepciones
            try {
                mapa.agregar(objetivo.getClone(), destino1);
            } catch (ExcepcionCoordenadaXIngresadaFueraDelMapa | ExcepcionCoordenadaYIngresadaFueraDelMapa e) {
                e.printStackTrace();
            }
            try {
                mapa.agregar(objetivo.getClone(), destino2);
            } catch (ExcepcionCoordenadaXIngresadaFueraDelMapa | ExcepcionCoordenadaYIngresadaFueraDelMapa e) {
                e.printStackTrace();
            }
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
    }

    @Override
    public ColocableEnMapa getClone() {
        return new ClonMagico(this.vida,this.energia,this.escudo,this.vision,this.ubicacion);
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }

    public  void recibirEMP(){
        super.recibirEMP();
        try {
            this.energia.gastar(this.energia.getEnergiaActual());
        } catch (EnergiaInsuficiente e) {
            e.printStackTrace();
        }
    }

    public Energia getEnergia() {
        return energia;
    }
}
