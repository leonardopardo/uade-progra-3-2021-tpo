package Implementations;

import Enums.Estado;
import Grafos.GrafosTDA;

import java.util.*;

public class Bfs {

    public static Queue<Integer> routeFrom(GrafosTDA grafo, int origen)
    {
        Dictionary<Integer, Estado> marca = new Hashtable<>();

        int[] vertices = grafo.vertices();

        for (int i = 0; i < vertices.length; i++) {
            marca.put(vertices[i], Estado.NO_VISITADO);
        }

        marca.put(origen, Estado.DESCUBIERTO);

        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(origen);

        Queue<Integer> recorrido = new LinkedList<>();

        while(!fila.isEmpty()){
            int actual = fila.poll();
            int[] adyacentes = grafo.adyacentes(actual);

            for (int i = 0; i < adyacentes.length; i++) {
                if(marca.get(adyacentes[i]) == Estado.NO_VISITADO) {
                    marca.put(adyacentes[i], Estado.DESCUBIERTO);
                    fila.add(adyacentes[i]);
                }
            }

            marca.put(actual, Estado.VISITADO);
            recorrido.add(actual);
        }

        return recorrido;
    }

    public static void printRoute(Queue<Integer> route) {
        while (!route.isEmpty()){
            System.out.println(route.poll());
        }
    }
}
