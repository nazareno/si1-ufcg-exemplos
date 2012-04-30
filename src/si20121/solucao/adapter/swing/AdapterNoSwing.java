package si20121.solucao.adapter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdapterNoSwing {
	private JFrame window;
	private CamadaLogicaDoExemploComSwing camadaLogica;

	public AdapterNoSwing() {
		camadaLogica = CamadaLogicaDoExemploComSwing.getInstance();

		window = new JFrame("Janela");
		window.setBounds(30, 30, 300, 300);
		JButton botao = new JButton("Exemplo");

		/*
		 * QUEREMOS QUE QUANDO O BOTAO FOR APERTADO, CHAME
		 * CAMADALOGICA#METODODACAMADALOGICA()
		 * 
		 * O botao pede um objeto ActionListener no qual chamara um metodo desta
		 * interface.
		 */

		window.add(botao);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new AdapterNoSwing();
	}
}