package exemplos.adapter;

import java.util.LinkedList;
import java.util.List;

public class MinhaFilaDeNumeros implements Enfileiravel {

	private List<Integer> dados;

	public MinhaFilaDeNumeros() {
		this.dados = new LinkedList<Integer>();
	}

	@Override
	public void add(int i) {
		dados.add(i);
	}

	@Override
	public int peekFirst() {
		return dados.get(0);
	}

	@Override
	public int peekLast() {
		return dados.get(dados.size() - 1);
	}

}
