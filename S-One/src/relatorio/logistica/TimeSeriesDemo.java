package relatorio.logistica;

import java.awt.Color;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

/**
 * An example of a time series chart. For the most part, default settings are
 * used, except that the renderer is modified to show filled shapes (as well as
 * lines) at each data point.
 *
 */
public class TimeSeriesDemo extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4138275958483265447L;

	/**
	 * A demonstration application showing how to create a simple time series
	 * chart. This example uses monthly data.
	 *
	 * @param title
	 *              the frame title.
	 */
	public TimeSeriesDemo(final String title) {

		super(title);
		final XYDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		chartPanel.setMouseZoomable(true, false);
		setContentPane(chartPanel);

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *              a dataset.
	 * 
	 * @return A chart.
	 */
	@SuppressWarnings("deprecation")
	private JFreeChart createChart(final XYDataset dataset) {

		final JFreeChart chart = ChartFactory.createTimeSeriesChart(
		            "Legal & General Unit Trust Prices", "Date", "Price Per Unit", dataset,
		            true, true, false);

		chart.setBackgroundPaint(Color.white);

		// final StandardLegend sl = (StandardLegend) chart.getLegend();
		// sl.setDisplaySeriesShapes(true);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0,
		// 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		final XYItemRenderer renderer = plot.getRenderer();
		if (renderer instanceof StandardXYItemRenderer) {
			final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
			rr.setPlotImages(true);
			rr.setShapesFilled(true);
			rr.setItemLabelsVisible(true);
		}

		final DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

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
	 * Creates a dataset, consisting of two series of monthly data.
	 *
	 * @return the dataset.
	 */
	@SuppressWarnings("deprecation")
	private XYDataset createDataset() {

		final TimeSeries s1 = new TimeSeries("L&G European Index Trust", Month.class);
		s1.add(new Month(2, 2001), 181.8);
		s1.add(new Month(3, 2001), 167.3);
		s1.add(new Month(4, 2001), 153.8);
		s1.add(new Month(5, 2001), 167.6);
		s1.add(new Month(6, 2001), 158.8);
		s1.add(new Month(7, 2001), 148.3);
		s1.add(new Month(8, 2001), 153.9);
		s1.add(new Month(9, 2001), 142.7);
		s1.add(new Month(10, 2001), 123.2);
		s1.add(new Month(11, 2001), 131.8);
		s1.add(new Month(12, 2001), 139.6);
		s1.add(new Month(1, 2002), 142.9);
		s1.add(new Month(2, 2002), 138.7);
		s1.add(new Month(3, 2002), 137.3);
		s1.add(new Month(4, 2002), 143.9);
		s1.add(new Month(5, 2002), 139.8);
		s1.add(new Month(6, 2002), 137.0);
		s1.add(new Month(7, 2002), 132.8);

		final TimeSeries s2 = new TimeSeries("L&G UK Index Trust", Month.class);
		s2.add(new Month(2, 2001), 129.6);
		s2.add(new Month(3, 2001), 123.2);
		s2.add(new Month(4, 2001), 117.2);
		s2.add(new Month(5, 2001), 124.1);
		s2.add(new Month(6, 2001), 122.6);
		s2.add(new Month(7, 2001), 119.2);
		s2.add(new Month(8, 2001), 116.5);
		s2.add(new Month(9, 2001), 112.7);
		s2.add(new Month(10, 2001), 101.5);
		s2.add(new Month(11, 2001), 106.1);
		s2.add(new Month(12, 2001), 110.3);
		s2.add(new Month(1, 2002), 111.7);
		s2.add(new Month(2, 2002), 111.0);
		s2.add(new Month(3, 2002), 109.6);
		s2.add(new Month(4, 2002), 113.2);
		s2.add(new Month(5, 2002), 111.6);
		s2.add(new Month(6, 2002), 108.8);
		s2.add(new Month(7, 2002), 101.6);

		final TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		dataset.addSeries(s2);

		dataset.setDomainIsPointsInTime(true);

		return dataset;

	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *              ignored.
	 */
	public static void main(final String[] args) {

		Log.getInstance().addTarget(new PrintStreamLogTarget());
		final TimeSeriesDemo demo = new TimeSeriesDemo("Time Series Demo 1");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
