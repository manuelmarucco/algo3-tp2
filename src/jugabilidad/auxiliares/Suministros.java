package jugabilidad.auxiliares;

import excepciones.ExcepcionSuministrosInsuficientes;

public class Suministros {
	private final int suministrosMaximos;
	private int suministrosDisponibles; //suministros iniciales del juego real
	private int suministrosUsados;
	
	public Suministros(int u, int d){
		this.suministrosMaximos = 200;
		this.suministrosDisponibles = d;
		this.suministrosUsados = u;
	}
	public Suministros(){
		this.suministrosMaximos = 200;
		this.suministrosDisponibles = 0;
		this.suministrosUsados = 0;
	}
	
	public void usarSuministros(int suministrosDeUnidad) throws ExcepcionSuministrosInsuficientes {
			if(suministrosDisponibles< suministrosUsados + suministrosDeUnidad){
				throw new ExcepcionSuministrosInsuficientes();
			}else
				suministrosUsados += suministrosDeUnidad;
			
		}
	
	public void aumentarSuministrosDisponibles(int aumento){
		suministrosDisponibles = Math.min(suministrosDisponibles + aumento, suministrosMaximos);
	}
}

