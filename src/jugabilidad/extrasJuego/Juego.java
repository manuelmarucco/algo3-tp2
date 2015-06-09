package jugabilidad.extrasJuego;

import interfaces.Actualizable;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;


public class Juego implements Actualizable{
    AdministradorDeTurnos administradorDeTurnos;
    ProxyMapa mapa;

    public Actualizable getJugador(){
       return administradorDeTurnos.getJugadorDelTurnoActual();
    }

    public void crearJugadorProtoss(String nombre, String color){
        JugadorProtoss j = new JugadorProtoss(nombre,color);
         administradorDeTurnos.agregarJugador((Actualizable)j);
    }

    @Override
    public void update() {
        administradorDeTurnos.update();
    }
}
