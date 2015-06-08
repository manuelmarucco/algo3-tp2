package jugabilidad.RazaDeJugador;

import construcciones.terran.*;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;

public class JugadorTerran extends Jugador {

    public JugadorTerran(Recursos recursosIniciales){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  new Suministros(0,20);

        //HAY QUE HACER QUE EL JUGADOR EMPIECE CON 5 RECOLECTARES....
        //EL PROBLEMA DE ESTO ES QUE DEPENDE LA ESTRUCTURA EN CADA RAZA... HAY QUE VER COMO LO RESOLVEMOS
    }
    public JugadorTerran(Recursos recursosIniciales,Suministros s){
        this.recursosRecolectados = recursosIniciales;
        this.suministros =  s;
    }

    public Barraca construirBarraca(Coordenadas coordenadas){
        Barraca barraca = new Barraca(this);

        this.construir(barraca,coordenadas);

        return barraca;
    }

    public Fabrica construirFabrica(Coordenadas coordenadas){
        Fabrica fabrica = new Fabrica(this);

        this.construir(fabrica,coordenadas);

        return fabrica;
    }

    public PuertoEstelar construirPuertoEstelar(Coordenadas coordenadas){
        PuertoEstelar puertoEstelar = new PuertoEstelar(this);

        this.construir(puertoEstelar,coordenadas);

        return puertoEstelar;
    }

    public DepositoDeSuministros construirDepositoDeSuministros(Coordenadas coordenadas){
        DepositoDeSuministros depositoDeSuministros = new DepositoDeSuministros(this.suministros);

        this.construir(depositoDeSuministros,coordenadas);

        return depositoDeSuministros;
    }

    public CentroDeMineral construirCentroDeMineral(Coordenadas coordenadas){
        CentroDeMineral centroDeMineral = new CentroDeMineral(this.recursosRecolectados);
       /*
        Mapa mapa = SingletonMapa.getInstance();

        try{
            mapa.obtenerDeCapaTerrestre(coordenadas);
        }catch(ExcepcionNecesitaSerConstruidoSobreUnCristal e){
            e.printStackTrace();
            return centroDeMineral;
        }
        */
        this.construir(centroDeMineral,coordenadas);

        return centroDeMineral ;
    }

    public Refineria construirRefineria(Coordenadas coordenadas){
        Refineria refineria = new Refineria(this.recursosRecolectados);

        this.construir(refineria,coordenadas);

        return refineria ;
    }
}
