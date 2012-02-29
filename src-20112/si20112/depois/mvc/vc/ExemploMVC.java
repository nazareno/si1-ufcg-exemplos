package si20112.depois.mvc.vc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import si20112.depois.mvc.model.DadosDoNegocio;



/**
 * O Modelo é um objeto da classe DadosDoNegócio. O controlador lida com o
 * apertar de um botão na interface, e há duas visões baseadas em JFreeChart.
 * 
 * @author nazareno
 * 
 */
public class ExemploMVC extends ApplicationFrame {

	public ExemploMVC(String title, Controller controller, DadosDoNegocio model) {
		super(title);

		XYView view1 = XYView.createXYView();
		PieView view2 = PieView.createPiewView();

		model.cadastraInteressadoNaLogica(view1);
		model.cadastraInteressadoNaLogica(view2);

		// dispositivo de input do usuário:
		JButton button = new JButton("Add New Data Item");
		// ligando ao controlador:
		button.addActionListener(controller);

		organizaGUI(view1, view2, button);
	}

	private void organizaGUI(ChartPanel view1, ChartPanel view2, JButton button) {
		JPanel content = new JPanel(new BorderLayout());
		content.add(view1, BorderLayout.EAST);
		content.add(view2, BorderLayout.CENTER);
		content.add(button, BorderLayout.SOUTH);
		this.setContentPane(content);
	}

	public static void main(final String[] args) {

		DadosDoNegocio model = new DadosDoNegocio();
		Controller controller = new Controller(model);

		ExemploMVC demo = new ExemploMVC("MVC", controller, model);

		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}