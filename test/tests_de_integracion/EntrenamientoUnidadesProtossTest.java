package tests_de_integracion;

import construcciones.protoss.Acceso;
import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.PortalEstelar;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.ProxyMapa;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unidades.protoss.*;

public class EntrenamientoUnidadesProtossTest {
    ProxyMapa proxyMapa;
    @Before
    public void resetearProxy(){
        ProxyMapa.resetear();

        proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(20, 20);
    }

    @Test
    public void entrenoZealotYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        Zealot z;
        int tiempo;

        a = j.construirAcceso(new Coordenada(2,2));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        z = a.entrenarZealot();
        tiempo = z.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(z));
    }

    @Test
    public void entrenoZealotYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        Zealot z;
        int tem;

        a = j.construirAcceso(new Coordenada(1, 1));
        for(int i = 0; i<12; i++) j.update();

        z = a.entrenarZealot();
        tem = z.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tem-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(z));
    }

    @Test
    public void entrenoDragonYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        Dragon d;
        int tiempo;

        a = j.construirAcceso(new Coordenada(1, 2));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        d = a.entrenarDragon();
        tiempo = d.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(d));
    }

    @Test
    public void entrenoDragonYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        Dragon d;
        int tem;

        a = j.construirAcceso(new Coordenada(2, 3));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        d = a.entrenarDragon();
        tem = d.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tem-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(d));
    }


    @Test
    public void entrenoScoutYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        Scout s;
        int	 i3;


        a = j.construirAcceso(new Coordenada(2, 4));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        pe = j.construirPortalEstelar(new Coordenada(3, 5));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        s = pe.entrenarScout();
        i3 = s.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<i3; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(s));
    }

    @Test
    public void entrenoScoutYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        Scout s;
        int	 i1,i2,i3;


        a = j.construirAcceso(new Coordenada(2, 6));
        i1 = a.getTiempoDeConstruccion();
        for(int i = 0; i<i1; i++) j.update();

        pe = j.construirPortalEstelar(new Coordenada(5, 7));
        i2 = pe.getTiempoDeConstruccion();
        for(int i = 0; i<i2; i++) j.update();

        s = pe.entrenarScout();
        i3 = s.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<i3-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(s));
    }

    @Test
    public void entrenoNaveCienciaYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        ArchivosTemplarios archivosTemplarios;
        AltoTemplario altoTemplario;
        int tiempo;

        a = j.construirAcceso(new Coordenada(1, 8));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenada(2,9));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();
        archivosTemplarios = j.construirArchivosTemplarios(new Coordenada(1, 4));
        for(int i = 0; i<archivosTemplarios.getTiempoDeConstruccion(); i++) j.update();

        altoTemplario = archivosTemplarios.entrenarAltoTemplario();
        tiempo = altoTemplario.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(altoTemplario));
    }

    @Test
    public void entrenoAltoTemplarioYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        ArchivosTemplarios archivosTemplarios;
        AltoTemplario altoTemplario;
        int tiempo;

        a = j.construirAcceso(new Coordenada(1, 1));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenada(1, 2));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();
        archivosTemplarios = j.construirArchivosTemplarios(new Coordenada(1, 3));
        for(int i = 0; i<archivosTemplarios.getTiempoDeConstruccion(); i++) j.update();

        altoTemplario = archivosTemplarios.entrenarAltoTemplario();
        tiempo = altoTemplario.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(altoTemplario));
    }

    @Test
    public void entrenoNaveTransporteYSeAgregaAlJugador() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        NaveTransporteProtoss n;
        int tiempo;

        a = j.construirAcceso(new Coordenada(1, 4));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenada(1, 5));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        n = pe.entrenarNaveTransporte();
        tiempo = n.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(n));
    }

    @Test
    public void entrenoNaveTransporteYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() throws ExcepcionNoSePuedeConstruir, ExcepcionNoSePudoAgregarAlMapa, ExcepcionNoSePuedeEntrenarUnidad {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        j.setVisibilidad(Vision.VisionCompleta(20, 20));
        Acceso a;
        PortalEstelar pe;
        NaveTransporteProtoss n;
        int tiempo;

        a = j.construirAcceso(new Coordenada(1, 6));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenada(1, 7));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        n = pe.entrenarNaveTransporte();
        tiempo = n.getTiempoDeEntrenamientoActual();
        for(int i = 0; i<tiempo-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(n));
    }
}
