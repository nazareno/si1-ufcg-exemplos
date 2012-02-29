package si20112.depois.frameworks.calc2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculadoraSimples extends JFrame {
	private static final long serialVersionUID = 8967084687056730888L;

	private JTextField displayField; // display result / input.
	private String previousOp = "="; // previous operation
	private int currentTotal = 0; // The internal calculator.

	private Map<String, Operacao> operacoes;

	private boolean startNumber = true; // true: num key next

	/**
	 * O main.
	 */
	public static void main(String[] args) {
		CalculadoraSimples window = new CalculadoraSimples();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	/**
	 * Cria e mostra a calculadora.
	 */
	public CalculadoraSimples() {
		criaDisplay();

		JPanel clearPanel = criaPainelClear();

		JPanel buttonPanel = criaPainelDeBotoesNumericos();

		operacoes = new HashMap<String, Operacao>();
		
		cadastraOperacoes();

		JPanel opPanel = criaPainelDeOperacoes();

		JPanel content = layout(clearPanel, buttonPanel, opPanel);

		// ... Finish building the window (JFrame)
		this.setContentPane(content);
		this.pack();
		this.setTitle("Calculadora");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	/**
	 * 
	 */
	protected void cadastraOperacoes() {
		cadastraOperacao("+", new Somador());
		cadastraOperacao("-", new Subtrator());
	}

	/**
	 * 
	 */
	protected void cadastraOperacao(String nome, Operacao operador) {
		operacoes.put(nome, operador);
	}

	/**
	 * Organiza leiaute.
	 */
	private JPanel layout(JPanel clearPanel, JPanel buttonPanel, JPanel opPanel) {
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(5, 5));
		content.add(displayField, BorderLayout.NORTH);
		content.add(buttonPanel, BorderLayout.CENTER);
		content.add(opPanel, BorderLayout.EAST);
		content.add(clearPanel, BorderLayout.SOUTH);
		return content;
	}

	private JPanel criaPainelClear() {
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearListener());
		JPanel clearPanel = new JPanel();
		clearPanel.setLayout(new FlowLayout());
		clearPanel.add(clearButton);
		return clearPanel;
	}

	private JPanel criaPainelDeOperacoes() {
		ActionListener opListener = new OpListener();

		JPanel opPanel = new JPanel();
		opPanel.setLayout(new GridLayout(0, 1, 2, 2));

		for(String op : operacoes.keySet()){
			JButton b = new JButton(op);
			b.addActionListener(opListener);
			opPanel.add(b);
		}
		
		JButton b = new JButton("=");
		b.addActionListener(opListener);
		opPanel.add(b);
		
		return opPanel;
	}

	private JPanel criaPainelDeBotoesNumericos() {
		ActionListener numListener = new NumListener();

		String buttonOrder = "789456123 0 ";
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 3, 2, 2));
		for (int i = 0; i < buttonOrder.length(); i++) {
			String keyTop = buttonOrder.substring(i, i + 1);
			JButton b = new JButton(keyTop);
			if (keyTop.equals(" ")) {
				// ... Put a dummy button in this position.
				b.setEnabled(false);
			} else {
				// ... Put a digit button in the interface.
				b.addActionListener(numListener);
			}
			buttonPanel.add(b);
		}
		return buttonPanel;
	}

	/**
	 * 
	 */
	private void criaDisplay() {
		displayField = new JTextField("0", 12);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
	}

	private void clearDisplay() {
		startNumber = true; // Expecting number, not op.
		displayField.setText("0");
		previousOp = "=";
		currentTotal = 0;
	}

	/**
	 * Classe interna e listener para todos os botões de operação
	 */
	class OpListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// The calculator is always in one of two states.
			// 1. A number must be entered -- an operator is wrong.
			// 2. An operator must be entered.
			if (startNumber) {
				// Error: needed number, not operator
				// ... In this state we're expecting a number, but got an
				// operator.
				clearDisplay();
				displayField.setText("ERROR - No operator");
			} else {
				// ... We're expecting an operator.
				try {
					/*
					 * Se o operador anterior é =, estamos começando operação.
					 * Se é outra coisa, realiza operação com currentTotal e
					 * display.
					 */
					int display = Integer.parseInt(displayField.getText());

					if (previousOp.equals("=")) {
						// começando operação.
						currentTotal = display;
					} else {
						Operacao paraExecutar = operacoes.get(previousOp);
						currentTotal = paraExecutar
								.opera(currentTotal, display);
					}

					displayField.setText(Integer.toString(currentTotal));

				} catch (NumberFormatException ex) {
					clearDisplay();
					displayField.setText("Error");
				}

				previousOp = e.getActionCommand();
				startNumber = true; // Next thing must be a numberå

			}
		}
	}

	/** Action listener for numeric keys */
	class NumListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String digit = e.getActionCommand(); // Get text from button
			if (startNumber) {
				// ... This is the first digit, clear field and set
				displayField.setText(digit);
				startNumber = false;
			} else {
				// ... Add this digit to the end of the display field
				displayField.setText(displayField.getText() + digit);
			}
		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clearDisplay();
		}
	}
}