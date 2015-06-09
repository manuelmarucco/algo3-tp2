package unidades.Estado;

public class Movio extends EstadoDeAccion {
    @Override
    public boolean puedeMover() {
        return false;
    }

    @Override
    public EstadoDeAccion movio() {
        return null;
    }

    @Override
    public boolean puedoActuar() {
        return true;
    }

    @Override
    public EstadoDeAccion actuo() {
        return new ActuoYmovio();
    }
}
