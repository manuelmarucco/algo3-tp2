package jugabilidad.extrasJuego;

import excepciones.jugador.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import excepciones.jugador.ExcepcionNoSePudoCrearElJugador;
import excepciones.jugador.ExcepcionNombreDeJugadorMenorACuatroCaracteres;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;

import java.util.ArrayList;

public class CreadorDeJugador {

    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<String> colores = new ArrayList<>();

    // Metodos ----

    public JugadorTerran crearNuevoJugadorTerran(String nombre, String color) throws ExcepcionNoSePudoCrearElJugador {

        JugadorTerran jugador = new JugadorTerran();

        this.verificarNombre(nombre);
        this.nombres.add(nombre);

        jugador.setNombre(nombre);
        jugador.setColor(color);

        return (jugador);
    }

    public JugadorProtoss crearNuevoJugadorProtos(String nombre, String color) throws ExcepcionNoSePudoCrearElJugador {

        JugadorProtoss jugador = new JugadorProtoss();

        this.verificarNombre(nombre);
        this.verificarColor(color);

        jugador.setNombre(nombre);
        jugador.setColor(color);

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
