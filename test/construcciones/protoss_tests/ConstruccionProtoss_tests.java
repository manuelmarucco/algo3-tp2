package construcciones.protoss_tests;

import fiuba.algo3.algocraft.unidades.parametros.Danio;
import org.junit.Assert;
import org.junit.Test;

import construcciones.protoss.Acceso;
import construcciones.protoss.ConstruccionProtoss;

public class ConstruccionProtoss_tests {

	@Test
	public void DanioAlEscudoPeroNoLlegaALaVida() {
		ConstruccionProtoss construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		
		construccion.recibirDanio(new Danio((escudo/2),0,0));
		
		Assert.assertEquals(escudo- escudo/2, construccion.getEscudo());
	}
	
	@Test
	public void DanioMuchoEscudoYLlegaADaniarVida() {
		ConstruccionProtoss construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		int vida = construccion.getVida().getVidaActual();
		
		construccion.recibirDanio(new Danio(escudo+ vida/2,1,1));
		
		Assert.assertEquals(vida- vida/2, construccion.getVida().getVidaActual());
	}

}