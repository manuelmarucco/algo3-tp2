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

    public Fabrica construirFabrica(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Fabrica fabrica = new Fabrica(this);

        this.construir(fabrica,coordenadas);

        return fabrica;
    }

    public PuertoEstelar construirPuertoEstelar(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        PuertoEstelar puertoEstelar = new PuertoEstelar(this);

        this.construir(puertoEstelar,coordenadas);

        return puertoEstelar;
    }

    public DepositoDeSuministros construirDepositoDeSuministros(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(this.suministros);

        this.construir(depositoDeSuministros,coordenadas);

        return depositoDeSuministros;
    }

    public CentroDeMineral construirCentroDeMineral(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        CentroDeMineral centroDeMineral = new CentroDeMineral(this.recursosRecolectados);

        this.construir(centroDeMineral,coordenadas);

        return centroDeMineral ;
    }

    public Refineria construirRefineria(Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        Refineria refineria = new Refineria(this.recursosRecolectados);

        this.construir(refineria,coordenadas);

        return refineria ;
    }
}
