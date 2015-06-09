package jugabilidad.extrasJuego;

import excepciones.ExcepcionElColorIngresadoRepiteAlDeOtroJugador;
import excepciones.ExcepcionElNombreIngresadoRepiteAlDeOtroJugador;
import excepciones.ExcepcionNoSePudoCrearElJugador;
import excepciones.ExcepcionNombreDeJugadorMenorACuatroCaracteres;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import recursos.Recurso;

import java.util.ArrayList;
import java.util.Iterator;

public class CreadorDeJugador {

    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<String> colores = new ArrayList<>();

    // Metodos ----

    public JugadorTerran crearNuevoJugadorTerran(String nombre, String color) throws ExcepcionNoSePudoCrearElJugador {

        Recursos recursos = new Recursos(0,0);
        JugadorTerran jugador = new JugadorTerran(recursos);

        this.verificarNombre(nombre);
        this.nombres.add(nombre);

        jugador.setNombre(nombre);
        jugador.setColor(color);

        return (jugador);
    }

    public JugadorProtoss crearNuevoJugadorProtos(String nombre, String color) throws ExcepcionNoSePudoCrearElJugador {

        Recursos recursos = new Recursos(0,0);
        JugadorProtoss jugador = new JugadorProtoss(recursos);

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
