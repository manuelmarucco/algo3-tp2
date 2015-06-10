package tests_de_integracion;

import construcciones.EdificioEnConstruccion;
import excepciones.*;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import unidades.ProxiDeAtaque;
import unidades.terrran.Marine;

public class DestruccionDeEdificios {
    @Test
    public void SeDestruyeUnEdificioEnConstruccion() throws ExcepcionPosicionOcupada, ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo, ExcepcionAtacarAUnidadAliada, ExcepcionNoSePuedeConstruir {
        JugadorProtoss j1 = new JugadorProtoss(new Recursos(1000,1000),new Suministros(0,20));
        JugadorTerran j2 = new JugadorTerran(new Recursos(200,200),new Suministros(0,20));
        ProxiDeAtaque.inicializar(j2, j1);
        ProxyMapa mapa=ProxyMapa.getInstance();
        Marine m = new Marine(Vision.VisionCompleta(10, 10));
        Coordenadas coordDePilon = new Coordenadas(7, 6);
        EdificioEnConstruccion edifEnConst;

        mapa.agregarEnCapaTerrestre(m,new Coordenadas(7,5));
        j2.agregarUnidad(m);

        j1.construirPilon(coordDePilon);
        edifEnConst = (EdificioEnConstruccion) mapa.obtenerDeCapaTerrestre(coordDePilon);

        while(edifEnConst.getVida()!= 0){
            m.atacarTierra(edifEnConst);
            j2.update();
        }

        j1.update();

        Assert.assertFalse(mapa.posicionTerrestreOcupada(coordDePilon));
    }
}
