import Grafos.GrafosTDA;
import Grafos.ImplemEstatica;

import java.io.IOException;

public class Main {
//    public static void main(String[] args) throws IOException {
//
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int i, j, w;

        ImplemEstatica grafo = new ImplemEstatica();
        grafo.inicializarGrafo(10);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);;
        grafo.agregarArista(1,4, 1);
        grafo.agregarArista(1,5, 1);
        grafo.agregarArista(2,4, 1);
        grafo.agregarArista(2,6, 1);
        grafo.agregarArista(3,5, 1);
        grafo.agregarArista(4,1, 1);
        grafo.agregarArista(4,2, 1);
        grafo.agregarArista(5,1, 1);
        grafo.agregarArista(5,3, 1);
        grafo.agregarArista(5,6, 1);
        grafo.agregarArista(6,2, 1);
        grafo.agregarArista(6,5, 1);



        grafo.mostrarMatriz();
        System.out.println("=========");

        int[] ady = grafo.adyacentes(1);

        int[] p = new int[10];

        String marca[] = new String[10];

        for(w=0; w < marca.length; w++) {
            marca[w] = "B";
        }

        int[] dfs = DFS(grafo, 1, p, marca);

        for(j=1; j<dfs.length; j++) {
            System.out.println(dfs[j]);
        }
    }

    public static int[] DFS(ImplemEstatica grafo, int origen, int[]p, String[] marca) {
        //int[] ady = grafo.adyacentes(origen);


        marca[origen] = "G";

        for (int v: grafo.adyacentes(origen))
            if(marca[v] == "B") {
                p[v] = origen;
                DFS(grafo, v, p, marca);
            }

        marca[origen] = "N";

        return p;

    }
}