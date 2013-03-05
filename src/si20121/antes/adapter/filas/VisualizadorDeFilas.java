package si20121.antes.adapter.filas;

public class VisualizadorDeFilas {

	public String getVisualizacao(FilaDeNumeros fila) {
		return fila.peekFirst() + "..." + fila.peekLast();
	}

}
