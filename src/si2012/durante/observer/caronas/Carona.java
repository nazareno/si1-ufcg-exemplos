package si2012.durante.observer.caronas;

import java.util.LinkedList;
import java.util.List;

public class Carona {

	private List<Usuario> pretendentes;
	private List<Usuario> confirmados;
	private boolean encerrada;
	private List<InteressadoEmCarona> interessados;

	public Carona() {
		pretendentes = new LinkedList<Usuario>();
		confirmados = new LinkedList<Usuario>();
		encerrada = false;
		interessados = new LinkedList<InteressadoEmCarona>();
	}

	public void solicitaCarona(Usuario usuario)
			throws SolicitacaoIlegalException {
		if (encerrada)
			throw new SolicitacaoIlegalException("Carona encerrada.");
		this.pretendentes.add(usuario);
		this.interessados.add(usuario);
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
		for (InteressadoEmCarona interessado : interessados) {
			interessado.caronaEncerrada(this);
		}
	}

	public void addInteressado(InteressadoEmCarona interfaceDeMonitoramento) {
		this.interessados.add(interfaceDeMonitoramento);
	}

	public boolean isUsuarioAceito(Usuario usuario) {
		return confirmados.contains(usuario);
	}

}
