package control;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class BufferImagenes {

    HashMap<String,BufferedImage> buffer;
    int ancho,alto;

    public BufferImagenes(){

        this.buffer = new HashMap<>();
        this.ancho = 64;
        this.alto = 64;

        try {

                this.cargarImagenesDeConstrucciones();
            this.cargarImagenesDeUnidades();
            this.cargarImagenesDePaisaje();

            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Image obtenerImagen( String nombreImagen ){

        return ( this.buffer.get(nombreImagen) );

    }

    private void cargarImagenesDeConstrucciones() throws IOException {

        // Terran ------------------------------------------------------------------------------------------------------
        
                        buffer.put("barraca", ImageIO.read(getClass().getResource("images/construcciones/terran/barraca.png")));
        buffer.put("CemtroDeMinerales", ImageIO.read(getClass().getResource("images/construcciones/terran/centro_de_minerales.png")));
        buffer.put("DepositoDeSuministros", ImageIO.read(getClass().getResource("images/construcciones/terran/deposito_de_suministros.png")));
        buffer.put("Fabrica", ImageIO.read(getClass().getResource("images/construcciones/terran/fabrica.png")));
        buffer.put("PuertoEstelar", ImageIO.read(getClass().getResource("images/construcciones/terran/puerto_estelar.png")));
        buffer.put("Refineria", ImageIO.read(getClass().getResource("images/construcciones/terran/refineria.png")));

        // Protoss -----------------------------------------------------------------------------------------------------
        
                        buffer.put("Acceso", ImageIO.read(getClass().getResource("images/construcciones/protoss/acceso.png")));
        buffer.put("ArchivosTemplarios", ImageIO.read(getClass().getResource("images/construcciones/protoss/archivosTemplarios.png")));
        buffer.put("Asimilador", ImageIO.read(getClass().getResource("images/construcciones/protoss/asimilador.png")));
        buffer.put("NexoMineral", ImageIO.read(getClass().getResource("images/construcciones/protoss/nexoMineral.png")));
        buffer.put("Pilon", ImageIO.read(getClass().getResource("images/construcciones/protoss/pilon.png")));
        buffer.put("PortalEstelar", ImageIO.read(getClass().getResource("images/construcciones/protoss/portalEstelar.png")));

        //new ImageIcon(buffer.get("Barraca")).getImage().getScaledInstance(this.alto, this.ancho ,Image.SCALE_FAST);
            }

    private void cargarImagenesDeUnidades() throws IOException {

        // Terran ------------------------------------------------------------------------------------------------------
        
                        buffer.put("Marine", ImageIO.read(getClass().getResource("images/unidades/terrran/marine.png")));
        buffer.put("Golliat", ImageIO.read(getClass().getResource("images/unidades/terrran/golliat.png")));
        buffer.put("Espectro", ImageIO.read(getClass().getResource("images/unidades/terrran/espectro.png")));
        buffer.put("NaveCiencia", ImageIO.read(getClass().getResource("images/unidades/terrran/naveCiencia.png")));
        buffer.put("NaveTransporteTerran", ImageIO.read(getClass().getResource("images/unidades/terrran/naveTRansporte.png")));

        // Protoss -----------------------------------------------------------------------------------------------------
        
                        buffer.put("Zealot", ImageIO.read(getClass().getResource("images/unidades/protoss/zealot.png")));
        buffer.put("Dragon", ImageIO.read(getClass().getResource("images/unidades/protoss/dragon.png")));
        buffer.put("Scout", ImageIO.read(getClass().getResource("images/unidades/protoss/scout.png")));
        buffer.put("AltoTemplario", ImageIO.read(getClass().getResource("images/unidades/protoss/altoTemplario.png")));
        buffer.put("NaveTransporteProtoss", ImageIO.read(getClass().getResource("images/unidades/protoss/naveTransporte.png")));

    }

    private void cargarImagenesDePaisaje() throws IOException {

        buffer.put("Aire", ImageIO.read(getClass().getResource("src/vista/paisaje/imagenes/aire.png")));
        buffer.put("Rocas", ImageIO.read(getClass().getResource("src/vista/paisaje/imagenes/rocas.png")));
        buffer.put("Pasto", ImageIO.read(getClass().getResource("src/vista/paisaje/imagenes/pasto.png")));

    }


}