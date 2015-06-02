package razas.protoss.construcciones_tests;

import org.junit.Assert;
import org.junit.Test;

import razas.protoss.construcciones.Acceso;
import razas.protoss.construcciones.ConstruccionProtoss;

public class ConstruccionProtoss_Test {

	@Test
	public void DanioAlEscudoPeroNoLlegaALaVida() {
		ConstruccionProtoss construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		
		construccion.recibirDanio((int)(escudo/2));
		
		Assert.assertEquals(escudo-(int)(escudo/2), construccion.getEscudo());
	}
	
	@Test
	public void DanioMuchoEscudoYLlegaADaniarVida() {
		ConstruccionProtoss construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		int vida = construccion.getVida();
		
		construccion.recibirDanio(escudo+(int)(vida/2));
		
		Assert.assertEquals(vida-(int)(vida/2), construccion.getVida());
	}

}