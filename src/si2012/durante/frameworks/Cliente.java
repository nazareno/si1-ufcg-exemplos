package si2012.durante.frameworks;

public class Cliente {

	public static void main(String[] args) {
		int[] dados = new int[]{1, 5, 43, 7, 9, 3, 5};
		Problema p = new Problema(dados);
		DividirPConquistarSolver solver = new DividirPConquistarSolver(p, null); //TODO passar strategy
		Solucao s = solver.resolve();
		System.out.println(s.getDados());
	}
	
}
