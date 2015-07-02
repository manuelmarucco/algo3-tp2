package modelo.jugabilidad;

import modelo.excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import modelo.interfaces.Actualizable;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.extrasJuego.AdministradorDeTurnos;
import modelo.jugabilidad.extrasJuego.CreadorDeJugador;
import modelo.jugabilidad.extrasJuego.CreadorDeMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.ProxiDeAtaque;
import modelo.unidades.ProxyDeHechizos;

import java.util.ArrayList;


public class Juego implements Actualizable{

    AdministradorDeTurnos administradorDeTurnos;
    CreadorDeMapa creadorDeMapa;
    ArrayList<Coordenada> bases;

    // Metodos

    public Juego(int cantidadDeJuegadores){

        this.administradorDeTurnos = new AdministradorDeTurnos();
        this.creadorDeMapa = new CreadorDeMapa( cantidadDeJuegadores );
        this.bases = this.creadorDeMapa.obtenerCoordenadasDeLasBases();

    }

    public Jugador getJugadorActual(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }

    public JugadorProtoss crearJugadorProtoss(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorProtoss jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorProtos(nombre,color,this.bases.get(0));
            this.eliminarBaseUsada();
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);

        this.inicializarProxysDeAtaqueYHechizosDeJugadores(jugador);
        return jugador;
    }

    public JugadorTerran crearJugadorTerran(String nombre, String color){

        CreadorDeJugador creadorDeJugador = new CreadorDeJugador();
        JugadorTerran jugador;

        try {
            jugador = creadorDeJugador.crearNuevoJugadorTerran(nombre, color, this.bases.get(0));
            this.eliminarBaseUsada();
        } catch (ExcepcionNoSePudoCrearElJugador e) {
            e.printStackTrace();
            return null;
        }

        administradorDeTurnos.agregarJugador(jugador);

        this.inicializarProxysDeAtaqueYHechizosDeJugadores(jugador);
        return jugador;
    }

    private void inicializarProxysDeAtaqueYHechizosDeJugadores(Jugador jugador){

        ProxyDeHechizos.inicializar(jugador);
        ProxiDeAtaque.inicializar(jugador);

    }

    @Override
    public void update() {
        administradorDeTurnos.update();

    }

    public Jugador getJugadorGanador(){
        if(administradorDeTurnos.hayGanador()){
            return administradorDeTurnos.getGanador();
        }else
            return null;
    }

    private void eliminarBaseUsada(){

        bases.remove(0);

    }

    public void reiniciar(int cantidadDeJuegadores) {
        ProxyMapa.resetear();
        this.administradorDeTurnos = new AdministradorDeTurnos();
        this.creadorDeMapa = new CreadorDeMapa( cantidadDeJuegadores );
        this.bases = this.creadorDeMapa.obtenerCoordenadasDeLasBases();
    }
}
