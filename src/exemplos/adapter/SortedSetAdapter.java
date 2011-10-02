package exemplos.adapter;

import java.util.SortedSet;

public class SortedSetAdapter implements Enfileiravel {

	private final SortedSet<Integer> setExemplo;

	public SortedSetAdapter(SortedSet<Integer> setExemplo) {
		this.setExemplo = setExemplo;
	}

	@Override
	public void add(int i) {
		this.setExemplo.add(i);
	}

	@Override
	public int peekFirst() {
		return setExemplo.first();
	}

	@Override
	public int peekLast() {
		return this.setExemplo.last();
	}

}
