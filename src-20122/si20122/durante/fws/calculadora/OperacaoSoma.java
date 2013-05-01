package si20122.durante.fws.calculadora;

public class OperacaoSoma implements Operacao {

	@Override
	public int opera(int operando1, int operando2) {
		return operando1 + operando2;
	}

	@Override
	public String getSimbolo() {
		return "+";
	}
}
