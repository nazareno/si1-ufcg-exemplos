package si20112.depois.adapter;


public class VisualizadorDeColecoes {

	public String getVisualizacao(Enfileiravel enfileiravel) {
		return enfileiravel.peekFirst() + "..." + enfileiravel.peekLast();
	}

}
