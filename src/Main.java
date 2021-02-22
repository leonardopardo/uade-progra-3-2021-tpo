import Grafos.GrafosTDA;
import Grafos.ImplemEstatica;
import Implementations.Bfs;
import Implementations.Dfs;
import Implementations.Floyd;

import java.io.IOException;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        GrafosTDA grafoDfs = new ImplemEstatica();
        grafoDfs.inicializarGrafo(6);
        cargarGrafoDfs(grafoDfs);

        System.out.println("Recorrido Grafo DFS");
        System.out.println(":::::::::::::::::::::::::::::::::::");

        Dfs dfs = new Dfs(grafoDfs);
        dfs.routeFrom(1);
        dfs.printRoute();

        // ______________________________________________________/

        System.out.println("Recorrido Grafo BFS");
        System.out.println(":::::::::::::::::::::::::::::::::::");

        GrafosTDA grafoBfs = new ImplemEstatica();
        grafoBfs.inicializarGrafo(8);
        cargarGrafoBfs(grafoBfs);
        Queue<Integer> bfsRoute = Bfs.routeFrom(grafoBfs, 2);
        Bfs.printRoute(bfsRoute);

        // ______________________________________________________/

        System.out.println("Matriz de Costos Floyd");
        System.out.println(":::::::::::::::::::::::::::::::::::");

        GrafosTDA grafoFlyd = new ImplemEstatica();
        grafoFlyd.inicializarGrafo(8);
        cargarGrafoFloyd(grafoFlyd);

        Floyd floyd = new Floyd(grafoFlyd.matriz());
        floyd.play();
        grafoFlyd.mostrarMatriz();
    }

    public static void cargarGrafoDfs(GrafosTDA g){
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);;
        g.agregarArista(1,4, 1);
        g.agregarArista(1,5, 1);
        g.agregarArista(2,4, 1);
        g.agregarArista(2,6, 1);
        g.agregarArista(3,5, 1);
        g.agregarArista(4,1, 1);
        g.agregarArista(4,2, 1);
        g.agregarArista(5,1, 1);
        g.agregarArista(5,3, 1);
        g.agregarArista(5,6, 1);
        g.agregarArista(6,2, 1);
        g.agregarArista(6,5, 1);
    }

    public static void cargarGrafoBfs(GrafosTDA g) {
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);
        g.agregarArista(1,3, 1);
        g.agregarArista(2,1, 1);
        g.agregarArista(2,4, 1);
        g.agregarArista(3,5, 1);
        g.agregarArista(5,6, 1);
        g.agregarArista(5,7, 1);
        g.agregarArista(6,8, 1);
        g.agregarArista(7,6, 1);
        g.agregarArista(7,8, 1);
    }

    public static void cargarGrafoFloyd(GrafosTDA g) {
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);
        g.agregarArista(1,3, 1);
        g.agregarArista(2,1, 3);
        g.agregarArista(2,4, 5);
        g.agregarArista(3,5, 1);
        g.agregarArista(5,6, 2);
        g.agregarArista(5,7, 1);
        g.agregarArista(6,8, 5);
        g.agregarArista(7,6, 3);
        g.agregarArista(7,8, 2);
    }
}