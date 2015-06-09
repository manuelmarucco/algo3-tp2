package unidades.protoss;

import excepciones.EnergiaInsuficiente;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionYaActuo;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class AltoTemplario extends UnidadMagica implements Cargable {

    public AltoTemplario(){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7,5);
    }

    public AltoTemplario(Vision visionJugador){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7,5,visionJugador);
    }

    public void tormentaPsionica(Coordenadas c, JugadorProtoss duenio) throws ExcepcionYaActuo {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        duenio.agregarTormenta(new TormentaPsionica(c));
        this.accion.actuo();
    }

    public void alucinacion(Unidad objetivo,Coordenadas destino1,Coordenadas destino2) throws ExcepcionYaActuo {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(100);
            ProxyMapa mapa = ProxyMapa.getInstance();
            // Por el proxy agrego que tiran excepciones
            mapa.agregar(objetivo.getClone(), destino1);
            mapa.agregar(objetivo.getClone(), destino2);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }
        this.accion.actuo();
    }

    public ColocableEnMapa getClone() {
        return new ClonMagico((ResistenciaProtoss)this.resistencia,this.energia,this.vision,this.ubicacion,this.movilidad);
    }

    @Override
    public int getTransporte() {
        return 2;
    }

    @Override
    public void quitarse() {

    }

    public void recibirEMP(){
        super.recibirEMP();
        this.resistencia.quitar(((ResistenciaProtoss)resistencia).getEscudoActual());
    }
    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }
}
