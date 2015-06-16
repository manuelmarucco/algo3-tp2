package unidades.protoss;

import excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
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
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7, 5, visionJugador, 2);
    }

    public void tormentaPsionica(Coordenadas coordenadas, JugadorProtoss duenio) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        Coordenadas at= ProxyMapa.getInstance().getCoordenada(this);
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(at.distancia(coordenadas)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(75);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        duenio.agregarTormenta(new TormentaPsionica(coordenadas));
        this.accion.actuo();
    }

    public void alucinacion(Unidad objetivo,Coordenadas destino1,Coordenadas destino2) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenadas coordenadasObjetivo=ProxyMapa.getInstance().getCoordenada(objetivo);
        Coordenadas coordenadasAltoTemplario= ProxyMapa.getInstance().getCoordenada(this);
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(coordenadasObjetivo.distancia(coordenadasAltoTemplario)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(coordenadasObjetivo.distancia(destino1)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(coordenadasObjetivo.distancia(destino2)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        try {
            this.energia.gastar(100);
            // Por el proxy agrego que tiran excepciones
            mapa.agregar(objetivo.getClone(), destino1);
            mapa.agregar(objetivo.getClone(), destino2);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
            excepcionNoSePudoAgregarAlMapa.printStackTrace();
        }
        this.accion.actuo();
    }

    public ColocableEnMapa getClone() {
        return new ClonMagico((ResistenciaProtoss)this.resistencia,this.energia,this.vision,this.ubicacion,this.movilidad,this.transporte);
    }

    public void recibirEMP(){
        super.recibirEMP();
        //TODO ¿Porqué los casteos?
        this.resistencia.quitar(this.getEscudo());
    }
    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }
}
