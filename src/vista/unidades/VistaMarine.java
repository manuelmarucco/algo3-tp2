package vista.unidades;

import javax.swing.*;

public class VistaMarine implements Dibujable {

    private static ImageIcon imagen=new ImageIcon();//todo agregar imagen correspondiente

    @Override
    public ImageIcon getImagen() {
        return imagen;
    }

    @Override
    public void agregarActions() {

    }
}
