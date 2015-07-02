package construcciones.protoss_tests;

import org.junit.Assert;
import org.junit.Test;

import modelo.construcciones.protoss.Acceso;

public class ConstruccionProtoss_Test {

	@Test
	public void DanioAlEscudoPeroNoLlegaALaVida() {
		Acceso construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		
		construccion.recibirDanio((int)(escudo/2));
		
		Assert.assertEquals(escudo-(int)(escudo/2), construccion.getEscudo());
	}
	
	@Test
	public void DanioMuchoEscudoYLlegaADaniarVida() {
		Acceso construccion = new Acceso();
		
		int escudo = construccion.getEscudo();
		int vida = construccion.getVida();
		
		construccion.recibirDanio(escudo+(int)(vida/2));
		
		Assert.assertEquals(vida-(int)(vida/2), construccion.getVida());
	}

}