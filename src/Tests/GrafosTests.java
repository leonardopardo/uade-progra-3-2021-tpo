package Tests;

import Grafos.GrafoDinamic;
import Grafos.GrafosTDA;
import Grafos.ImplemEstatica;
import Implementations.Bfs;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
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
    void agregar_nodos_grafo_dinamico_y_pedir_listado_de_vertices() {

        GrafosTDA grafo = new GrafoDinamic();
        grafo.inicializarGrafo(4);
        grafo.agregarVertice(2);
        grafo.agregarVertice(7);
        grafo.agregarVertice(3);
        grafo.agregarVertice(6);

        assertEquals(6, grafo.vertices()[0]);
        assertEquals(3, grafo.vertices()[1]);
        assertEquals(7, grafo.vertices()[2]);
        assertEquals(2, grafo.vertices()[3]);
        assertNotEquals(6, grafo.vertices()[3]);
    }
}
