package tests_de_integracion;

import construcciones.protoss.Acceso;
import construcciones.protoss.ArchivosTemplarios;
import construcciones.protoss.PortalEstelar;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import unidades.protoss.*;

public class EntrenamientoUnidadesProtossTest {
    @Test
    public void entrenoZealotYSeAgregaAlJugador() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        Zealot z;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(0,0));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        z = a.entrenarZealot();
        tiempo = z.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(z));
    }

    @Test
    public void entrenoZealotYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        Zealot z;
        int tem;

        a = j.construirAcceso(new Coordenadas(0, 1));
        for(int i = 0; i<12; i++) j.update();

        z = a.entrenarZealot();
        tem = z.getTiempoDeEntrenamiento();
        for(int i = 0; i<tem-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(z));
    }

    @Test
    public void entrenoDragonYSeAgregaAlJugador() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        Dragon d;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(0, 2));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        d = a.entrenarDragon();
        tiempo = d.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(d));
    }

    @Test
    public void entrenoDragonYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        Dragon d;
        int tem;

        a = j.construirAcceso(new Coordenadas(0, 3));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        d = a.entrenarDragon();
        tem = d.getTiempoDeEntrenamiento();
        for(int i = 0; i<tem-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(d));
    }


    @Test
    public void entrenoScoutYSeAgregaAlJugador() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        Scout s;
        int	 i3;


        a = j.construirAcceso(new Coordenadas(0, 4));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();

        pe = j.construirPortalEstelar(new Coordenadas(0, 5));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        s = pe.entrenarScout();
        i3 = s.getTiempoDeEntrenamiento();
        for(int i = 0; i<i3; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(s));
    }

    @Test
    public void entrenoScoutYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        Scout s;
        int	 i1,i2,i3;


        a = j.construirAcceso(new Coordenadas(0, 6));
        i1 = a.getTiempoDeConstruccion();
        for(int i = 0; i<i1; i++) j.update();

        pe = j.construirPortalEstelar(new Coordenadas(0, 7));
        i2 = pe.getTiempoDeConstruccion();
        for(int i = 0; i<i2; i++) j.update();

        s = pe.entrenarScout();
        i3 = s.getTiempoDeEntrenamiento();
        for(int i = 0; i<i3-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(s));
    }

    @Test
    public void entrenoNaveCienciaYSeAgregaAlJugador() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        ArchivosTemplarios archivosTemplarios;
        AltoTemplario altoTemplario;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(0, 8));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenadas(0,9));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();
        archivosTemplarios = j.construirArchivosTemplarios(new Coordenadas(1, 0));
        for(int i = 0; i<archivosTemplarios.getTiempoDeConstruccion(); i++) j.update();

        altoTemplario = archivosTemplarios.entrenarAltoTemplario();
        tiempo = altoTemplario.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(altoTemplario));
    }

    @Test
    public void entrenoAltoTemplarioYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        ArchivosTemplarios archivosTemplarios;
        AltoTemplario altoTemplario;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(1, 1));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenadas(1, 2));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();
        archivosTemplarios = j.construirArchivosTemplarios(new Coordenadas(1, 3));
        for(int i = 0; i<archivosTemplarios.getTiempoDeConstruccion(); i++) j.update();

        altoTemplario = archivosTemplarios.entrenarAltoTemplario();
        tiempo = altoTemplario.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(altoTemplario));
    }

    @Test
    public void entrenoNaveTransporteYSeAgregaAlJugador() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        NaveTransporte n;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(1, 4));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenadas(1, 5));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        n = pe.entrenarNaveTransporte();
        tiempo = n.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo; i++) j.update();

        Assert.assertTrue(j.buscarUnidad(n));
    }

    @Test
    public void entrenoNaveTransporteYLoBuscoPeroTodaviaNoTerminoElTiempoDeEntrenamiento() {
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000));
        Acceso a;
        PortalEstelar pe;
        NaveTransporte n;
        int tiempo;

        a = j.construirAcceso(new Coordenadas(1, 6));
        for(int i = 0; i<a.getTiempoDeConstruccion(); i++) j.update();
        pe = j.construirPortalEstelar(new Coordenadas(1, 7));
        for(int i = 0; i<pe.getTiempoDeConstruccion(); i++) j.update();

        n = pe.entrenarNaveTransporte();
        tiempo = n.getTiempoDeEntrenamiento();
        for(int i = 0; i<tiempo-1; i++) j.update();

        Assert.assertFalse(j.buscarUnidad(n));
    }
}
