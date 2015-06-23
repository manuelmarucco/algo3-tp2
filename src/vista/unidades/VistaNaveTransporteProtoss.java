package vista.unidades;

import unidades.protoss.NaveTransporteProtoss;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaNaveTransporteProtoss extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final NaveTransporteProtoss unidad;
    private final VentanaJugador ventanaJugador;
    private static final String imagePath="";

    public VistaNaveTransporteProtoss(NaveTransporteProtoss nave,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage());
        this.unidad=nave;
        this.ventanaJugador=ventanaJugador;
    }

  }
