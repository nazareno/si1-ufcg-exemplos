package si20121.antes.adapter.filas;

import java.util.SortedSet;

public class SortedSetAdapter implements FilaDeNumeros {

	private final SortedSet<Integer> setExemplo;

	public SortedSetAdapter(SortedSet<Integer> setExemplo) {
		this.setExemplo = setExemplo;
	}

	@Override
	public void add(int i) {
		setExemplo.add(i);
	}

	@Override
	public int peekFirst() {
		return setExemplo.first();
	}

	@Override
	public int peekLast() {
		return setExemplo.last();
	}

}
