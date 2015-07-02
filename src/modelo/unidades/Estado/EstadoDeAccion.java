package modelo.unidades.Estado;

public abstract class EstadoDeAccion {
    public abstract boolean puedeMover();

    public abstract EstadoDeAccion movio();

    public abstract boolean puedoActuar();

    public abstract EstadoDeAccion actuo();
}
