package unidades;

import excepciones.ExcepcionMoverfueraDeRango;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionYaSeMovioLaUnidad;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Entrenable;
import interfaces.Hechizable;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Estado.EstadoDeAccion;
import unidades.Estado.NoActuo;

public abstract class Unidad implements Actualizable, ColocableEnMapa , Hechizable,Entrenable  {
    private Vision visionJugador;
    protected Resistencia resistencia;
    protected int vision;
    protected Ubicacion ubicacion;
    protected Costo costo;
    protected int suministro;
    protected EstadoUnidad estado;
    protected int tiempoDeEntrenamiento;
    protected EstadoDeAccion accion;
    protected int movilidad;

    protected Unidad(Resistencia resistencia,int vision,Ubicacion ubicacion,int suministro,Costo costo,int tiempoDeEntrenamiento,int movilidad,Vision visionJugador){
        this.resistencia= resistencia;
        this.estado=new EstadoNormal();
        this.vision=vision;
        this.ubicacion=ubicacion;
        this.suministro=suministro;
        this.costo=costo;
        this.tiempoDeEntrenamiento=tiempoDeEntrenamiento;
        this.accion=new NoActuo();
        this.movilidad=movilidad;
        this.visionJugador=visionJugador;
    }

    public Unidad(Resistencia resistencia, int vision, Ubicacion ubicacion, int suministro, Costo costo, int tiempoDeEntrenamiento, int movilidad) {
        this.resistencia= resistencia;
        this.estado=new EstadoNormal();
        this.vision=vision;
        this.ubicacion=ubicacion;
        this.suministro=suministro;
        this.costo=costo;
        this.tiempoDeEntrenamiento=tiempoDeEntrenamiento;
        this.accion=new NoActuo();
        this.movilidad=movilidad;
    }

    public int getVida() {
        return resistencia.getVidaActual();
    }
    
    @Override
    public Costo getCosto(){
        return costo;
    }

    public int getVision() {
        return vision;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    
    @Override
    public int getTiempoDeEntrenamiento(){
    	return tiempoDeEntrenamiento;
    }
    
    @Override
    public void disminuirTiempoDeEntrenamiento(){
    	tiempoDeEntrenamiento--;
    }

    @Override
    public void agregarse(Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa{

        this.ubicacion.agregarse(this,coordenadas);

    }

    @Override
	public int getSuministro() {

		return suministro;
	}

    protected void matar() {
        if(this.resistencia.estaMuerto()){
            ProxyMapa mapa = ProxyMapa.getInstance();
            mapa.quitar(this);
        }
    }

    public void update(){
        this.estado.update(this);
        this.resistencia.regenerar();
        this.accion=new NoActuo();
        //TODO: asi deberia ser como una unidad le agrega la visibilidad al jugador
        /*
        ProxyMapa mapa = ProxyMapa.getInstance();

        visionJugador.agregarSectorVisible( mapa.getCoordenada(this),vision);
         */
    }

    public void irradiar(){
        this.estado= new EstadoIrradiado();
    }

    public  void recibirEMP(){}

    public ColocableEnMapa getClone() {
        return null;
    }

    public void recibirDanio(int danio) {
        this.resistencia.quitar(danio);
    }

    public void mover(Coordenadas destino) throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionYaSeMovioLaUnidad, ExcepcionMoverfueraDeRango {
        if(!this.accion.puedeMover()) throw new ExcepcionYaSeMovioLaUnidad();
        ProxyMapa mapa = ProxyMapa.getInstance();
        if(mapa.getCoordenada(this).distacina(destino)>this.movilidad) throw new ExcepcionMoverfueraDeRango();
        mapa.agregar(this, destino);
        mapa.quitar(this);
        this.accion= this.accion.movio();
    }
}
