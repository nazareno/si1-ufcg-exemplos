package si20112.depois.mvc.vc;

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
	 * Fatora o c�digo necess�rio para criar um painel com gr�fico seguindo a
	 * arquitetura do JFreeChart. Nessa arquitetura, � preciso criar primeiro
	 * uma s�rie de dados e depois um gr�fico.
	 * 
	 * @return Uma inst�ncia de uma vis�o que tem um gr�fico XY para dados que
	 *         ser�o informados atrav�s da interface InteressadoNaLogica.
	 */
	public static XYView createXYView() {
		XYSeries seriesToPlot = new XYSeries("Dados do negocio");
		XYSeriesCollection dataset = new XYSeriesCollection(seriesToPlot);

		// o gr�fico que ser� mostrado no painel
		JFreeChart result = ChartFactory.createXYLineChart(
				"Gerador de itens aleatorios", "Item", "Valor", dataset,
				PlotOrientation.VERTICAL, false, true, false);
		
		return new XYView(result, seriesToPlot);
	}

	/**
	 * Um gr�fico do JFreeChart � cadastrado como interessado em eventos de uma
	 * s�rie de dados. A forma como este Panel, que � a view do MVC avisa o
	 * gr�fico que algo mudou � adicionando dados � s�rie.
	 * 
	 * @param chart
	 *            O gr�fico para plotar dentro do painel.
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
