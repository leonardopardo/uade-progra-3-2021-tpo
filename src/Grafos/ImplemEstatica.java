package Grafos;

import java.util.ArrayList;

public class ImplemEstatica implements GrafosTDA {
	
	int indice ;

	int[][] matrizAdy;

	int dim ;

	int [] etiquetas;

	@Override
	public void inicializarGrafo(int dim) {
		this.dim = dim ;
		indice = 0;
		matrizAdy = new int[dim][dim];		
		etiquetas = new int[dim];
	}

	@Override
	public void agregarVertice(int v) {
		if(indice < dim) {
			etiquetas[indice] = v;			
			for(int i = 0 ;i < dim; i++ ) {
				matrizAdy[i][indice] = 0;
				matrizAdy[indice][i] = 0;
			}
			indice ++;
		} else {
			System.out.println("No se puden agregar mas nodos");
		}		
	}

	@Override
	public void eliminarVertice(int v) {
		int aux = this.posicionDeNodo(v);
		if(aux != -1) {
			for(int i = 0; i < indice; i++) {
				matrizAdy[aux][i] = matrizAdy[indice-1][i];
				matrizAdy[i][aux] = matrizAdy[i][indice - 1];				
			}
		etiquetas[this.posicionDeNodo(v)] = etiquetas[indice - 1];
		indice-- ;
		}else {
			System.out.println("No se encontro el vertice");
		}	
	}

	@Override
	public void agregarArista(int v1, int v2, int peso) {
		if(this.posicionDeNodo(v1) != -1 && this.posicionDeNodo(v2) != -1) {
			matrizAdy[this.posicionDeNodo(v1)][this.posicionDeNodo(v2)] = peso;
		}else {
			System.out.println("Alguno de los nodos no existe");
		}
	}

	@Override
	public int[] vertices() {
		int[] aux = new int[indice];
		for(int i = 0; i < indice; i++) {
			aux[i] = etiquetas[i];
			//System.out.print(aux[i] + "\t");
		}
		// System.out.println();
		return aux;
	}

	@Override
	public void eliminarArista(int v1, int v2) {
		
		if(this.posicionDeNodo(v1)>=0 && this.posicionDeNodo(v2)>=0) {
			matrizAdy[this.posicionDeNodo(v1)][this.posicionDeNodo(v2)] = 0;	
		}else {
			System.out.println("No existe alguno de los nodos");
		}
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		return this.matrizAdy[this.posicionDeNodo(v1)][this.posicionDeNodo(v2)] != 0;
	}

	@Override
	public void mostrarMatriz() {
		System.out.print("\t");
		this.vertices();
		System.out.println();
		for(int i = 0; i < indice; i++) {
			System.out.print(etiquetas[i] + "\t");
			for(int j = 0; j < indice; j++) {
				System.out.print(this.matrizAdy[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	@Override
	public int[][] matriz() {
		return this.matrizAdy;
	}

	@Override
	public boolean pertenece(int x) {
		return this.posicionDeNodo(x) != -1;
	}

	@Override
	public int mayorArista(int v) {

		int fila = this.posicionDeNodo(v);

		if(v != -1) {
			int aux = 0;
			for(int i = 0; i < indice; i++) {
				if(aux  < matrizAdy[fila][i]) {
					aux = matrizAdy[fila][i];
				}
			}
		
			return aux ;
		} else {
			System.out.println("El nodo no se encuentra");
			return v;
		}
	}

	@Override
	public int menorArista(int v){
		int fila = this.posicionDeNodo(v);

		if(v != -1) {
			int aux = 0;
			for(int i = 0; i < indice; i++) {
				if(aux > matrizAdy[fila][i]) {
					aux = matrizAdy[fila][i];
				}
			}

			return aux ;
		} else {
			System.out.println("El nodo no se encuentra");
			return v;
		}
	}

	@Override
	public int[] conjuntoAislados() {

		int[] aislados = new int [indice];

		int flag = 0;

		for(int i = 0 ; i < indice ; i ++) {

			flag = 0;

			for(int j = 0 ; j < indice ; j++) {
				if( matrizAdy[i][j] != 0 || matrizAdy[j][i] !=0)  {
					flag = 1;
					break;
				}				
			}

			if(flag == 0) {
				aislados[i]= etiquetas[i];
				System.out.print(aislados[i] + "\t");
			}
		}

		return aislados;
			
	}

	@Override
	public void imparAristas() {

		int contar ;

		for(int i = 0; i < indice; i ++) {

			contar = 0;

			for(int j = 0; j < indice; j++) {
				if(matrizAdy[i][j] != 0) {
					contar++;
				}
			}

			if(contar % 2 != 0) {
				System.out.print(etiquetas[i] + "\t");
			}
		}
	}

	@Override
	public int pesoArista(int v1, int v2) {
		return this.existeArista(v1, v2)
				? this.matrizAdy[this.posicionDeNodo(v1)][this.posicionDeNodo(v2)]
				: -1;
	}

	@Override
	public int[] dephtFirstSearch() {
		return null;
	}

	@Override
	public int[] adyacentes(int v) {

		int[] fila = this.matrizAdy[posicionDeNodo(v)];

		ArrayList<Integer> output = new ArrayList<>();

		for (int i = 0; i < fila.length ; i++) {
			if(fila[i] > 0) output.add(this.etiquetas[i]);
		}

		return output
				.stream()
				.mapToInt(i -> i)
				.toArray();
	}

	public int posicionDeNodo(int v) {

		for(int i = 0;  i < indice ; i++) {
			if(etiquetas[i] == v) {
				return i;
			}
		}

		return -1;
	}
}
