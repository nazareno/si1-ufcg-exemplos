package si2012.durante.frameworks;

public class DividirPConquistarSolver {

	private final Problema problema;
	private final SolverStrategy strategy;

	public DividirPConquistarSolver(Problema p, SolverStrategy strategy) {
		this.problema = p;
		this.strategy = strategy;
	}

	public Solucao resolve() {
		return resolve(problema);
	}

	private Solucao resolve(Problema p) {
		if(p.getDados().length <= 1)
			return strategy.solucionaTrivial(p);
		
		Problema[] quebrados = strategy.quebra(p);
		Solucao[] solucoes = new Solucao[quebrados.length];

		for (int i = 0; i < quebrados.length; i++) {
			solucoes[i] = this.resolve(quebrados[i]);
		}
		
		Solucao resultado = strategy.combina(solucoes);
		
		return resultado;
	}

}
