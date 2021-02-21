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
