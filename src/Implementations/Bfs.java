package Implementations;

import Enums.Estado;
import Grafos.GrafosTDA;

import java.util.*;

public class Bfs {

    public static Queue<Integer> route(GrafosTDA grafo, int origen)
    {
        Dictionary<Integer, Estado> marca = new Hashtable<>();

        int[] vertices = grafo.vertices();

        for (int i = 0; i < vertices.length; i++) {
            marca.put(vertices[i], Estado.NO_VISITADO);
        }

        marca.put(origen, Estado.DESCUBIERTO);

        Queue<Integer> fila = new LinkedList<Integer>();

        fila.add(origen);

        while(!fila.isEmpty()){
            int actual = fila.poll();
            int[] adyacentes = { 1, 2, 3, 4, 5 }; // <- reemplazar por lista de vertices adyacentes

            for (int i = 0; i < adyacentes.length; i++) {
                if(marca.get(adyacentes[i]) == Estado.NO_VISITADO) {
                    marca.put(adyacentes[i], Estado.DESCUBIERTO);
                    fila.add(adyacentes[i]);
                }
            }
            marca.put(actual, Estado.VISITADO);
        }

        return fila;
    }
}
