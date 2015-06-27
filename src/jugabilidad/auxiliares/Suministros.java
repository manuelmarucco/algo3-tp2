package jugabilidad.auxiliares;

import excepciones.construcciones.ExcepcionSuministrosInsuficientes;

public class Suministros {
	private final int suministrosMaximos;
	private int suministrosLimiteActuales;
	private int suministrosUsados;
	
	public Suministros(int usados, int limiteActuales){
		this.suministrosMaximos = 200;
		this.suministrosLimiteActuales = limiteActuales;
		this.suministrosUsados = usados;
	}
	public Suministros(){
		this.suministrosMaximos = 200;
		this.suministrosLimiteActuales = 0;
		this.suministrosUsados = 0;
	}
	
	public void usarSuministros(int suministrosDeUnidad) throws ExcepcionSuministrosInsuficientes {
			if(suministrosLimiteActuales < suministrosUsados + suministrosDeUnidad){
				throw new ExcepcionSuministrosInsuficientes();
			}else
				suministrosUsados += suministrosDeUnidad;
			
		}
	
	public void aumentarSuministrosLimiteActuales(int aumento){
		suministrosLimiteActuales = Math.min(suministrosLimiteActuales + aumento, suministrosMaximos);
	}

	public int getSuministrosLimiteActuales() {
		return suministrosLimiteActuales;
	}

	public int getSuministrosUsados(){
		return (this.suministrosUsados);
	}

	public void disminuirSuministrosLimiteActuales(int disminucion) {
		suministrosLimiteActuales = Math.max(suministrosLimiteActuales - disminucion, 0);

	}

	public void disminuirSuministrosUsados(int disminucion) {
		suministrosUsados = Math.max(suministrosUsados - disminucion, 0);

	}
}

