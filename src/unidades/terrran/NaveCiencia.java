package unidades.terrran;

import excepciones.EnergiaInsuficiente;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class NaveCiencia extends UnidadMagica {

    public NaveCiencia(){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10);
    }

    public void EMP(Coordenadas c){
        try {
            this.energia.gastar(100);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        ProxyDeHechizos.EMP(this,c);

    }

    public void EMP(Unidad d){
        if(d!=null)//TODO: sacar esto
        d.recibirEMP();
    }


    public void Radiacion(Unidad objetivo){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        if(ProxyDeHechizos.esUnidad(objetivo))
        objetivo.irradiar();
    }

}
