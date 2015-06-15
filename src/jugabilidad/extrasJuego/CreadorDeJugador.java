package jugabilidad.extrasJuego;

import excepciones.jugador.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import excepciones.jugador.ExcepcionNombreDeJugadorMenorACuatroCaracteres;
import jugabilidad.Jugador;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.ArrayList;

public class CreadorDeJugador {

    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<String> colores = new ArrayList<>();

    // Metodos ----

    public JugadorTerran crearNuevoJugadorTerran(String nombre, String color, Coordenadas coordenadasIniciales)
            throws ExcepcionNoSePudoCrearElJugador {
        this.verificarNombre(nombre);
        this.nombres.add(nombre);

        JugadorTerran jugador = new JugadorTerran();

        jugador.setNombre(nombre);
        jugador.setColor(color);

        this.colocarVisibilidadEn(jugador, coordenadasIniciales);

        return (jugador);
    }

    public JugadorProtoss crearNuevoJugadorProtos(String nombre, String color, Coordenadas coordenadasIniciales)
            throws ExcepcionNoSePudoCrearElJugador {

        this.verificarNombre(nombre);
        this.verificarColor(color);

        JugadorProtoss jugador = new JugadorProtoss();

        jugador.setNombre(nombre);
        jugador.setColor(color);

        this.colocarVisibilidadEn(jugador, coordenadasIniciales);

        return (jugador);
    }

    // Verificadores usados por los creadores --

    private void verificarNombre(String nombre) throws ExcepcionNoSePudoCrearElJugador {

       if ( this.longitudDeNombreIncorrecta(nombre) )
            throw new ExcepcionNombreDeJugadorMenorACuatroCaracteres();

        if ( this.elNombreSeRepiteEnAlgunoDeLosOtrosJugadores(nombre) )
            throw new ExcepcionElNombreIngresadoRepiteAlDeOtroJugador();

        this.nombres.add(nombre);

    }

    private void verificarColor(String color) throws ExcepcionNoSePudoCrearElJugador{

        if ( this.elColorSeRepiteEnAlgunoDeLosOtrosJugadores(color) )
            throw new ExcepcionElColorIngresadoRepiteAlDeOtroJugador();

        this.colores.add(color);

    }

    private void colocarVisibilidadEn(Jugador jugador, Coordenadas coordenadasIniciales){

        Vision visibilidad = new Vision();
        int radioDeVisibilidadInicial = 2;
        visibilidad.agregarSectorVisible(coordenadasIniciales,radioDeVisibilidadInicial);

        jugador.setVisibilidad(visibilidad);

    }

    // Verificadores usados indirectamente ----

    private boolean longitudDeNombreIncorrecta(String nombre){

        return ( nombre.length() < 4 );

    }

    private boolean elNombreSeRepiteEnAlgunoDeLosOtrosJugadores(String nombre) {

        Boolean seRepiteElNombre = false;

        for (String nombreActual : this.nombres) {

            if (nombreActual.equals(nombre)) seRepiteElNombre = true;

        }
        return seRepiteElNombre;

    }

    private boolean elColorSeRepiteEnAlgunoDeLosOtrosJugadores(String color) {

        Boolean seRepiteElColor = false;

        for (String colorActual : this.colores) {

            if (colorActual.equals(color)) seRepiteElColor = true;

        }
        return seRepiteElColor;

    }

}
