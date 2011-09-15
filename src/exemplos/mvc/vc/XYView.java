package exemplos.mvc.vc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XYView extends ChartPanel implements InteressadoNaLogica {

	/** The time series data. */
	private XYSeries series;

	/**
	 * Fatora o código necessário para criar um painel com gráfico seguindo a
	 * arquitetura do JFreeChart. Nessa arquitetura, é preciso criar primeiro
	 * uma série de dados e depois um gráfico.
	 * 
	 * @return Uma instância de uma visão que tem um gráfico XY para dados que
	 *         serão informados através da interface InteressadoNaLogica.
	 */
	public static XYView createXYView() {
		XYSeries seriesToPlot = new XYSeries("Dados do negocio");
		XYSeriesCollection dataset = new XYSeriesCollection(seriesToPlot);

		// o gráfico que será mostrado no painel
		JFreeChart result = ChartFactory.createXYLineChart(
				"Gerador de itens aleatorios", "Item", "Valor", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		
		return new XYView(result, seriesToPlot);
	}

	/**
	 * Um gráfico do JFreeChart é cadastrado como interessado em eventos de uma
	 * série de dados. A forma como este Panel, que é a view do MVC avisa o
	 * gráfico que algo mudou é adicionando dados à série.
	 * 
	 * @param chart
	 *            O gráfico para plotar dentro do painel.
	 * @param series
	 *            Os dados que o gráfico usa.
	 */
	private XYView(JFreeChart chart, XYSeries series) {
		super(chart);
		this.series = series;
	}

	@Override
	public void notificaValorAdicionado(double valor) {
		System.out.println("View1: notificada da adição de " + valor);
		double coordenadaX = this.series.isEmpty() ? 1.0
				: series.getMaxX() + 1.0;
		this.series.add(coordenadaX, valor);
	}

}
