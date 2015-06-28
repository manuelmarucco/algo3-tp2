package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import excepciones.Unidades.ExcepcionMoverfueraDeRango;
import excepciones.Unidades.ExcepcionYaSeMovioLaUnidad;
import interfaces.Actualizable;
import interfaces.ColocableEnMapa;
import interfaces.Entrenable;
import interfaces.Hechizable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Vision;
import jugabilidad.utilidadesMapa.Coordenada;
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
    protected int tiempoDeEntrenamientoActual;
    protected int tiempoDeEntrenamientoTotal;
    protected EstadoDeAccion accion;
    protected int movilidad;
    protected int transporte;

    protected Unidad(Resistencia resistencia,int vision,Ubicacion ubicacion,int suministro,Costo costo,int tiempoDeEntrenamiento,int movilidad,Vision visionJugador,int transporte){
        this.resistencia= resistencia;
        this.estado=new EstadoNormal();
        this.vision=vision;
        this.ubicacion=ubicacion;
        this.suministro=suministro;
        this.costo=costo;
        this.tiempoDeEntrenamientoActual = tiempoDeEntrenamiento;
        this.tiempoDeEntrenamientoTotal = tiempoDeEntrenamiento;
        this.accion=new NoActuo();
        this.movilidad=movilidad;
        this.visionJugador=visionJugador;
        this.transporte=transporte;
    }

    public Unidad(Resistencia resistencia, int vision, Ubicacion ubicacion, int suministro, Costo costo, int tiempoDeEntrenamiento, int movilidad) {
        this.resistencia= resistencia;
        this.estado=new EstadoNormal();
        this.vision=vision;
        this.ubicacion=ubicacion;
        this.suministro=suministro;
        this.costo=costo;
        this.tiempoDeEntrenamientoActual = tiempoDeEntrenamiento;
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
    public int getTiempoDeEntrenamientoActual(){
    	return this.tiempoDeEntrenamientoActual;
    }

    @Override
    public int getTiempoDeEntrenamientoTotal(){return this.tiempoDeEntrenamientoTotal; }
    @Override
    public void disminuirTiempoDeEntrenamientoActual(){
    	this.tiempoDeEntrenamientoActual--;
    }

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa{

        this.ubicacion.agregarse(mapa,this, coordenada);

    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa{

        this.ubicacion.moverse(mapa, this, hasta);

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

        ProxyMapa mapa = ProxyMapa.getInstance();

        visionJugador.agregarSectorVisible( mapa.getCoordenada(this),vision);

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
        this.matar();
    }

    public void mover(Coordenada destino) throws ExcepcionNoSePudoAgregarAlMapa, ExcepcionDeAccionDeUnidad {

        if(!this.accion.puedeMover()) throw new ExcepcionYaSeMovioLaUnidad();

        ProxyMapa mapa = ProxyMapa.getInstance();

        if(mapa.getCoordenada(this).distancia(destino)>this.movilidad) throw new ExcepcionMoverfueraDeRango();

        mapa.mover(destino, this);

        this.accion= this.accion.movio();
    }
    public int getTransporte(){
        return this.transporte;
    }

    public void recibirRadiacion(int danio){
        this.recibirDanio(danio);
    }

}
