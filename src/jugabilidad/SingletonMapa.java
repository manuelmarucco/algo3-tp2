package jugabilidad;
//agregue este singleton a modo de prueba
public class SingletonMapa{
    private static Mapa mapa;
    private SingletonMapa(){
    }
    public static Mapa getInstance(){
        if(mapa==null){
            CreadorDeMapa cm = new CreadorDeMapa();
            cm.crearMapa();
            mapa=new Mapa();
        }
        return mapa;
    }
}