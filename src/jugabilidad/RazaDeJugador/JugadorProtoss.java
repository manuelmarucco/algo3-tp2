package jugabilidad.RazaDeJugador;

import construcciones.protoss.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;

public class JugadorProtoss extends Jugador {

    private ArrayList<TormentaPsionica> tormentasPsionica;

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

    public Acceso construirAcceso(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Acceso acceso = new Acceso(this);

        this.construir(acceso,coordenadas);

        return acceso;
    }

    public PortalEstelar construirPortalEstelar(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        PortalEstelar portalEstelar = new PortalEstelar(this);

        this.construir(portalEstelar, coordenadas);

        return portalEstelar;
    }

    public ArchivosTemplarios construirArchivosTemplarios(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios(this);

        this.construir(archivosTemplarios, coordenadas);


        return archivosTemplarios ;
    }

    public Asimilador construirAsimilador(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
       Asimilador asimilador = new Asimilador(this.recursosRecolectados);

        this.construir(asimilador,coordenadas);

        return asimilador;
    }

    public Pilon construirPilon(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        Pilon pilon = new Pilon(this.suministros);

        this.construir(pilon,coordenadas);

        return pilon;
    }

    public NexoMineral construirNexoMineral(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        NexoMineral nexoMineral = new NexoMineral(recursosRecolectados);

        this.construir(nexoMineral, coordenadas);

        return nexoMineral;
    }

    @Override
    public void update(){
        super.update();
        for(TormentaPsionica a:tormentasPsionica){
            a.update();
            if(a.getTurnos()==0){
                tormentasPsionica.remove(a);
            }
        }
    }

    public void agregarTormenta(TormentaPsionica tormentaPsionica){
        this.tormentasPsionica.add(tormentaPsionica);
    }

}
