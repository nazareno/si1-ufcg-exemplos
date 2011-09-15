package exemplos.mvc.vc;

public interface InteressadoNaLogica {

	void notificaValorAdicionado(double valor);

	/*
	 * Poderíamos ter outros métodos de notificação, e/ou outras interfaces para
	 * interessados em outros eventos.
	 * 
	 * Além disso, esse é o modelo push. o modelo pull seria void
	 * notifivaMudanca() e deixar a view fazer DadosDoNegocio#get*() em seguida.
	 */

}
