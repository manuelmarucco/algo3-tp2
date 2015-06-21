package vista.auxiliares.jugador.imagenesMapa;

import java.util.HashMap;

public class HashMapParaMapa<K,V> extends HashMap<K,V> {

    protected V defaultValue;

    public HashMapParaMapa(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public V get(Object key) {

        return this.containsKey(key) ? super.get(key) : defaultValue;

    }


}
