package jugabilidad.auxiliares;

import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashSet;

public class Vision {

    private HashSet<Coordenadas> visibilidad = new HashSet<>();

    public void agregarSectorVisible(Coordenadas coordenadaDeUnidad, int visionDeUnidad){
        if(coordenadaDeUnidad==null) return;
        for (int i = 0; i < 2 * visionDeUnidad; i++){

            for (int j = 0; j < 2 * visionDeUnidad; j ++){

                Coordenadas punto = this.armarPuntoDeInicio(coordenadaDeUnidad,visionDeUnidad);

                punto.aumentarX(i);
                punto.aumentarY(j);

                if ( punto.distancia(coordenadaDeUnidad) <= visionDeUnidad ){

                    visibilidad.add(punto);

                }
            }
        }

    }

    private Coordenadas armarPuntoDeInicio(Coordenadas punto, int vision){
        if(punto!=null) {
            int x = punto.getX() - vision;
            int y = punto.getY() - vision;

            return (new Coordenadas(x, y));
        }
        return null;
    }

    public static Vision VisionCompleta(int x,int y){
        Vision v = new Vision();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                v.visibilidad.add(new Coordenadas(i,j));
            }
        }
        return v;
    }

    public Boolean esVisible( Coordenadas coordenada ){

        return ( this.visibilidad.contains(coordenada) );

    }
}
