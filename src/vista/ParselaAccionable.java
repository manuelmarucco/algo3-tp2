package vista;

import control.ObservadorDeExcepciones;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.ventanaJugadores.ObservadorRecursosSuministros;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ParselaAccionable implements MouseListener {

    VentanaJugador ventana;
    Coordenadas coordenada;
    DisplayNotificaciones displayNotificaciones;
    IVista vista;

    public ParselaAccionable(VentanaJugador ventana, Coordenadas coordenada,IVista vista){
        this.ventana = ventana;
        this.displayNotificaciones = ventana.getDisplayNotificaciones();
        this.coordenada = coordenada;
        this.vista=vista;
    }

    @Override
    public void mouseClicked(MouseEvent m) {

        System.out.println("Parsela clickeada " + coordenada.getX() + " " + coordenada.getY()); //Para test. ya se que funciona

        if(this.verificarConstruccionesEnEspera())
            {System.out.println("Edificio creado en el mapa");
                //TODO hay qye hacer que aparezca la imagen
                //TODO modificar el metodo construirEN() para que eso suceda
            return;
        }
        else {
            vista.actualizarBotonera();
            vista.actualizarPanelEstado();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private boolean verificarConstruccionesEnEspera() {
        if(ventana.getAccionConstruirEnEspera() !=  null){

            try {
                ventana.getAccionConstruirEnEspera().construirEn(coordenada);
                ObservadorRecursosSuministros.getInstance().informarCambios();
            } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
                ObservadorDeExcepciones.getInstance().informarNuevaExcepcion(e);
            }
            return true;

        }else
            return  false;

    }

}
