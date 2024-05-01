package com.audit.customer.dataAnalytics;

import com.audit.customer.*;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartExample extends JFrame {  
	  private static final long serialVersionUID = 6294689542092367723L;  
	  
	  public PieChartExample(String title) {  
	    super(title);  
	  
	    // Create dataset  
	    PieDataset dataset = createDataset();  
	  
	    // Create chart  
	    JFreeChart chart = ChartFactory.createPieChart(  
	        "Pie Chart Example",  
	        dataset,  
	        true,   
	        true,  
	        false);  
	  
	    //Format Label  
	    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
	        "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
	   ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
	      
	    // Create Panel  
	    ChartPanel panel = new ChartPanel(chart);  
	    setContentPane(panel);  
	  }  
	  
	  private PieDataset createDataset() {  
	  
	    DefaultPieDataset dataset=new DefaultPieDataset(); 
            
	    dataset.setValue("80-100", 120);  
	    dataset.setValue("60-79", 80);  
	    dataset.setValue("40-59", 20);  
	    dataset.setValue("20-39", 7);  
	    dataset.setValue("0-19", 3);  
            
	    return dataset;  
	  }  
}