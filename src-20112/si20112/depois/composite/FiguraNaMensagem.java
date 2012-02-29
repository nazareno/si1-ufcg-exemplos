package si20112.depois.composite;

public class FiguraNaMensagem implements Exibivel {

	private final String caminhoDaFigura;

	public FiguraNaMensagem(String caminhoDaFigura) {
		this.caminhoDaFigura = caminhoDaFigura;
	}

	public void exibe(){
		System.out.println("<Figura>" + caminhoDaFigura + "</Figura>");
	}
}
