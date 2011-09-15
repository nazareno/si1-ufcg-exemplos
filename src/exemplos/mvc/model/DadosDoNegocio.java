package exemplos.mvc.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import exemplos.mvc.vc.InteressadoNaLogica;


public class DadosDoNegocio {

	private Deque<Double> estadoInterno;
	private List<InteressadoNaLogica> interessados;

	public DadosDoNegocio() {
		this.estadoInterno = new LinkedList<Double>();
		this.interessados = new LinkedList<InteressadoNaLogica>();
	}
	
	public boolean cadastraInteressadoNaLogica(InteressadoNaLogica interessado){
		return this.interessados.add(interessado);
	}

	public void addData() {
		double novoValor = generateNewData();
		this.estadoInterno.addLast(novoValor);
		System.out.println("Modelo: mudou estado");
		System.out.println("Modelo: notificando interessados");
		for (InteressadoNaLogica interessado : interessados) {
			interessado.notificaValorAdicionado(novoValor);
		}
	}

	/**
	 * Implementa a lógica de negócios para desempenhar alguma função do
	 * sistema. Poderia inclusive se comunicar com a camada de fonte de dados.
	 * 
	 * @return Um novo valor para estender o estado desse objeto.
	 */
	private double generateNewData() {
		double factor = 0.90 + 0.2 * Math.random();
		double ultimoValor = estadoInterno.isEmpty() ? 100f : estadoInterno
				.peekLast();
		double novoValor = ultimoValor * factor;
		return novoValor;
	}

}
