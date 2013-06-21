package durante.grasp;

public class DescontoPorData implements Desconto {

	private final double desconto;
	private final long dataEmMilis;

	public DescontoPorData(long dataEmMilis, double desconto) {
		this.dataEmMilis = dataEmMilis;
		this.desconto = desconto;
	}

	/**
	 * @return the desconto
	 */
	public double getDesconto() {
		return desconto;
	}

	/**
	 * @return the dataEmMilis
	 */
	public long getDataEmMilis() {
		return dataEmMilis;
	}

	@Override
	public double getValorDoDesconto(ItemVenda itemVenda) {
		if (System.currentTimeMillis() < dataEmMilis) {
			return itemVenda.getPrecoBase() * desconto;
		} else {
			return 0;
		}
	}

}
