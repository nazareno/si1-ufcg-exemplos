package exemplos.abstractfactory;

public class Pedido {

	private String descricao;
	private int quant;

	public void addItem(String descricao, int quant) {
		this.descricao = descricao;
		this.quant = quant;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the quant
	 */
	public int getQuant() {
		return quant;
	}

	
}
