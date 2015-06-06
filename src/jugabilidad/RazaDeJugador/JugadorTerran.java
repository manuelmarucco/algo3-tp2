package jugabilidad.RazaDeJugador;

import construcciones.terran.*;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;

public class JugadorTerran extends Jugador {

    public JugadorTerran(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20);

        //HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
        //EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
    }

    public Barraca construirBarraca(){
        Barraca barraca = new Barraca(this);

        this.construir(barraca);

        return barraca;
    }

    public Fabrica construirFabrica(){
        Fabrica fabrica = new Fabrica(this);

        this.construir(fabrica);

        return fabrica;
    }

    public PuertoEstelar construirPuertoEstelar(){
        PuertoEstelar puertoEstelar = new PuertoEstelar();

        this.construir(puertoEstelar);

        return puertoEstelar;
    }

    public DepositoDeSuministros construirDepositoDeSuministros(){
        DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(this.suministros);

        this.construir(depositoDeSuministros);

        return depositoDeSuministros;
    }

    public CentroDeMineral construirCentroDeMineral(){
        CentroDeMineral centroDeMineral = new CentroDeMineral(this.recursosRecolectados);

        this.construir(centroDeMineral);

        return centroDeMineral ;
    }

    public Refineria construirRefineria(){
        Refineria refineria = new Refineria(this.recursosRecolectados);

        this.construir(refineria);

        return refineria ;
    }
}
