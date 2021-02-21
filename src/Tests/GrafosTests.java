package Tests;

import Grafos.GrafoDinamic;
import Grafos.GrafosTDA;
import Grafos.ImplemEstatica;

import Implementations.Bfs;
import Implementations.Dfs;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class GrafosTests {

    protected GrafosTDA gX;

    public GrafosTests() {
        this.gX = new ImplemEstatica();
        gX.inicializarGrafo(8);
        gX.agregarVertice(1);
        gX.agregarVertice(2);
        gX.agregarVertice(3);
        gX.agregarVertice(4);
        gX.agregarVertice(5);
        gX.agregarVertice(6);
        gX.agregarVertice(7);
        gX.agregarVertice(8);
        gX.agregarArista(1,3, 1);
        gX.agregarArista(2,1, 3);
        gX.agregarArista(2,4, 5);
        gX.agregarArista(3,5, 1);
        gX.agregarArista(5,6, 2);
        gX.agregarArista(5,7, 1);
        gX.agregarArista(6,8, 5);
        gX.agregarArista(7,6, 3);
        gX.agregarArista(7,8, 2);
    }

    @Test
    void inicializar_grafo_estatico_test()
    {
        Grafos.ImplemEstatica grafoEstatico = new ImplemEstatica();
        grafoEstatico.inicializarGrafo(1);

        assertEquals(0, grafoEstatico.vertices().length);
    }

    @Test
    void inicializar_grafo_dinamico_test()
    {
        Grafos.GrafoDinamic grafoDinamic = new GrafoDinamic();
        grafoDinamic.inicializarGrafo(1);

        assertEquals(0, grafoDinamic.vertices().length);
    }

    @Test
    void probar_dfs()
    {
        GrafosTDA g = new ImplemEstatica();
        g.inicializarGrafo(6);
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

        Dfs dfs = new Dfs(g);
        dfs.routeFrom(1);
        dfs.printRoute();
    }

    @Test
    void probar_bfs()
    {
        Queue<Integer> anchura = Bfs.route(this.gX, 2);
    }

    @Test
    void probar_dijkstra()
    {

    }

    @Test
    void prueba_de_min_en_array_int()
    {
        int[] a = { 133,2,4,7,9,12,19 };
        int min = Arrays.stream(a).min().getAsInt();
    }
}
