package unidades.terrran;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import interfaces.ColocableEnMapa;
import interfaces.Hechizable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.*;

public class NaveCiencia extends UnidadMagica {

    public NaveCiencia(){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10,8);
    }
    public NaveCiencia(Vision visionJugador){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10,8,visionJugador,0);
    }

    public void EMP(Coordenada c) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        try {
            this.energia.gastar(100);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        ProxyDeHechizos.EMP(this,c);
        this.accion.actuo();

    }

    public void EMP(Hechizable d){
        if(d!=null)
        d.recibirEMP();
    }

    public void Radiacion(Unidad objetivo) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada nc=ProxyMapa.getInstance().getCoordenada(this);
        Coordenada obj=ProxyMapa.getInstance().getCoordenada(objetivo);
        if(this.getVision()<nc.distancia(obj)) throw new ExcepcionObjetivoFueraDeRango();
        try {
            this.energia.gastar(75);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        if(objetivo!=null)
        objetivo.irradiar();
        this.accion.actuo();
    }

    public void Radiacion(Coordenada objetivo) throws ExcepcionYaActuo, ExcepcionObjetivoFueraDeRango {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada nc=ProxyMapa.getInstance().getCoordenada(this);
        if(this.getVision()<nc.distancia(objetivo)) throw new ExcepcionObjetivoFueraDeRango();
        try {
            this.energia.gastar(75);
        } catch (ExcepcionEnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        ColocableEnMapa objAereo = ProxyMapa.getInstance().obtenerDeCapaAerea(objetivo);
        ColocableEnMapa objTerrestre = ProxyMapa.getInstance().obtenerDeCapaAerea(objetivo);
        if(objAereo!=null) {
            ((Hechizable) objAereo).irradiar();
        }
        else if(objTerrestre!=null){
            ((Hechizable)objTerrestre).irradiar();
        }
        //todo agregar Excepcion

        this.accion.actuo();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }

}
