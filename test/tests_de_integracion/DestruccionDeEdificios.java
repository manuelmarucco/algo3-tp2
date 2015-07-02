package tests_de_integracion;

import modelo.construcciones.protoss.EdificioEnInvocacion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.RazaDeJugador.JugadorTerran;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Test;
import modelo.unidades.ProxiDeAtaque;
import modelo.unidades.terrran.Marine;

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

        proxyMapa.agregar(m, new Coordenada(6, 5));
        j2.agregarUnidad(m);

        j1.construirPilon(coordDePilon);
        edifEnConst = (EdificioEnInvocacion) proxyMapa.obtenerDeCapaTerrestre(coordDePilon);

        while(edifEnConst.getVida()!= 0){
            m.atacar(coordDePilon);
            j2.update();
        }

        j1.update();

        Assert.assertFalse(proxyMapa.posicionTerrestreOcupada(coordDePilon));
    }
}
