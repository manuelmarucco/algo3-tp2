package construcciones;

public abstract class CentroDeSuministros extends Construccion {

    protected int capacidadExtra;

    public void update() {
        //cuando se destruye, le desciende los suministros al jugador
    }

    public int getCapacidadExtra(){
        return capacidadExtra;
    }

}
