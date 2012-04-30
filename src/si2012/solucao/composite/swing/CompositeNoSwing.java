package si2012.solucao.composite.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import si20112.depois.decorator.GUIDecorada;

import com.sun.tools.hat.internal.model.JavaBoolean;


public class CompositeNoSwing {
	private JFrame framePrincipal;

	public CompositeNoSwing() {
		framePrincipal = new JFrame("Aplicação");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container painel = new JPanel(new BorderLayout());
		JComponent painelInterno1 = new JPanel(new FlowLayout());
		JComponent painelInterno2 = new JPanel();
		painelInterno1.setBorder(LineBorder.createGrayLineBorder());
		painelInterno2.setBorder(LineBorder.createGrayLineBorder());
		
		JLabel label1 = new JLabel("Um label no painel interno 1");
		JLabel label2 = new JLabel("Outro label no painel interno 2");
		label1.setBorder(LineBorder.createBlackLineBorder());
		label2.setBorder(LineBorder.createBlackLineBorder());
		painelInterno1.add(label1);
		painelInterno1.add(label2);
		painelInterno2.add(new JLabel("No painel interno 2"));
		painel.add(painelInterno1, BorderLayout.EAST);
		painel.add(painelInterno2, BorderLayout.NORTH);
		
		JTextPane texto = new JTextPane();
		texto.setPreferredSize(new Dimension(200, 200));
		texto.setBorder(LineBorder.createGrayLineBorder());
		painel.add(texto, BorderLayout.CENTER);
		
		JButton botao = new JButton("Faz várias coisas");
		painel.add(botao, BorderLayout.SOUTH);
		
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
		CompositeNoSwing gui = new CompositeNoSwing();
		gui.show();
	}


}
