package Implementations;

import Enums.Estado;
import Grafos.GrafosTDA;

import java.util.*;

public class Bfs {

    /**
     * @Precondiciones El grafo no puede estar vacío y el elemento origen
     * tiene que ser vertice del grafo.
     * @param grafo
     * @param origen
     * @return
     */
    public static Queue<Integer> route(GrafosTDA grafo, int origen)
    {
        // Estructura auxiliar con estado de los vertices.
        Dictionary<Integer, Estado> marca = new Hashtable<>();

        int[] vertices = grafo.vertices();

        // Cargo mi estructura de vertices con estado de NO_INICIALIZADO
        // a todos los vertices del grafo.
        for (int i = 0; i < vertices.length; i++) {
            marca.put(vertices[i], Estado.NO_VISITADO);
        }

        // Al elemento considerado de origen le cambio el estado a DESCUBIERTO
        // dentro de mi estructura de vertices.
        marca.put(origen, Estado.DESCUBIERTO);

        // Creo mi estructura de fila (FIFO)
        // y le agrego el primer elemento porque este es visitado obligatoriamente.
        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(origen);

        // Arreglo de padres ordenados conforme a como se fueron visitando.
        Queue<Integer> padres = new LinkedList<>();

        // Core
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
            padres.add(actual);
        }

        return padres;
    }
}
