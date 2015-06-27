package jugabilidad.RazaDeJugador;

import construcciones.terran.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;

public class JugadorTerran extends Jugador {

    public JugadorTerran(){       //Constructor para el Juego
        this.suministros = new Suministros(0,5);
        //this.recursosRecolectados = new Recursos(200,0);
        this.recursosRecolectados = new Recursos(500,500); //TODO es para facilitar el comienzo del juego. ponerlo como supuesto
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

    public Barraca construirBarraca(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        Barraca barraca = new Barraca(this);

        this.construir(barraca, coordenada);

        return barraca;
    }

    public Fabrica construirFabrica(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        Fabrica fabrica = new Fabrica(this);

        this.construir(fabrica, coordenada);

        return fabrica;
    }

    public PuertoEstelar construirPuertoEstelar(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        PuertoEstelar puertoEstelar = new PuertoEstelar(this);

        this.construir(puertoEstelar, coordenada);

        return puertoEstelar;
    }

    public DepositoDeSuministros construirDepositoDeSuministros(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(this.suministros);

        this.construir(depositoDeSuministros, coordenada);

        return depositoDeSuministros;
    }

    public CentroDeMineral construirCentroDeMineral(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        CentroDeMineral centroDeMineral = new CentroDeMineral(this.recursosRecolectados);

        this.construir(centroDeMineral, coordenada);

        return centroDeMineral ;
    }

    public Refineria construirRefineria(Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa{
        Refineria refineria = new Refineria(this.recursosRecolectados);

        this.construir(refineria, coordenada);

        return refineria ;
    }
}
