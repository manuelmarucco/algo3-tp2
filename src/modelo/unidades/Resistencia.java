package modelo.unidades;

public abstract class Resistencia {
    protected int vidaActual;
    protected int vidaMaxima;

    public Resistencia(int vida) {
        this.vidaActual=this.vidaMaxima=vida;
    }

    public boolean estaMuerto(){
        if(this.vidaActual<=0) return true;
        return false;
    }

    public abstract void quitar(int danio);

    public abstract void regenerar();

    public int getVidaActual(){
        return this.vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
}
