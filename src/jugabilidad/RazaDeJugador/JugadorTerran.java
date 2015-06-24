package jugabilidad.RazaDeJugador;

import construcciones.terran.*;
import control.NotificadorDeAlertas;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;

public class JugadorTerran extends Jugador {

    public JugadorTerran(){       //Constructor para el Juego
        this.suministros = new Suministros(0,0);
        this.recursosRecolectados = new Recursos(200,0);
        this.visibilidad = new Vision();
    }

    public JugadorTerran(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20);
        this.visibilidad = new Vision();
    }
    public JugadorTerran(Recursos recursosIniciales,Suministros s){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  s;
        this.visibilidad = new Vision();
    }

    public Barraca construirBarraca(Coordenadas coordenadas) {
        Barraca barraca = new Barraca(this);

        try {
            this.construir(barraca,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return barraca;
    }

    public Fabrica construirFabrica(Coordenadas coordenadas) {
        Fabrica fabrica = new Fabrica(this);

        try {
            this.construir(fabrica,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return fabrica;
    }

    public PuertoEstelar construirPuertoEstelar(Coordenadas coordenadas){
        PuertoEstelar puertoEstelar = new PuertoEstelar(this);

        try {
            this.construir(puertoEstelar,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return puertoEstelar;
    }

    public DepositoDeSuministros construirDepositoDeSuministros(Coordenadas coordenadas){
        DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(this.suministros);

        try {
            this.construir(depositoDeSuministros,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return depositoDeSuministros;
    }

    public CentroDeMineral construirCentroDeMineral(Coordenadas coordenadas){
        CentroDeMineral centroDeMineral = new CentroDeMineral(this.recursosRecolectados);

        try {
            this.construir(centroDeMineral,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return centroDeMineral ;
    }

    public Refineria construirRefineria(Coordenadas coordenadas){
        Refineria refineria = new Refineria(this.recursosRecolectados);

        try {
            this.construir(refineria,coordenadas);
        } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
            NotificadorDeAlertas.getInstance().informarNuevaExcepcion(e);
        }

        return refineria ;
    }
}
