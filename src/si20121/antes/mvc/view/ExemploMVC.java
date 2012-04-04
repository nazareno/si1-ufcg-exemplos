package si20121.antes.mvc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import si20121.antes.mvc.mc.SistemaDeRegistro;

/**
 * A interface lida com o apertar de um botão na interface, e há duas visões
 * baseadas em JFreeChart.
 * 
 * @author nazareno
 * 
 */
public class ExemploMVC extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	public ExemploMVC(String title, final SistemaDeRegistro controller) {
		super(title);

		XYView view1 = XYView.createXYView();
		PieView view2 = PieView.createPiewView();
		
		// dispositivo de input do usuário:
		JButton button = criaBotaoDeInput(controller);

		organizaGUI(view1, view2, button);
	}

	/**
	 * Cria botão de input e liga evento dele a chamada de método no controller.
	 * 
	 * @param controller
	 *            O controlador.
	 * @return O botão.
	 */
	private JButton criaBotaoDeInput(final SistemaDeRegistro controller) {
		JButton button = new JButton("Add New Data Item");
	
		// ligando ao controlador:
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.adicionaDados();
			}
		});
		return button;
	}

	private void organizaGUI(ChartPanel view1, ChartPanel view2, JButton button) {
		JPanel content = new JPanel(new BorderLayout());
		content.add(view1, BorderLayout.EAST);
		content.add(view2, BorderLayout.CENTER);
		content.add(button, BorderLayout.SOUTH);
		this.setContentPane(content);
	}

	public static void main(final String[] args) {

		SistemaDeRegistro controller = new SistemaDeRegistro();

		ExemploMVC demo = new ExemploMVC("MVC", controller);

		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}