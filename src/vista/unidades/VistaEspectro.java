package vista.unidades;

import unidades.terrran.Espectro;
import vista.Actions.MouseActionObtenerInfoEspectro;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEspectro extends ImagePanel{
    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Espectro unidad;
    private final VentanaJugador ventanaJugador;

    public VistaEspectro(Espectro espectro,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=espectro;
        this.ventanaJugador = ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoEspectro(unidad,ventanaJugador));
    }
}