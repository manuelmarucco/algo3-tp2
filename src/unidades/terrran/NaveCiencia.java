package unidades.terrran;

import excepciones.EnergiaInsuficiente;
import excepciones.ExcepcionPosicionOcupada;
import interfaces.Daniable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.*;

public class NaveCiencia extends UnidadMagica {

    public NaveCiencia(){
        super(new ResistenciaTerran(200),new Energia(200,50,10),10,new Aereo(),2,new Costo(100,255),10);
    }

    @Override
    public void recibirDanio(Danio danio) {
        this.resistencia.quitar(danio.getDanioAire());
        this.matar();
    }

    public void EMP(Coordenadas c){
        try {
            this.energia.gastar(100);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        Mapa mapa =SingletonMapa.getInstance();
        for(int i =-1;i<2;i++){
            for(int j =-1;j<2;j++){
                Coordenadas coordenadas =new Coordenadas(c.getX()+i, c.getY()+j);
                //TODO: sacar estos casteos
                this.EMP((Unidad)mapa.obtenerDeCapaTerrestre(coordenadas));//aplicar emp
                this.EMP((Unidad)mapa.obtenerDeCapaAerea(coordenadas));//aplicar emp
            }
        }
    }

    private void EMP(Unidad d){
        if(d!=null)//TODO: sacar esto
        d.recibirEMP();
    }


    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {
        try {
            mapa.agregarEnCapaAerea(this,coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }
    }

    public void Radiacion(Daniable objetivo){
        try {
            this.energia.gastar(75);
        } catch (EnergiaInsuficiente energiaInsuficiente) {
            energiaInsuficiente.printStackTrace();
        }
        objetivo.irradiar();
    }
}
