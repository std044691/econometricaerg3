
package econometrica;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.CountryData;
import model.CountryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author themhz
 */


public class Chart extends ApplicationFrame {
    
  private ArrayList<CountryDataset> countryDatasetList;
  private Oil oil;
  private Gdp gdp;
  
  public Chart(final String title, Oil oil, Gdp gdp) {      
        super(title);
        this.oil = oil;
        this.gdp = gdp;
        this.countryDatasetList = countryDatasetList;
        final String chartTitle = "Dual Axis Demo 2";
        final XYDataset dataset = createDataset1();

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            chartTitle, 
            "Date", 
            "Price Per Unit",
            dataset, 
            true, 
            true, 
            false
        );
        
        final XYPlot plot = chart.getXYPlot();
        final NumberAxis axis2 = new NumberAxis("Secondary");
        axis2.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(1, axis2);
        plot.setDataset(1, createDataset2());
        plot.mapDatasetToRangeAxis(1, 1);
        final XYItemRenderer renderer = plot.getRenderer();
        renderer.setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
        }
        
        final StandardXYItemRenderer renderer2 = new StandardXYItemRenderer();
        renderer2.setSeriesPaint(0, Color.black);
        renderer.setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        plot.setRenderer(1, renderer2);
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    private XYDataset createDataset1() {
                
        final TimeSeries s1 = new TimeSeries("Oil Data ", Month.class);
        
        for(ArrayList<String> oildata: this.oil.getData()){
           CountryData cd = new CountryData();
           
           String[] oilYear = oildata.get(0).split("-");

           System.out.println(oilYear[0] +" "+ oilYear[1] +" "+ oilYear[2]+ " oildata:"+ oildata.get(1));
           s1.add(new Month(Integer.parseInt(oilYear[1]), Integer.parseInt(oilYear[0])), Double.parseDouble(oildata.get(1)));

        }


        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private XYDataset createDataset2() {
        final TimeSeries s2 = new TimeSeries("Gdp Data ", Month.class);
        for(ArrayList<String> gdpdata: this.gdp.getData()){
           CountryData cd = new CountryData();           
           String[] gdpYear = gdpdata.get(0).split("-");
           System.out.println(gdpYear[0] +" "+ gdpYear[1] +" "+ gdpYear[2]+ " oildata:"+ gdpdata.get(1));
           s2.add(new Month(Integer.parseInt(gdpYear[1]), Integer.parseInt(gdpYear[0])), Double.parseDouble(gdpdata.get(1)));
        }

        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s2);

        return dataset;

    }
//    public static void main(final String[] args) {
//
//        final DualAxisDemo2 demo = new DualAxisDemo2("Dual Axis Demo 2");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }
            
}
