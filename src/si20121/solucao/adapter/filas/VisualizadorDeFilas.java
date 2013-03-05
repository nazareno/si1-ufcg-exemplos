package si20121.solucao.adapter.filas;

public class VisualizadorDeFilas {

	public String getVisualizacao(UmaFilaDeNumeros fila) {
		return fila.peekFirst() + "..." + fila.peekLast();
	}

}
