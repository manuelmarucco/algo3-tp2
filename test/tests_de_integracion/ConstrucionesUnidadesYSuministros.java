package tests_de_integracion;

import construcciones.protoss.Acceso;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.RazaDeJugador.JugadorTerran;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenadas;
import org.junit.Assert;
import org.junit.Test;
import unidades.protoss.Dragon;

public class ConstrucionesUnidadesYSuministros {
    @Test
    public void NoPuedoEntrenarMasUnidadesPorLlegarALLimiteDeSuministros(){
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),new Suministros(4,5));// 4 usados, 5 limite
        Acceso a = new Acceso(j);
        Dragon d;

        d = a.entrenarDragon();//+ 2 sumistro

        Assert.assertFalse(j.buscarUnidad(d));

    }

    @Test
     public void CreoVariosPilonesYAumentanLosSuministrosLimiteActuales(){
        Suministros s = new Suministros(0,0);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);

        j.construirPilon(new Coordenadas(0,0));
        j.construirPilon(new Coordenadas(0,1));
        j.construirPilon(new Coordenadas(0,2));

        Assert.assertEquals(s.getSuministrosLimiteActuales(), 15);
    }

    @Test
    public void CreoVariosDepositosDeSuministrosYAumentanLosSuministrosLimiteActuales(){
        Suministros s = new Suministros(0,0);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);

        j.construirDepositoDeSuministros(new Coordenadas(0, 0));
        j.construirDepositoDeSuministros(new Coordenadas(0, 1));
        j.construirDepositoDeSuministros(new Coordenadas(0, 2));

        Assert.assertEquals(s.getSuministrosLimiteActuales(), 15);
    }

    @Test
    public void CreoPilonesPeroNoPuedoSuperarLos200SuministrosMaximos(){
        Suministros s = new Suministros(0,191);
        JugadorProtoss j = new JugadorProtoss(new Recursos(1000,1000),s);

        j.construirPilon(new Coordenadas(3,0));
        j.construirPilon(new Coordenadas(3,1));
        j.construirPilon(new Coordenadas(3,2));

        Assert.assertEquals(s.getSuministrosLimiteActuales(), 200);
    }

    @Test
    public void CreoDepositosDeSuministrosPeroNoPuedoSuperarLos200SuministrosMaximos(){
        Suministros s = new Suministros(0,191);
        JugadorTerran j = new JugadorTerran(new Recursos(1000,1000),s);

        j.construirDepositoDeSuministros(new Coordenadas(1, 0));
        j.construirDepositoDeSuministros(new Coordenadas(1, 1));
        j.construirDepositoDeSuministros(new Coordenadas(1, 2));

        Assert.assertEquals(s.getSuministrosLimiteActuales(), 200);
    }
}
