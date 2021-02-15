package Tests;

import Grafos.GrafoDinamic;
import Grafos.ImplemEstatica;
import org.junit.jupiter.api.Test;
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

        assertEquals(null, grafoDinamic.vertices());
    }
}
