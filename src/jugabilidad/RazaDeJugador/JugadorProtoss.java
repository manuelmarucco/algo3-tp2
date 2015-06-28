package jugabilidad.RazaDeJugador;

import construcciones.Construccion;
import construcciones.protoss.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import excepciones.construcciones.ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public class JugadorProtoss extends Jugador {

    private ArrayList<TormentaPsionica> tormentasPsionica;
    private ArrayList<EdificioEnInvocacion> edificiosEnInvocacion =new ArrayList<>();

    public JugadorProtoss(){       //Constructor para el Juego
        this.suministros = new Suministros(0,0);
       // this.recursosRecolectados = new Recursos(200,0);
        this.recursosRecolectados = new Recursos(500,0); //TODO es para facilitar el comienzo del juego. ponerlo como supuesto
        this.tormentasPsionica= new ArrayList<>();
        this.visibilidad = new Vision();
    }

    public JugadorProtoss(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20); //suministros iniciales
        this.tormentasPsionica= new ArrayList<>();
        this.visibilidad = new Vision();
    }

    public JugadorProtoss(Recursos recursosIniciales, Suministros s){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  s;
        this.tormentasPsionica= new ArrayList<>();
        this.visibilidad = new Vision();

    }

    protected void 	construir(Construible construccionCreada,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        if(! this.visibilidad.esVisible(coordenada))throw new ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa();

        construccionCreada.esConstruible(construccionesCreadas,recursosRecolectados, coordenada);

        EdificioEnInvocacion edificioEnInvocacion = new EdificioEnInvocacion(coordenada,construccionCreada);
        proxyMapa.agregar(edificioEnInvocacion, coordenada);

        recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
        edificiosEnInvocacion.add(edificioEnInvocacion);
    }

    public Acceso construirAcceso(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Acceso acceso = new Acceso(this);

        this.construir(acceso, coordenada);

        return acceso;
    }

    public PortalEstelar construirPortalEstelar(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        PortalEstelar portalEstelar = new PortalEstelar(this);

        this.construir(portalEstelar, coordenada);

        return portalEstelar;
    }

    public ArchivosTemplarios construirArchivosTemplarios(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios(this);

        this.construir(archivosTemplarios, coordenada);


        return archivosTemplarios ;
    }

    public Asimilador construirAsimilador(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
       Asimilador asimilador = new Asimilador(this.recursosRecolectados);

        this.construir(asimilador, coordenada);

        return asimilador;
    }

    public Pilon construirPilon(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        Pilon pilon = new Pilon(this.suministros);

        this.construir(pilon, coordenada);

        return pilon;
    }

    public NexoMineral construirNexoMineral(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        NexoMineral nexoMineral = new NexoMineral(recursosRecolectados);

        this.construir(nexoMineral, coordenada);

        return nexoMineral;
    }

    @Override
    public void update(){

        for(TormentaPsionica a:tormentasPsionica){
            a.update();
            if(a.getTurnos()==0){
                tormentasPsionica.remove(a);
            }
        }
        for (int i = 0; i < edificiosEnInvocacion.size(); i++) {
            EdificioEnInvocacion e = edificiosEnInvocacion.get(i);
            e.disminuirTiempoDeConstruccion();

            if (e.getTiempoDeConstruccionActual() == 0) {

                Construible t = e.finalizarConstruccion();
                construccionesCreadas.add(t);

                Coordenada coordenada = e.getCoordenada();
                ProxyMapa proxyMapa = ProxyMapa.getInstance();

                try {
                    proxyMapa.agregar((Construccion) t, coordenada);
                } catch (ExcepcionNoSePudoAgregarAlMapa excepcionNoSePudoAgregarAlMapa) {
                    excepcionNoSePudoAgregarAlMapa.printStackTrace();
                }

                //para evitar casteo hacer que Construible herede de Actualizable
                edificiosEnInvocacion.remove(e);
                i--;//por q al borrar baja en 1 el size

            }
            if(e.getVida()==0){
                edificiosEnInvocacion.remove(e);
                i--;//por q al borrar baja en 1 el size
            }
        }

        super.update();

    }

    public void agregarTormenta(TormentaPsionica tormentaPsionica){
        this.tormentasPsionica.add(tormentaPsionica);
    }

    @Override
    public boolean noTieneMasConstruccionesYUnidades() {
        return ( construccionesCreadas.size() == 0 && unidadesCreadas.size() == 0 && edificiosEnInvocacion.size() == 0 );
    }
}
