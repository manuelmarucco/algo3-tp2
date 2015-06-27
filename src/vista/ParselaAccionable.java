package vista;

import control.ObservadorDeExcepciones;
import control.vistaMapa.ObservadorMapa;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.utilidadesMapa.Coordenada;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import unidades.ProxyDeHechizos;
import vista.auxiliares.jugador.DisplayNotificaciones;
import vista.ventanaJugadores.ObservadorRecursosSuministros;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ParselaAccionable implements MouseListener {

    VentanaJugador ventana;
    Coordenada coordenada;
    DisplayNotificaciones displayNotificaciones;
    IVista vista;

    public ParselaAccionable(VentanaJugador ventana, Coordenada coordenada,IVista vista){
        this.ventana = ventana;
        this.displayNotificaciones = ventana.getDisplayNotificaciones();
        this.coordenada = coordenada;
        this.vista=vista;
    }

    @Override
    public void mouseClicked(MouseEvent m) {

        System.out.println("Parsela clickeada " + coordenada.getX() + " " + coordenada.getY()); //Para test. ya se que funciona


        if (m.getButton() == MouseEvent.BUTTON3) {

            if(this.verificarConstruccionesEnEspera()) {
                System.out.println("Edificio creado en el mapa");
                ObservadorRecursosSuministros.getInstance().informarCambios();
                ObservadorMapa.getInstance().informarCambios();
            }

            if(this.verificarAccionEnEspera()){
                System.out.println("Accion de la unidad realizada");
                ObservadorRecursosSuministros.getInstance().informarCambios();
                ObservadorMapa.getInstance().informarCambios();
            }

        }

        if(m.getButton() == MouseEvent.BUTTON1){
            ColocableEnMapa seleccionado = ProxyMapa.getInstance().obtenerDeCapaAerea(coordenada);
            if(seleccionado==null)
                seleccionado=ProxyMapa.getInstance().obtenerDeCapaTerrestre(coordenada);
            if(this.ventana.obtenerJugador()== ProxyDeHechizos.obtenerDuenio(seleccionado)) {
                vista.actualizarBotonera();
            }
            else{
                this.ventana.getPanelAcciones().limpiar();
            }
            ventana.borrarPanelDeEstadoAnterior(); // el tema es que caundo tocas el pasto no se activa la VistaPasto entonces hay q borrar manualmente
            vista.actualizarPanelEstado();
        }

    }

    private boolean verificarAccionEnEspera() {
        if(ventana.getAccionActuarEnEspera() !=  null){
            try {
                ventana.getAccionActuarEnEspera().actuarEn(coordenada);
                return true;
            } catch (Throwable e) {
                System.out.println("no funciono"); //TODO ver el manejo de las excepciones. no podes agarrar un Throwable.
                ObservadorDeExcepciones.getInstance().informarNuevaExcepcion(e);
                return  false;
            }

        }else
            return  false;

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
                return true;
            } catch (ExcepcionNoSePuedeConstruir | ExcepcionNoSePudoAgregarAlMapa e) {
                ObservadorDeExcepciones.getInstance().informarNuevaExcepcion(e);
                return  false;
            }

        }else
            return  false;

    }

}
