package jugabilidad.auxiliares;

import excepciones.ExcepcionSuministrosInsuficientes;

public class Suministros {
	private final int suministrosMaximos;
	private int suministrosLimiteActuales;
	private int suministrosUsados;
	
	public Suministros(int u, int d){
		this.suministrosMaximos = 200;
		this.suministrosLimiteActuales = d;
		this.suministrosUsados = u;
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
	
	public void aumentarSuministrosDisponibles(int aumento){
		suministrosLimiteActuales = Math.min(suministrosLimiteActuales + aumento, suministrosMaximos);
	}

	public int getSuministrosLimiteActuales() {
		return suministrosLimiteActuales;
	}
}

