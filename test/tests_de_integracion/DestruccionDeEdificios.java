package tests_de_integracion;

import construcciones.protoss.EdificioEnInvocacion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.terrran.Marine;

public class DestruccionDeEdificios {
    @Test
    public void SeDestruyeUnEdificioEnConstruccion() throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad, ExcepcionNoSePuedeConstruir {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20,20);

        JugadorProtoss j1 = new JugadorProtoss(new Recursos(1000,1000),new Suministros(0,20));
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(0,20));
        j1.setVisibilidad(Vision.VisionCompleta(20, 20));
        j2.setVisibilidad(Vision.VisionCompleta(20, 20));
        ProxiDeAtaque.inicializar(j1);
        ProxiDeAtaque.inicializar(j2);
        Marine m = new Marine(Vision.VisionCompleta(10, 10));
        Coordenada coordDePilon = new Coordenada(7, 6);
        EdificioEnInvocacion edifEnConst;

        proxyMapa.agregar(m, new Coordenada(7, 5));
        j2.agregarUnidad(m);

        j1.construirPilon(coordDePilon);
        edifEnConst = (EdificioEnInvocacion) proxyMapa.obtenerDeCapaTerrestre(coordDePilon);

        while(edifEnConst.getVida()!= 0){
            m.atacarTierra(edifEnConst);
            j2.update();
        }

        j1.update();

        Assert.assertFalse(proxyMapa.posicionTerrestreOcupada(coordDePilon));
    }
}
