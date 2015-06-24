package jugabilidad.RazaDeJugador;

import construcciones.protoss.*;
import control.NotificadorDeAlertas;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.Mapa.ExcepcionPosicionOcupada;
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
        this.recursosRecolectados = new Recursos(200,0);
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

    public Acceso construirAcceso(Coordenadas coordenadas) {
        Acceso acceso = new Acceso(this);

        try {
            this.construir(acceso,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return acceso;
    }

    public PortalEstelar construirPortalEstelar(Coordenadas coordenadas){
        PortalEstelar portalEstelar = new PortalEstelar(this);

        try {
            this.construir(portalEstelar,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return portalEstelar;
    }

    public ArchivosTemplarios construirArchivosTemplarios(Coordenadas coordenadas){
        ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios(this);

        try {
            this.construir(archivosTemplarios,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return archivosTemplarios ;
    }

    public Asimilador construirAsimilador(Coordenadas coordenadas) {
       Asimilador asimilador = new Asimilador(this.recursosRecolectados);

        try {
            this.construir(asimilador,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return asimilador;
    }

    public Pilon construirPilon(Coordenadas coordenadas){
        Pilon pilon = new Pilon(this.suministros);

        try {
            this.construir(pilon,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return pilon;
    }

    public NexoMineral construirNexoMineral(Coordenadas coordenadas) {
        NexoMineral nexoMineral = new NexoMineral(recursosRecolectados);

        try {
            this.construir(nexoMineral, coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

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
