package si20121.antes.adapter.filas;

import java.util.LinkedList;
import java.util.List;

public class UmaFilaDeNumeros implements FilaDeNumeros {

	private List<Integer> dados;

	public UmaFilaDeNumeros() {
		this.dados = new LinkedList<Integer>();
	}

	public void add(int i) {
		dados.add(i);
	}

	public int peekFirst() {
		return dados.get(0);
	}

	public int peekLast() {
		return dados.get(dados.size() - 1);
	}

}
