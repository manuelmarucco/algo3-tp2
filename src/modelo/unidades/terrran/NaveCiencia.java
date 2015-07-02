package modelo.unidades.terrran;

import modelo.excepciones.Mapa.ExcepcionCasillaVacia;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.Unidades.ExcepcionEnergiaInsuficiente;
import modelo.excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import modelo.excepciones.Unidades.ExcepcionYaActuo;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Hechizable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Vision;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.*;

public class NaveCiencia extends UnidadMagica {

    public NaveCiencia(){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10,8);
    }
    public NaveCiencia(Vision visionJugador){
        super(new ResistenciaTerran(200), new Energia(200, 50, 10), 10, new Aereo(), 2, new Costo(100, 255), 10, 8, visionJugador, 0);
    }

    public void EMP(Coordenada c) throws ExcepcionDeAccionDeUnidad {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
            this.energia.gastar(100);
        ProxyDeHechizos.EMP(this, c);
        this.accion.actuo();

    }

    public void EMP(Hechizable d){
        if(d!=null)
        d.recibirEMP();
    }

    public void Radiacion(Unidad objetivo) throws ExcepcionDeAccionDeUnidad {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada nc= ProxyMapa.getInstance().getCoordenada(this);
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

    public void Radiacion(Coordenada objetivo) throws ExcepcionDeAccionDeUnidad, ExcepcionCasillaVacia {
        if(!this.accion.puedoActuar()) throw new ExcepcionYaActuo();
        Coordenada nc=ProxyMapa.getInstance().getCoordenada(this);
        if(this.getVision()<nc.distancia(objetivo)) throw new ExcepcionObjetivoFueraDeRango();
            this.energia.gastar(75);
        ColocableEnMapa objAereo = ProxyMapa.getInstance().obtenerDeCapaAerea(objetivo);
        ColocableEnMapa objTerrestre = ProxyMapa.getInstance().obtenerDeCapaTerrestre(objetivo);
        if(objAereo!=null) {
            ((Hechizable) objAereo).irradiar();
        }
        else if(objTerrestre!=null){
            ((Hechizable)objTerrestre).irradiar();
        }
        else{
        throw new ExcepcionCasillaVacia();
        }

        this.accion.actuo();
    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.moverEnCapaAerea(this, hasta);

    }

}
