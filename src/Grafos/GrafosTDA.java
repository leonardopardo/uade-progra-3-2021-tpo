package Grafos;

public interface GrafosTDA {
	
	void inicializarGrafo(int dim);
	
	void eliminarVertice(int v);
	
	void agregarVertice(int v) ;

	int[] vertices();
	
	void agregarArista(int v1, int v2, int peso);
	
	void eliminarArista(int v1, int v2);
	
	boolean existeArista(int v1, int v2);
	
	int pesoArista(int v1, int v2);
	
	void mostrarMatriz();

	int[][] matriz();
	
	boolean pertenece(int x);
	
	int mayorArista(int v);

	int menorArista(int v);
	
	int[] conjuntoAislados();
	
	void imparAristas();
	
	int[] dephtFirstSearch();

	int[] adyacentes(int v);
}
