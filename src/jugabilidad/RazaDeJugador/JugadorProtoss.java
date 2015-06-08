package jugabilidad.RazaDeJugador;

import construcciones.protoss.*;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.TormentaPsionica;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;

public class JugadorProtoss extends Jugador {

    private ArrayList<TormentaPsionica> tormentasPsionica;

    public JugadorProtoss(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20); //suministros iniciales
        this.tormentasPsionica= new ArrayList<>();
        //HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
        //EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
    }

    public JugadorProtoss(Recursos recursosIniciales, Suministros s){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  s;
        this.tormentasPsionica= new ArrayList<>();

    }

    public Acceso construirAcceso(Coordenadas coordenadas){
        Acceso acceso = new Acceso(this);

        this.construir(acceso,coordenadas);

        return acceso;
    }

    public PortalEstelar construirPortalEstelar(Coordenadas coordenadas){
        PortalEstelar portalEstelar = new PortalEstelar(this);

        this.construir(portalEstelar,coordenadas);

        return portalEstelar;
    }

    public ArchivosTemplarios construirArchivosTemplarios(Coordenadas coordenadas){
        ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios(this);

        this.construir(archivosTemplarios,coordenadas);

        return archivosTemplarios ;
    }

    public Asimilador construirAsimilador(Coordenadas coordenadas) {
       Asimilador asimilador = new Asimilador(this.recursosRecolectados);

        this.construir(asimilador,coordenadas);

        return asimilador;
    }

    public Pilon construirPilon(Coordenadas coordenadas) {
        Pilon pilon = new Pilon(this.suministros);

        this.construir(pilon,coordenadas);

        return pilon;
    }

    public NexoMineral construirNexoMineral(Coordenadas coordenadas) {
        NexoMineral nexoMineral = new NexoMineral(recursosRecolectados);

        this.construir(nexoMineral, coordenadas);

        return nexoMineral;
    }

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
