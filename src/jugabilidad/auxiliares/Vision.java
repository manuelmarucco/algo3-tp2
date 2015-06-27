package jugabilidad.auxiliares;

import jugabilidad.utilidadesMapa.Coordenada;

import java.util.HashSet;

public class Vision {

    private HashSet<Coordenada> visibilidad = new HashSet<>();

    public void agregarSectorVisible(Coordenada coordenadaDeUnidad, int visionDeUnidad){
        if(coordenadaDeUnidad==null) return;
        for (int i = 0; i <= 2 * visionDeUnidad; i++){

            for (int j = 0; j <= 2 * visionDeUnidad; j ++){

                Coordenada punto = this.armarPuntoDeInicio(coordenadaDeUnidad,visionDeUnidad);

                punto.aumentarX(i);
                punto.aumentarY(j);

                if ( punto.distancia(coordenadaDeUnidad) <= visionDeUnidad ){

                    visibilidad.add(punto);

                }
            }
        }

    }

    private Coordenada armarPuntoDeInicio(Coordenada punto, int vision){
        if(punto!=null) {
            int x = punto.getX() - vision;
            int y = punto.getY() - vision;

            return (new Coordenada(x, y));
        }
        return null;
    }

    public static Vision VisionCompleta(int x,int y){
        Vision v = new Vision();
        for(int i = 1; i <= x; i++){
            for(int j = 1; j <= y; j++){
                v.visibilidad.add(new Coordenada(i,j));
            }
        }
        return v;
    }

    public Boolean esVisible( Coordenada coordenada ){

        return ( this.visibilidad.contains(coordenada) );

    }
}
