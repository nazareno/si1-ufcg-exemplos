package exemplos.mvc.vc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieView extends ChartPanel implements InteressadoNaLogica {

	private static final String IMPARES_KEY = "Ímpares";
	private static final String PARES_KEY = "Pares";
	
	private DefaultPieDataset dataset;
	private int valoresConhecidos;

	private PieView(JFreeChart chart, DefaultPieDataset dataset) {
		super(chart);
		this.dataset = dataset;
		this.valoresConhecidos = 0;
	}

	/**
	 * Vide XYView para explicação.
	 */
	public static PieView createPiewView() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue(PARES_KEY, 50.0);
		dataset.setValue(IMPARES_KEY, 50.0);

		JFreeChart chart = ChartFactory.createPieChart("Visão de torta", // chart
				// title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionOutlinesVisible(false);
		plot.setNoDataMessage("No data available");

		return new PieView(chart, dataset);
	}

	@Override
	public void notificaValorAdicionado(double valor) {
		/*
		 * Uma implementacao melhor ainda seria sempre perguntar ao modelo qual
		 * a quantidade de valores pares e Impares armazenados. Como fazer isso?
		 */
		System.out.println("Visão 2: notificada da adição de " + valor + " no modelo");
		atualizaValoresConhecidos(valor);
	}

	/**
	 * Lógica do que deve ser feito a cada novo valor. 
	 */
	private void atualizaValoresConhecidos(double valor) {
		double paresAtuais = getParesAtuais();
		double imparesAtuais = getImparesAtuais();

		valoresConhecidos += 1;

		if (((int) valor) % 2 == 0) {
			paresAtuais += 1;
			System.out.println("Visão 2: mais um valor par.");
		} else {
			imparesAtuais += 1;
			System.out.println("Visão 2: mais um valor ímpar.");
		}

		this.dataset.setValue(PARES_KEY, paresAtuais / valoresConhecidos);
		this.dataset.setValue(IMPARES_KEY, imparesAtuais / valoresConhecidos);
	}

	private double getImparesAtuais() {
		double imparesAtuais = this.dataset.getValue(IMPARES_KEY).doubleValue()
				* valoresConhecidos;
		return imparesAtuais;
	}

	private double getParesAtuais() {
		double paresAtuais = this.dataset.getValue(PARES_KEY).doubleValue()
				* valoresConhecidos;
		return paresAtuais;
	}

}
