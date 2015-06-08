package unidades.protoss;

import excepciones.EnergiaInsuficiente;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class AltoTemplario extends UnidadMagica implements Cargable {

    public AltoTemplario(){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7);
    }

    public void tormentaPsionica(Coordenadas c, JugadorProtoss duenio){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        duenio.agregarTormenta(new TormentaPsionica(c));
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
        this.resistencia.quitar(danio.getDanioTierra());
    }

    public void recibirEMP(){
        super.recibirEMP();
        this.resistencia.quitar(((ResistenciaProtoss)resistencia).getEscudoActual());
    }
    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }
}
