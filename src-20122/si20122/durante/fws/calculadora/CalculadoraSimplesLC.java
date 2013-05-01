package si20122.durante.fws.calculadora;

import java.util.Scanner;

public class CalculadoraSimplesLC {

	private static final String STRING_SAIDA = "sair";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadoraSimplesLC calculadoraApp = new CalculadoraSimplesLC();
		calculadoraApp.roda();
	}

	/**
	 * @param calculadoraApp
	 */
	protected void roda() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			this.leESEtaOperador(scanner);
			this.leESetaOperacao(scanner);
			this.leESEtaOperador(scanner);
			System.out.println("Resultado: " + this.getResultado());
		}
	}


	private Calculadora calculadora;

	public CalculadoraSimplesLC() {
		Operacao[] operacoes = criaOperacoesConhecidas();
		calculadora = new Calculadora(operacoes);
		// mais várias coisas
	}

	/**
	 * @return
	 */
	protected Operacao[] criaOperacoesConhecidas() {
		Operacao[] operacoes = {new OperacaoSoma(), new OperacaoSubtracao()};
		return operacoes;
	}
	
	protected int getResultado() {
		return calculadora.getResultado();
	}
	
	protected void leESetaOperacao(Scanner scanner) {
		while (true) {
			System.out.print("Operação: ");
			String entrada = scanner.nextLine();
			testaESai(entrada);

			try {
				calculadora.setOperacao(entrada);
			} catch (OperacaoInvalidaException e) {
				System.err.println("Operação inválida.");
			}
		}
	}

	protected void leESEtaOperador(Scanner scanner) {
		while (true) {
			System.out.print("Operando: ");
			String entrada = scanner.nextLine();
			testaESai(entrada);
			try {
				int operando = Integer.parseInt(entrada);
				calculadora.setOperando(operando);
				return;
			} catch (OperacaoInvalidaException e) {
				System.err.println("Operando inválido. Digite novamente.");
			} catch (NumberFormatException e) {
				System.err.println("Formato errado: " + e.getMessage());
			}
		}
	}

	private void testaESai(String entrada) {
		if (entrada.equals(STRING_SAIDA)) {
			System.exit(0);
		}
	}
}
