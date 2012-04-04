package si20121.solucao.mv.mc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Representa um objeto do domínio do problema, que mantém dados estatísticos
 * sobre algo que está acontecendo no sistema.
 * 
 * @author nazareno
 * 
 */
public class RegistroDeEstatisticas {

	private Deque<Double> estadoInterno;
	private List<InteressadoNaLogica> interessados;

	public RegistroDeEstatisticas() {
		estadoInterno = new LinkedList<Double>();
		interessados = new LinkedList<InteressadoNaLogica>();
	}

	public void adicionaDados() {
		double novoDado = gerarNovoDado();

		estadoInterno.addLast(novoDado);
		System.out.println("Estado do modelo mudou.");
		
		for (InteressadoNaLogica interessado : interessados) {
			interessado.eventoNaLogica(novoDado);
		}
	}

	private double gerarNovoDado() {
		double factor = 0.90 + 0.2 * Math.random();
		double ultimoValor = estadoInterno.isEmpty() ? 100f : estadoInterno
				.peekLast();
		double novoValor = ultimoValor * factor;
		return novoValor;
	}

	public void cadastraInteressado(InteressadoNaLogica view) {
		this.interessados.add(view);
	}

}
