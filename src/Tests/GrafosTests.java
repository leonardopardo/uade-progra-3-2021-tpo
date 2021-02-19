package Tests;

import Grafos.GrafoDinamic;
import Grafos.GrafosTDA;
import Grafos.ImplemEstatica;

import Implementations.Bfs;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class GrafosTests {
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
    void cargar_elementos_a_grafo_estatico()
    {
        GrafosTDA g = new ImplemEstatica();
        g.inicializarGrafo(8);
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(4);
        g.agregarVertice(5);
        g.agregarVertice(6);
        g.agregarVertice(7);
        g.agregarVertice(8);
        g.agregarArista(1,4, 1);
        g.agregarArista(2,1, 1);
        g.agregarArista(2,3, 1);
        g.agregarArista(3,5, 1);
        g.agregarArista(3,7, 1);
        g.agregarArista(5,6, 1);
        g.agregarArista(5,7, 1);
        g.agregarArista(6,8, 1);
        g.agregarArista(7,6, 1);
        g.agregarArista(7,8, 1);

        Queue<Integer> anchura = Bfs.route(g, 2);
    }
}
