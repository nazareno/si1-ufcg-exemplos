package si20112.depois.mvc.vc;

public interface InteressadoNaLogica {

	void notificaValorAdicionado(double valor);

	/*
	 * Poder�amos ter outros m�todos de notifica��o, e/ou outras interfaces para
	 * interessados em outros eventos.
	 * 
	 * Al�m disso, esse � o modelo push. o modelo pull seria void
	 * notifivaMudanca() e deixar a view fazer DadosDoNegocio#get*() em seguida.
	 */

}
