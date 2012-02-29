package si20112.depois.frameworks.calc2;

import javax.swing.JFrame;

public class CalculadoraCompleta extends CalculadoraSimples {


	@Override
	protected void cadastraOperacoes() {
		super.cadastraOperacoes();
		cadastraOperacao("*", new Multiplicador());
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculadoraCompleta window = new CalculadoraCompleta();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
