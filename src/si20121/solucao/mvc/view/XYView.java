package si20121.solucao.mvc.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import si20121.solucao.mv.mc.InteressadoNaLogica;

public class XYView extends ChartPanel implements InteressadoNaLogica {

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
	}

	@Override
	public void eventoNaLogica(double novoDado) {
		System.out.println("XYView atualizado com novo valor via evento.");
		this.adicionaValorNaVisao(novoDado);
	}

}
