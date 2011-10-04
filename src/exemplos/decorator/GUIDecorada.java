package exemplos.decorator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class GUIDecorada {

	private JFrame framePrincipal;

	public GUIDecorada() {
		framePrincipal = new JFrame("Aplicação");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container painel = new JPanel(new BorderLayout());
		
		JTextPane texto = new JTextPane();
		texto.setPreferredSize(new Dimension(200, 200));
		//esse text pane não tem barra de rolagem!
		
		//Component textoDecorado = new JScrollPane(texto);

		painel.add(texto, BorderLayout.CENTER);
		
		JButton botao = new JButton("Faz várias coisas");
		painel.add(botao, BorderLayout.SOUTH);
		// e se quiséssemos decorar também o botão?
		
		framePrincipal.add(painel);
	}

	private void show() {
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUIDecorada gui = new GUIDecorada();
		gui.show();
	}

}
