package si20122.durante.eventos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class GUIExemplo implements ActionListener {

	JFrame framePrincipal;
	private JTextPane texto;
	
	public GUIExemplo() {
		framePrincipal = new JFrame();
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container painel = new JPanel(new BorderLayout());
		
		texto = new JTextPane();
		texto.setPreferredSize(new Dimension(200, 200));
		painel.add(texto, BorderLayout.CENTER);
		
		JButton botao = new JButton("Faz várias coisas");
		painel.add(botao, BorderLayout.SOUTH);
		
		framePrincipal.add(painel);
		
		botao.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Botão foi apertado!
		 */
		texto.setText(texto.getText() + "\n" + "Apertaram o botão!");
	}
	
	private void show() {
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUIExemplo gui = new GUIExemplo();
		gui.show();
	}


}
