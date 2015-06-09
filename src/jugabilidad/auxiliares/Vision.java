package jugabilidad.auxiliares;

import jugabilidad.utilidadesMapa.Coordenadas;

import java.util.HashSet;

public class Vision {

    private HashSet<Coordenadas> visibilidad = new HashSet<>();

    public void agregarSectorVisible(Coordenadas coordenadaDeUnidad, int visionDeUnidad){

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

        int x = punto.getX() - vision;
        int y = punto.getY() - vision;

        return ( new Coordenadas(x,y) );

    }
}
