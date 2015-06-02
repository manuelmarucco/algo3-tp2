package construcciones.terran_tests;

import org.junit.Assert;
import org.junit.Test;

import construcciones.terran.CentroDeMineral;
import construcciones.terran.ConstruccionTerran;

public class CentroDeMineral_tests {

	@Test
	public void VidaInicializada() {
		ConstruccionTerran r = new CentroDeMineral();
		
		Assert.assertEquals(500, r.getVida());
	}
	/* TIENE QUE SER UN TEST DE INTEGRACION. SINO TENGO QUYE HACER UN METODO PARA OBTENER LOS RECURSOS Y ESO ESTARIA MAL
	@Test
	public void RecolectaMinerales(){
		CentroDeMineral centroDeMineral = new CentroDeMineral(new Recursos(0,0));
		
		centroDeMineral.update();
		
		Assert.assertEquals(10, actual);
	}
*/

}
