package control;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class BufferImagenes {

    private static HashMap<String,ImageIcon> buffer;

    public BufferImagenes(){

        buffer = new HashMap<>();

        try {

            this.cargarImagenesDeConstrucciones();
            this.cargarImagenesDeUnidades();
            this.cargarImagenesDePaisaje();

            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ImageIcon obtenerImagen( String nombreImagen ){

        return ( buffer.get(nombreImagen) );

    }

    private void cargarImagenesDeConstrucciones() throws IOException {

        // Terran ------------------------------------------------------------------------------------------------------
        
        buffer.put("Barraca", new ImageIcon("images/construcciones/terran/barraca.png"));
        buffer.put("CemtroDeMinerales", new ImageIcon("images/construcciones/terran/centro_de_minerales.png"));
        buffer.put("DepositoDeSuministros", new ImageIcon("images/construcciones/terran/deposito_de_suministros.png"));
        buffer.put("Fabrica", new ImageIcon("images/construcciones/terran/fabrica.png"));
        buffer.put("PuertoEstelar", new ImageIcon("images/construcciones/terran/puerto_estelar.png"));
        buffer.put("Refineria", new ImageIcon("images/construcciones/terran/refineria.png"));

        // Protoss -----------------------------------------------------------------------------------------------------
        
        buffer.put("Acceso", new ImageIcon("images/construcciones/protoss/acceso.png"));
        buffer.put("ArchivosTemplarios", new ImageIcon("images/construcciones/protoss/archivosTemplarios.png"));
        buffer.put("Asimilador", new ImageIcon("images/construcciones/protoss/asimilador.png"));
        buffer.put("NexoMineral", new ImageIcon("images/construcciones/protoss/nexoMineral.png"));
        buffer.put("Pilon", new ImageIcon("images/construcciones/protoss/pilon.png"));
        buffer.put("PortalEstelar", new ImageIcon("images/construcciones/protoss/portalEstelar.png"));

    }

    private void cargarImagenesDeUnidades() throws IOException {

        // Terran ------------------------------------------------------------------------------------------------------
        
        buffer.put("Marine", new ImageIcon("images/unidades/terrran/marine.png"));
        buffer.put("Golliat", new ImageIcon("images/unidades/terrran/golliat.png"));
        buffer.put("Espectro", new ImageIcon("images/unidades/terrran/espectro.png"));
        buffer.put("NaveCiencia", new ImageIcon("images/unidades/terrran/naveCiencia.png"));
        buffer.put("NaveTransporteTerran", new ImageIcon("images/unidades/terrran/naveTRansporte.png"));

        // Protoss -----------------------------------------------------------------------------------------------------
        
        buffer.put("Zealot", new ImageIcon("images/unidades/protoss/zealot.png"));
        buffer.put("Dragon", new ImageIcon("images/unidades/protoss/dragon.png"));
        buffer.put("Scout", new ImageIcon("images/unidades/protoss/scout.png"));
        buffer.put("AltoTemplario", new ImageIcon("images/unidades/protoss/altoTemplario.png"));
        buffer.put("NaveTransporteProtoss", new ImageIcon("images/unidades/protoss/naveTransporte.png"));

    }

    private void cargarImagenesDePaisaje() throws IOException {

        buffer.put("Aire", new ImageIcon("src/vista/paisaje/imagenes/aire.png"));
        buffer.put("Rocas", new ImageIcon("src/vista/paisaje/imagenes/rocas.png"));
        buffer.put("Pasto", new ImageIcon("src/vista/paisaje/imagenes/pasto.png"));

    }


}