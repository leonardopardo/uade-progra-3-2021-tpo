package Implementations;

import Grafos.GrafosTDA;

import java.util.*;

/**
 * @Precondiciones El grafo debe ser dirigido y ponderado.
 * Los costos de las aristas deben ser valores positivos.
 *
 * @Objetivo Dado un grafo y un vertice "v" perteneciente al
 * conjunto de vertices del grafo Dijkstra obtiene el camino
 * mas corto de ese vertice "v" al resto de los vertices.
 */
public class Dijkstra {

    public static void route(GrafosTDA grafo, int[][] matrizaAdy, int origen){

        Dictionary<Integer, Integer> D = new Hashtable<>();
        Dictionary<Integer, Integer> P = new Hashtable<>();

        List<Integer> Q = new ArrayList<>();

        int[] vertices = grafo.vertices();

        for (int i = 0; i < vertices.length; i++) {
            D.put(vertices[i], enteroMaximo(32));
            P.put(vertices[i], null);
            Q.add(vertices[i]);
        }

        D.put(origen, 0);

        Q.remove(origen);

        Queue<Integer> conjuntoSolucion = new LinkedList<Integer>();

        while(!Q.isEmpty()){
            int menor = adyacente_de_menor_costo(Q); //
            conjuntoSolucion.add(menor);

            for (int i = 0; i < lista_de_adyacentes_de_un_vertice(grafo, menor).length; i++) {
                if(D.get(i) > D.get(i) + matrizaAdy[menor][0]) {
                    D.put(i, D.get(i) + matrizaAdy[menor][0]);
                    P.put(0, menor);
                }
            }
        }

    }

    /**
     * TODO: RESOLVER
     * @param grafo
     * @param v
     * @return
     */
    private static int[] lista_de_adyacentes_de_un_vertice(GrafosTDA grafo, int v){
        return new int[0];
    }

    /**
     * TODO: RESOLVER
     * @param vertices
     * @return
     */
    private static int adyacente_de_menor_costo(List<Integer> vertices) {
        return 0;
    }

    /**
     * Regresa en número más grande posible según el tamaño de palabra.
     * Si el tamaño de palabra no es potencia de 2 regresa 0;
     * @param bits
     * @return
     */
    private static int enteroMaximo(int bits)
    {
        return esPotenciaDeDos(bits)
                ? (int) Math.pow(2, bits) - 1
                : 0;
    }

    /**
     * Calcula si un entero dado es potencia de 2.
     * Retorna verdadero en caso afirmativa, falso en caso contrario.
     * @param x
     * @return
     */
    private static boolean esPotenciaDeDos(int x)
    {
        return (x != 0) && ((x & (x - 1)) == 0);
    }
}
