package modelo.unidades.protoss;

import modelo.excepciones.Mapa.ExcepcionCasillaVacia;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.Unidades.ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeLaUnidad;
import modelo.excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import modelo.excepciones.Unidades.ExcepcionYaActuo;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.interfaces.Cargable;
import modelo.interfaces.Clonable;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Entrenable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.TormentaPsionica;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Energia;
import modelo.unidades.ProxyDeHechizos;
import modelo.unidades.Terrestre;
import modelo.unidades.UnidadMagica;

public class AltoTemplario extends UnidadMagica implements Cargable, Clonable {

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

    public void alucinacion(Coordenada coordenadaDeUnidadAClonar) throws ExcepcionDeAccionDeUnidad, ExcepcionCasillaVacia, ExcepcionNoSePuedeClonarEdificio {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada temp=coordenadaDeUnidadAClonar;
        ProxyMapa mapa= ProxyMapa.getInstance();
        ColocableEnMapa objetivo = mapa.obtenerDeCapaAerea(coordenadaDeUnidadAClonar);
        if(objetivo==null)
            objetivo= mapa.obtenerDeCapaTerrestre(coordenadaDeUnidadAClonar);
        if(objetivo==null) throw new ExcepcionCasillaVacia();
        Coordenada coordenadaAltoTemplario = ProxyMapa.getInstance().getCoordenada(this);
        if(coordenadaDeUnidadAClonar.distancia(coordenadaAltoTemplario)>this.vision) throw new ExcepcionObjetivoFueraDeRango();
        this.energia.gastar(75);
        this.agregarClon((Clonable) objetivo, temp);
        temp=coordenadaDeUnidadAClonar;
        this.agregarClon((Clonable)objetivo,temp);
        this.accion=this.accion.actuo();

    }

    private void agregarClon(Clonable objetivo ,Coordenada coordenadaDeUnidadAClonar) throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeClonarEdificio {
        boolean agregadoAlMapa=false;
        ProxyMapa mapa= ProxyMapa.getInstance();
        ColocableEnMapa clon = objetivo.getClon();
        Coordenada coordenadaDondeAgregarClon = new Coordenada(coordenadaDeUnidadAClonar.getX()-1,coordenadaDeUnidadAClonar.getY()-1);

        while(!agregadoAlMapa) {
            try {
                mapa.agregar(clon, coordenadaDondeAgregarClon);
                agregadoAlMapa = true;
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {
                if(!this.modicarCoordenadaAlrededorDeLaUnidad(coordenadaDondeAgregarClon,coordenadaDeUnidadAClonar)){
                    throw new ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeLaUnidad();
                }
            }
        }
        ProxyDeHechizos.obtenerDuenio(this).agregarUnidad((Entrenable)clon);
    }

    private boolean modicarCoordenadaAlrededorDeLaUnidad(Coordenada coordenadaDeClon, Coordenada coordenadaDeUnidadAClonar) {
        ProxyMapa mapa = ProxyMapa.getInstance();

        if(coordenadaDeClon.getX()<1+coordenadaDeUnidadAClonar.getX()){
            coordenadaDeClon.aumentarX(1);
        }
        else {
            coordenadaDeClon.aumentarX(-2);
            if (coordenadaDeClon.getY() < 1 + coordenadaDeUnidadAClonar.getY()) {
                coordenadaDeClon.aumentarY(1);
            } else return false;
        }

        return true;

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

    @Override
    public ColocableEnMapa getClon() throws ExcepcionNoSePuedeClonarEdificio {
        ResistenciaProtoss resistenciaProtoss = new ResistenciaProtoss(resistencia.getVidaMaxima(),((ResistenciaProtoss) resistencia).getEscudoActual());
        return new ClonMagico(resistenciaProtoss ,this.energia,this.vision,this.ubicacion,this.movilidad,this.transporte,this);
    }
}
