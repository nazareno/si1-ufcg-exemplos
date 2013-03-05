package si20122.antes.mvc.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import si20122.antes.mvc.mc.InteressadoNoModelo;

public class XYView extends ChartPanel implements InteressadoNoModelo {

	/** The time series data. */
	private XYSeries series;

	public static XYView createXYView() {
		XYSeries seriesToPlot = new XYSeries("Dados do negocio");
		XYSeriesCollection dataset = new XYSeriesCollection(seriesToPlot);

		// o gráfico que ser;a mostrado no painel
		JFreeChart result = ChartFactory.createXYLineChart(
				"Gerador de itens aleatorios", "Item", "Valor", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		return new XYView(result, seriesToPlot);
	}

	private XYView(JFreeChart chart, XYSeries series) {
		super(chart);
		this.series = series;
	}

	/**
	 * @param valor
	 */
	private void adicionaValorNaVisao(double valor) {
		double coordenadaX = this.series.isEmpty() ? 1.0
				: series.getMaxX() + 1.0;
		this.series.add(coordenadaX, valor);
		System.out.println("Visão 1: novo valor adicionado.");
	}

	@Override
	public void notificaMudanca(double novoDado) {
		adicionaValorNaVisao(novoDado);
	}

}
