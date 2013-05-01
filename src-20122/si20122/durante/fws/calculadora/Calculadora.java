package si20122.durante.fws.calculadora;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Calculadora {

	private boolean comecoDeOperacao = true;
	private int operando1 = 0;
	private int operando2 = 0;
	private Map<String, Operacao> operacoes;
	private Operacao operacaoSelecionada;
	
	public Calculadora(Operacao[] operacoesConhecidas){
		operacoes = new HashMap<String, Operacao>();
		
		for (Operacao operacao : operacoesConhecidas) {
			cadastraOperacao(operacao);
		}
	}

	private void cadastraOperacao(Operacao operacao) {
		operacoes.put(operacao.getSimbolo(),operacao);
	}

	public void setOperando(int operando) throws OperacaoInvalidaException {
		if (comecoDeOperacao) {
			this.operando1 = operando;
			comecoDeOperacao = false;
		} else {
			if (operacaoSelecionada == null) {
				throw new OperacaoInvalidaException("Precisa setar operação.");
			}
			this.operando2 = operando;
			comecoDeOperacao = true;
		}
	}

	public void setOperacao(String operador) throws OperacaoInvalidaException {
		if(!operacoes.containsKey(operador)){
			throw new OperacaoInvalidaException("Operador não especificado");
		}
		
		this.operacaoSelecionada = operacoes.get(operador);
	}

	public int getResultado() {
		if (operacaoSelecionada == null) {
			return 0;
		}
		
		return operacaoSelecionada.opera(operando1, operando2);
	}

}
