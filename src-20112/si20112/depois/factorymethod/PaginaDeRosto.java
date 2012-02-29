package si20112.depois.factorymethod;

public class PaginaDeRosto implements Pagina {

	private String nome;

	public PaginaDeRosto(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String versaoParaImpressao() {
		return nome.toUpperCase();
	}

}
