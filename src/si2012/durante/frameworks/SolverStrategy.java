package si2012.durante.frameworks;

public interface SolverStrategy {

	Solucao solucionaTrivial(Problema p);

	Problema[] quebra(Problema p);

	Solucao combina(Solucao[] solucoes);

}
