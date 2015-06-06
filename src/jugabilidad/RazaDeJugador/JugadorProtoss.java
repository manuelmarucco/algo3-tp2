package jugabilidad.RazaDeJugador;

import construcciones.protoss.*;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;

public class JugadorProtoss extends Jugador {

    public JugadorProtoss(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20); //suministros iniciales

        //HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
        //EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
    }

    public Acceso construirAcceso(){
        Acceso acceso = new Acceso();

        this.construir(acceso);

        return acceso;
    }

    public PortalEstelar construirPortalEstelar(){
        PortalEstelar portalEstelar = new PortalEstelar();

        this.construir(portalEstelar);

        return portalEstelar;
    }

    public ArchivosTemplarios construirArchivosTemplarios(){
        ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();

        this.construir(archivosTemplarios);

        return archivosTemplarios ;
    }

    public Asimilador construirAsimilador() {
       Asimilador asimilador = new Asimilador(this.recursosRecolectados);

        this.construir(asimilador);

        return asimilador;
    }

    public Pilon construirPilon() {
        Pilon pilon = new Pilon(this.suministros);

        this.construir(pilon);

        return pilon;
    }

    public NexoMineral construirNexoMineral() {
        NexoMineral nexoMineral = new NexoMineral(recursosRecolectados);

        this.construir(nexoMineral);

        return nexoMineral;
    }
}
