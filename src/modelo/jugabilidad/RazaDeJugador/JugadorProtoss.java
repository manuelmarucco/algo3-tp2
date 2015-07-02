package modelo.jugabilidad.RazaDeJugador;

import modelo.construcciones.Construccion;
import modelo.construcciones.protoss.*;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa;
import modelo.interfaces.Construible;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.auxiliares.TormentaPsionica;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public class JugadorProtoss extends Jugador {

    private ArrayList<TormentaPsionica> tormentasPsionica;
    private ArrayList<EdificioEnInvocacion> edificiosEnInvocacion =new ArrayList<>();

    public JugadorProtoss(){

        this.suministros = new Suministros(0, 5);
        this.recursosRecolectados = new Recursos(500, 500);
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
        ArrayList<TormentaPsionica> toRemove = new ArrayList<>();
        for(TormentaPsionica a:tormentasPsionica){
            a.update();
            if(a.getTurnos()==0){
                toRemove.add(a);
            }
        }
        for(TormentaPsionica a:toRemove){
            tormentasPsionica.remove(a);
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

    @Override
    public Object getPodereActivado(Coordenada coordenada) {
        for(TormentaPsionica t:tormentasPsionica){
            if(t.getCoordenadas().equals(coordenada)) return t;
        }
        return null;
    }
}
