package unidades.protoss;

import excepciones.EnergiaInsuficiente;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class AltoTemplario extends UnidadMagica implements Cargable {

    private Energia energia= new Energia(200,50,10);//por si agregan las mejoras a los atributos

    public AltoTemplario(){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7);
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

    public void alucinacion(Unidad objetivo,Coordenadas destino1,Coordenadas destino2){
        try {
            this.energia.gastar(100);
            ProxyMapa mapa = ProxyMapa.getInstance();
            // Por el proxy agrego que tiran excepciones
            mapa.agregar(objetivo.getClone(), destino1);
            mapa.agregar(objetivo.getClone(), destino2);

        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
    }

    public ColocableEnMapa getClone() {
        return new ClonMagico((ResistenciaProtoss)this.resistencia,this.energia,this.vision,this.ubicacion);
    }

    @Override
    public int getTransporte() {
        return 0;
    }

    @Override
    public void quitarse() {

    }

    @Override
    public void recibirDanio(Danio danio) {

    }

    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }
}
