package unidades.terrran;

import excepciones.EnergiaInsuficiente;
import excepciones.ExcepcionYaActuo;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class NaveCiencia extends UnidadMagica {

    public NaveCiencia(){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10,8);
    }
    public NaveCiencia(Vision visionJugador){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10,8,visionJugador);
    }

    public void EMP(Coordenadas c) throws ExcepcionYaActuo {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(100);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        ProxyDeHechizos.EMP(this,c);
        this.accion.actuo();

    }

    public void EMP(Unidad d){
        if(d!=null)//TODO: sacar esto
        d.recibirEMP();
    }


    public void Radiacion(Unidad objetivo) throws ExcepcionYaActuo {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        if(ProxyDeHechizos.esUnidad(objetivo))
        objetivo.irradiar();
        this.accion.actuo();
    }

}
