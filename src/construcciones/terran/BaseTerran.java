package construcciones.terran;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = 500;
	}
	
	public Barraca construirBarraca(){
		Barraca barraca = new Barraca();
		return barraca;
	}
	
	public Fabrica construirFabrica(){
		Fabrica fabrica = new Fabrica();
		return fabrica;
	}
	
}
