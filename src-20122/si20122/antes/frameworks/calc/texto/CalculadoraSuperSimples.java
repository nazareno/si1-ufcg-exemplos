package si20122.antes.frameworks.calc.texto;

import java.util.Scanner;

public class CalculadoraSuperSimples {

	int resultado = 0;
	boolean inicioDeOperacao = true;
	String operadorAtual = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CalculadoraSuperSimples calculadora = new CalculadoraSuperSimples();

		Scanner s = new Scanner(System.in);
		String inputString;

		do {
			System.out.println("\n----");
			System.out.println(calculadora.getResultadoParaUsuario());
			System.out.println(calculadora.getInstrucoes());
			inputString = s.nextLine();
			try {
				calculadora.processa(inputString);
			} catch (IllegalArgumentException e) {
				System.err.println("Input inválido: " + e.getMessage());
			}
		} while (inputString != "sair");
	}

	private void processa(String inputString) {
		if (inicioDeOperacao) {
			// esperamos um número
			resultado = leNumero(inputString);
			inicioDeOperacao = false;
		} else if (operadorAtual == null) {
			// esperamos um operador
			operadorAtual = leOperando(inputString);
		} else {
			// hora do resultado
			int segundoOperando = leNumero(inputString);
			resultado = opera(segundoOperando);
			inicioDeOperacao = true;
		}
	}

	/**
	 * @param segundoOperando
	 * @return
	 */
	private int opera(int segundoOperando) {
		if (operadorAtual.equals("+")) {
			return resultado + segundoOperando;
		} else {
			return resultado - segundoOperando;
		}
	}

	private String leOperando(String inputString) {
		if (inputString.trim().equals("+") || inputString.trim().equals("-")) {
			return inputString.trim();
		} else {
			throw new IllegalArgumentException("Operador desconhecido: "
					+ inputString.trim());
		}
	}

	/**
	 * @param inputString
	 * @return
	 */
	private int leNumero(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private String getInstrucoes() {
		if (inicioDeOperacao || operadorAtual != null) {
			return "digite um número";
		} else {
			return "digite um dos operadores: +, -";
		}
	}

	private String getResultadoParaUsuario() {
		if (inicioDeOperacao) {
			return "Resultado: " + resultado;
		} else {
			return resultado + " "
					+ (operadorAtual == null ? "" : operadorAtual);
		}
	}
}
