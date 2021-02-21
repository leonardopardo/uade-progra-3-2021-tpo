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

/**
función Dijkstra (Grafo G, nodo_salida s)

    //Usaremos un vector para guardar las distancias del nodo salida al resto
    entero distancia[n]

    //Inicializamos el vector con distancias iniciales
    booleano visto[n]

    //vector de boleanos para controlar los vértices de los que ya tenemos la distancia mínima
    para cada w ∈ V[G] hacer
        Si (no existe arista entre s y w) entonces
            distancia[w] = Infinito //puedes marcar la casilla con un -1 por ejemplo
        Si_no
            distancia[w] = peso (s, w)
        fin si
    fin para

    distancia[s] = 0

    visto[s] = cierto

    //n es el número de vértices que tiene el Grafo
    mientras que (no_estén_vistos_todos) hacer

        vértice = tomar_el_mínimo_del_vector distancia y que no esté visto;
        visto[vértice] = cierto;

        para cada w ∈ sucesores (G, vértice) hacer
            si distancia[w]>distancia[vértice]+peso (vértice, w) entonces
                distancia[w] = distancia[vértice]+peso (vértice, w)
            fin si
        fin para
    fin mientras
fin función.
**/

public class Dijkstra {

    public static int[] route(GrafosTDA grafo, int[][] matrizAdy, int origen) {
        Dictionary<Integer, Integer> D = new Hashtable<>();
        Dictionary<Integer, Integer> P = new Hashtable<>();
        Queue<Integer> Q = new LinkedList<>();

        int[] vertices = grafo.vertices();

        for (int i = 0; i < vertices.length; i++) {

            if(!grafo.existeArista(origen, vertices[i]))
                D.put(vertices[i], Integer.MAX_VALUE);
            else
                D.put(vertices[i], grafo.pesoArista(origen, vertices[i]));

            if (origen != vertices[i])
                Q.add(vertices[i]);
        }

        D.put(origen, 0);

        ArrayList<Integer> S = new ArrayList<>();

        int actual = origen;

        while(!Q.isEmpty()) {

            int[] ady = grafo.adyacentes(actual);

            int u = extraer_min(Q, actual, matrizAdy, ady);

            S.add(u);

            for (int i = 0; i < ady.length ; i++) {
                if(D.get(ady[i]) > D.get(u) + matrizAdy[u][ady[i]]){
                    D.put(ady[i], D.get(u) + matrizAdy[u][ady[i]]);
                    P.put(ady[i], u);
                }
            }
        }

        return S.stream().mapToInt(i -> i).toArray();

    }

    private static int extraer_min(Queue Q, int v , int[][] m, int[] a){

        if(a.length == 0)
            return 0;

        int[] f = m[v-1];

        int ver = a[0];

        int min = f[ver-1];

        for (int i = 0; i < a.length; i++) {

            if( min > f[i] ){
                min = f[i];
                ver = a[i];
            }
        }

        Q.remove(ver);

        return ver;
    }

    /**
     * Regresa en número más grande posible según el tamaño de palabra.
     * Si el tamaño de palabra no es potencia de 2 regresa 0;
     * @param bits
     * @return
     */
    private static int enteroMaximo(int bits) {
        // Esto está medio de mas ya que (int) es un entero
        // en representación de 32 bits.
        return esPotenciaDeDos(bits) && bits <= 32
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
