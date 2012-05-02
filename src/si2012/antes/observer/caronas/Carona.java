package si2012.antes.observer.caronas;

import java.util.LinkedList;
import java.util.List;

public class Carona {

	private List<Usuario> pretendentes;
	private List<Usuario> confirmados;
	private boolean encerrada;

	public Carona() {
		pretendentes = new LinkedList<Usuario>();
		confirmados = new LinkedList<Usuario>();
		encerrada = false;
	}

	public void solicitaCarona(Usuario usuario) throws SolicitacaoIlegalException {
		if(encerrada)
			throw new SolicitacaoIlegalException("Carona encerrada.");
		this.pretendentes.add(usuario);
	}

	public void confirmaCaroneiro(Usuario usuario) {
		if (pretendentes.remove(usuario)) {
			confirmados.add(usuario);
		} else {
			throw new IllegalArgumentException("Caroneiro inexistente: "
					+ usuario);
		}

	}

	public void encerraCarona() {
		this.encerrada = true;
	}

}
