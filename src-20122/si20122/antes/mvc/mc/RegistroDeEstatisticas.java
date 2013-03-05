package si20122.antes.mvc.mc;

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
	private List<InteressadoNoModelo> interessados;

	public RegistroDeEstatisticas() {
		estadoInterno = new LinkedList<Double>();
		interessados = new LinkedList<InteressadoNoModelo>();
	}

	public void adicionaDados() {
		double novoDado = gerarNovoDado();

		estadoInterno.addLast(novoDado);
		System.out.println("Estado do modelo mudou.");

		for (InteressadoNoModelo interessado : interessados) {
			interessado.notificaMudanca(novoDado);
		}

	}

	private double gerarNovoDado() {
		double factor = 0.90 + 0.2 * Math.random();
		double ultimoValor = estadoInterno.isEmpty() ? 100f : estadoInterno
				.peekLast();
		double novoValor = ultimoValor * factor;
		return novoValor;
	}

	public void cadastraNovoInteressado(InteressadoNoModelo interessado) {
		interessados.add(interessado);
	}

}
