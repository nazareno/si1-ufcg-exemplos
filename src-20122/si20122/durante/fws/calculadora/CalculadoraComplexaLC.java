package si20122.durante.fws.calculadora;

import java.util.Scanner;

public class CalculadoraComplexaLC extends CalculadoraSimplesLC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadoraSimplesLC calculadoraApp = new CalculadoraComplexaLC();
		calculadoraApp.roda();
	}

	@Override
	protected Operacao[] criaOperacoesConhecidas() {
		Operacao[] operacoes = {new OperacaoSoma()};
		return operacoes;
	}

}
