package jugabilidad;

import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import interfaces.Actualizable;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.extrasJuego.AdministradorDeTurnos;
import jugabilidad.extrasJuego.CreadorDeJugador;
import jugabilidad.extrasJuego.CreadorDeMapa;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.ProxiDeAtaque;
import unidades.ProxyDeHechizos;

import java.util.ArrayList;


public class Juego implements Actualizable{

    AdministradorDeTurnos administradorDeTurnos;
    CreadorDeMapa creadorDeMapa;
    ArrayList<Coordenada> bases;
    ArrayList<Jugador> jugadores;

    // Metodos

    public Juego(int cantidadDeJuegadores){

        this.administradorDeTurnos = new AdministradorDeTurnos();
        this.creadorDeMapa = new CreadorDeMapa( cantidadDeJuegadores );
        this.bases = this.creadorDeMapa.obtenerCoordenadasDeLasBases();
        this.jugadores = new ArrayList<>();

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

        this.jugadores.add(jugador);
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

        this.jugadores.add(jugador);
        return jugador;
    }

    public void inicializarProxysDeAtaqueYHechizosDeJugadores(){

        for ( Jugador jugador : this.jugadores ){
            ProxyDeHechizos.inicializar(jugador);
            ProxiDeAtaque.inicializar(jugador);
        }

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

}
