package Implementations;

import Enums.Estado;
import Grafos.GrafosTDA;

import java.util.*;

public class Dfs {

    private GrafosTDA grafo;

    private Dictionary<Integer, Estado> marca;

    private Stack<Integer> recorrido;

    public Dfs(GrafosTDA grafo) {

        this.grafo = grafo;

        this.recorrido = new Stack<>();

        this.marca = new Hashtable<>();

        int[] v = grafo.vertices();

        for (int i = 0; i < v.length; i++) {
            marca.put(v[i], Estado.NO_VISITADO);
        }
    }

    public void routeFrom(int v) {

        this.marca.put(v, Estado.DESCUBIERTO);

        int[] ady = this.grafo.adyacentes(v);

        for (int i = 0; i < ady.length; i++) {
            if( this.marca.get(ady[i]) == Estado.NO_VISITADO)
                routeFrom(ady[i]);
        }

        this.marca.put(v, Estado.VISITADO);

        this.recorrido.add(v);
    }

    public void printRoute() {
        while (!this.recorrido.isEmpty()){
            System.out.println(recorrido.pop());
        }
    }
}
