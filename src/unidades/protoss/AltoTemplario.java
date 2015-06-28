package unidades.protoss;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import interfaces.Cargable;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.Energia;
import unidades.Terrestre;
import unidades.Unidad;
import unidades.UnidadMagica;

public class AltoTemplario extends UnidadMagica implements Cargable {

    public AltoTemplario(){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7,5);
    }

    public AltoTemplario(Vision visionJugador){
        super(new ResistenciaProtoss(40, 40), new Energia(200, 50, 10), 7, new Terrestre(), 2, new Costo(50, 150), 7, 5, visionJugador, 2);
    }

    public void tormentaPsionica(Coordenada coordenada, JugadorProtoss duenio) throws ExcepcionDeAccionDeUnidad {
        Coordenada at= ProxyMapa.getInstance().getCoordenada(this);
        if(at.distancia(coordenada)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
            this.energia.gastar(75);
        duenio.agregarTormenta(new TormentaPsionica(coordenada));
        this.accion.actuo();
    }

    public void alucinacion(Unidad objetivo,Coordenada destino1,Coordenada destino2) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada coordenadaObjetivo =ProxyMapa.getInstance().getCoordenada(objetivo);
        Coordenada coordenadaAltoTemplario = ProxyMapa.getInstance().getCoordenada(this);
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(coordenadaObjetivo.distancia(coordenadaAltoTemplario)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(coordenadaObjetivo.distancia(destino1)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        if(coordenadaObjetivo.distancia(destino2)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
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
        this.resistencia.quitar(this.getEscudo());
    }
    public int getEscudo() {
        return ((ResistenciaProtoss) resistencia).getEscudoActual();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa{

        mapa.moverEnCapaTerrestre(this, hasta);

    }
}
