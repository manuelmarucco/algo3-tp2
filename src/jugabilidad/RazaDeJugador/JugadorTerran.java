package jugabilidad.RazaDeJugador;

import construcciones.Construccion;
import construcciones.EdificioEnConstruccion;
import construcciones.terran.*;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import excepciones.construcciones.ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;

import java.util.ArrayList;

public class JugadorTerran extends Jugador {

    protected ArrayList<EdificioEnConstruccion> edificiosEnConstruccion = new ArrayList<>();

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


    protected void 	construir(Construible construccionCreada,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        if(! this.visibilidad.esVisible(coordenada))throw new ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa();

        construccionCreada.esConstruible(construccionesCreadas,recursosRecolectados, coordenada);

        EdificioEnConstruccion edificioEnConstruccion = new EdificioEnConstruccion(coordenada,construccionCreada);
        proxyMapa.agregar(edificioEnConstruccion, coordenada);

        recursosRecolectados.gastarRecursos(construccionCreada.getCosto());
        edificiosEnConstruccion.add(edificioEnConstruccion);
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

    @Override
    public void update() {


        for (int i = 0; i < edificiosEnConstruccion.size(); i++) {
            EdificioEnConstruccion e = edificiosEnConstruccion.get(i);
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
                edificiosEnConstruccion.remove(e);
                i--;//por q al borrar baja en 1 el size

            }
            if(e.getVida()==0){
                edificiosEnConstruccion.remove(e);
                i--;//por q al borrar baja en 1 el size
            }
        }

        super.update();

    }

    @Override
    public boolean noTieneMasConstruccionesYUnidades() {
        return ( construccionesCreadas.size() == 0 && unidadesCreadas.size() == 0 && edificiosEnConstruccion.size() == 0 );
    }

    @Override
    public Object getPodereActivado(Coordenada coordenada) {
        return null;
    }


}
