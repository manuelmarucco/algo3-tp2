package unidades.Estado;

public class ActuoYmovio extends EstadoDeAccion {
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
        return false;
    }

    @Override
    public EstadoDeAccion actuo() {
        return null;
    }
}
