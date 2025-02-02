package relatorio.vendas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a vertical 3D bar
 * chart using data from a {@link CategoryDataset}.
 *
 */
public class BarChart3DDemo1 extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8676152794032188486L;

	/**
	 * Creates a new demo.
	 *
	 * @param title
	 *              the frame title.
	 */
	public BarChart3DDemo1(final String title) {

		super(title);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);

		// add the chart to a panel...
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}

	/**
	 * Creates a sample dataset.
	 *
	 * @return a sample dataset.
	 */
	private CategoryDataset createDataset() {

		final double[][] data = new double[][] { { 10.0, 4.0, 15.0, 14.0 },
		            { -5.0, -7.0, 14.0, -3.0 }, { 6.0, 17.0, -12.0, 7.0 },
		            { 7.0, 15.0, 11.0, 0.0 }, { -8.0, -6.0, 10.0, -9.0 },
		            { 9.0, 8.0, 0.0, 6.0 }, { -10.0, 9.0, 7.0, 7.0 }, { 11.0, 13.0, 9.0, 9.0 },
		            { -3.0, 7.0, 11.0, -10.0 } };

		return DatasetUtilities.createCategoryDataset("Series ", "Category ", data);

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *              the dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart3D("3D Bar Chart Demo", // chart
		                                                                            // title
		            "Category", // domain axis label
		            "Value", // range axis label
		            dataset, // data
		            PlotOrientation.VERTICAL, // orientation
		            true, // include legend
		            true, // tooltips
		            false // urls
		            );

		final CategoryPlot plot = chart.getCategoryPlot();
		final CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions
		            .createUpRotationLabelPositions(Math.PI / 8.0));
		final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
		renderer.setDrawBarOutline(false);

		return chart;

	}

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is
	// available *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please
	// *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *              ignored.
	 */
	public static void main(final String[] args) {

		final BarChart3DDemo1 demo = new BarChart3DDemo1("3D Bar Chart Demo 1");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
