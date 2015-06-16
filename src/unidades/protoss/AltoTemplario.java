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
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7,5,visionJugador);
    }

    public void tormentaPsionica(Coordenadas c, JugadorProtoss duenio) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        Coordenadas at= ProxyMapa.getInstance().getCoordenada(this);
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(at.distancia(c)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(75);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        duenio.agregarTormenta(new TormentaPsionica(c));
        this.accion.actuo();
    }

    public void alucinacion(Unidad objetivo,Coordenadas destino1,Coordenadas destino2) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenadas obj=ProxyMapa.getInstance().getCoordenada(objetivo);
        Coordenadas at= ProxyMapa.getInstance().getCoordenada(this);
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(obj.distancia(at)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(obj.distancia(destino1)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(obj.distancia(destino2)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
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
        return new ClonMagico((ResistenciaProtoss)this.resistencia,this.energia,this.vision,this.ubicacion,this.movilidad);
    }

    //TODO cambiar nombre del método: getTransporte deberia devolver una instancia de una clase Transporte y está devolviendo un int (2)
    @Override
    public int getTransporte() {
        return 2;
    }

    @Override
    public void quitarse() {
    //TODO ¡?
    }

    public void recibirEMP(){
        super.recibirEMP();
        //TODO ¿Porqué los casteos?
        this.resistencia.quitar(((ResistenciaProtoss)resistencia).getEscudoActual());
    }
    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }
}
