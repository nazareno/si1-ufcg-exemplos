package si20112.depois.observer.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ObserversComSwing {

	private JFrame framePrincipal;

	public ObserversComSwing() {
		framePrincipal = new JFrame("Aplicação");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container painel = new JPanel(new BorderLayout());
		
		JTextPane texto = new JTextPane();
		texto.setPreferredSize(new Dimension(200, 200));
		
		Component textoComRolagem = new JScrollPane(texto);
		painel.add(textoComRolagem, BorderLayout.CENTER);
		
		JButton botao = new JButton("Faz alguma coisa");
		painel.add(botao, BorderLayout.SOUTH);
		
		framePrincipal.add(painel);
		
		// um exemplo de listener:
		ListenerDoTexto controllerDoTexto = new ListenerDoTexto();
		texto.addFocusListener(controllerDoTexto);
		texto.addKeyListener(controllerDoTexto);
		
		/*
		 * Dá pra fazer muito mais, com listeners para diversas coisas...
		 */
	}

	private void show() {
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObserversComSwing gui = new ObserversComSwing();
		gui.show();
	}

}
