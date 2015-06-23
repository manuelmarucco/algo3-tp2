package vista;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenadas;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ParselaAccionable implements MouseListener {

    VentanaJugador ventana;
    Coordenadas coordenada;
    DisplayNotificaciones displayNotificaciones;

    public ParselaAccionable(VentanaJugador ventana, Coordenadas coordenada){
        this.ventana = ventana;
        this.displayNotificaciones = ventana.getDisplayNotificaciones();
        this.coordenada = coordenada;
    }

    @Override
    public void mouseClicked(MouseEvent m) {

        System.out.println("Parsela clickeada"); //Para test. ya se que funciona

        if(this.verificarConstruccionesEnEspera())
            {System.out.println("Edificio creado en el mapa");
                //TODO hay qye hacer que aparezca la imagen
                //TODO modificar el metodo construirEN() para que eso suceda
            return;
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
            } catch (ExcepcionNoSePuedeConstruir e) {
                e.printStackTrace();
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {
                e.printStackTrace();
            }
            return true;

        }else
            return  false;

    }

}
