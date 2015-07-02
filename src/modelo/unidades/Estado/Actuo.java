package modelo.unidades.Estado;

public class Actuo extends EstadoDeAccion {
    @Override
    public boolean puedeMover() {
        return true;
    }

    @Override
    public EstadoDeAccion movio() {
        return new ActuoYmovio();
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
