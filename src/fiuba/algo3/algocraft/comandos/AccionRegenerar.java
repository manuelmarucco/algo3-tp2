package fiuba.algo3.algocraft.comandos;

import fiuba.algo3.algocraft.unidades.RazaDeUnidad;

public class AccionRegenerar extends AccionesDeRazaDeUnidad  {
    @Override
    public void actuar(RazaDeUnidad unidad) {
        unidad.recibirDanio(-unidad.getAtributos().get("regeneracion"));//esto es medio choto pero tengo q pensar una mejor forma de hacerlo
    }
}
