package unidades.Estado;

public class NoActuo extends EstadoDeAccion {
    public boolean puedeMover() {
        return true;
    }

    @Override
    public EstadoDeAccion movio() {
        return new Movio();
    }

    @Override
    public boolean puedoActuar() {
        return true;
    }

    @Override
    public EstadoDeAccion actuo() {
        return new Actuo();
    }
}
