package modelo.jugabilidad.extrasJuego;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.jugabilidad.utilidadesMapa.NullPosicionTerrestre;
import modelo.recursos.Cristal;
import modelo.recursos.Volcan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreadorDeMapa {

    // Atributos -------------------------------------------------------------------------------------------------------

    private ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
    private HashMap<Integer, Class > mapeadorDeClases = new HashMap<>();

    int anchoMapa, altoMapa;
    private ProxyMapa proxyMapa;

    ArrayList<Coordenada> bases = new ArrayList<>();

    // Metodos publicos ------------------------------------------------------------------------------------------------

    public CreadorDeMapa(int cantidadDeJugadores){

        this.armarMatrizDeMapa("archivosConfiguracionDeMapa/mapaPara" + cantidadDeJugadores + "Jugadores.txt");

        this.guardarDimensionesDelMapa();

        this.crearMapeadorDeClases();

        this.crearMapa();

        this.crearBases("archivosConfiguracionDeMapa/coordenadasBasesPara" + cantidadDeJugadores + "Jugadores.txt");

    }

    public ArrayList<Coordenada> obtenerCoordenadasDeLasBases(){

        return ( this.bases );

    }

    public ProxyMapa obtenerProxyMapa(){

        return ( this.proxyMapa );

    }

    // Metodos privados ------------------------------------------------------------------------------------------------

    private void armarMatrizDeMapa(String nombreDelArchivo){

        try(BufferedReader archivo = new BufferedReader(new FileReader(nombreDelArchivo))) {

            String lineaActual;

            while ((lineaActual = archivo.readLine()) != null){

                if (lineaActual.isEmpty()) continue;

                ArrayList<Integer> fila = new ArrayList<>();

                String[] valoresSinEspacios = lineaActual.trim().split(" ");

                for(String letra: valoresSinEspacios){

                    if (!letra.isEmpty()){

                        int numero = Integer.parseInt(letra);

                        fila.add(numero);
                    }

                }

                this.matriz.add(fila);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void guardarDimensionesDelMapa(){

        this.altoMapa = this.matriz.size();

        // Para el ancho,siendo un mapa rectangular, obtengo una posicion de la matriz (fila) y como es un array
        // le pido su largo.
        this.anchoMapa = this.matriz.get(0).size();

    }

    private void crearMapeadorDeClases(){

        this.mapeadorDeClases.put(1, Cristal.class);
        this.mapeadorDeClases.put(2, Volcan.class);
        this.mapeadorDeClases.put(3, NullPosicionTerrestre.class);

    }

    @SuppressWarnings("unchecked")
    private void crearMapa(){

        this.proxyMapa = ProxyMapa.getInstance();
        proxyMapa.setCoordenadasMaximas(this.anchoMapa,this.altoMapa);

        for (int j = 0; j < this.altoMapa; j++){

            for (int i = 0; i < this.anchoMapa; i++){

                Integer valorActual = this.matriz.get(j).get(i);

                if (valorActual != 0) {

                    try {

                        Class clase = (this.mapeadorDeClases.get(valorActual));
                        ColocableEnMapa agregable = (ColocableEnMapa) clase.getDeclaredConstructor().newInstance();

                        // El mapa no acepta coordenada igual a 0.
                        // Los valores sumados/restados, en las coordenadas, son para colocar el origen en la esquina
                        // inferior izquierda.
                        proxyMapa.agregar(agregable, new Coordenada( i + 1, 25 - j ) );

                    } catch (InstantiationException | IllegalAccessException | ExcepcionNoSePudoAgregarAlMapa
                                                                | NoSuchMethodException | InvocationTargetException e) {

                        e.printStackTrace();

                    }

                }


            }

        }

    }

    private void crearBases(String nombreDelArchivo){

        try(BufferedReader archivo = new BufferedReader(new FileReader(nombreDelArchivo))) {

            String lineaActual;

            while ((lineaActual = archivo.readLine()) != null){

                if (lineaActual.isEmpty()) continue;

                ArrayList<Integer> coordenadasDeLaBase = new ArrayList<>();

                String[] valoresSinEspacios = lineaActual.trim().split(" ");

                for(String letra: valoresSinEspacios){

                    if (!letra.isEmpty()){

                        int numero = Integer.parseInt(letra);

                        coordenadasDeLaBase.add(numero);
                    }

                }

                Coordenada base = new Coordenada(coordenadasDeLaBase.get(0),coordenadasDeLaBase.get(1));

                this.bases.add(base);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
