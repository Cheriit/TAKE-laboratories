/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.take.PrimeFaces.view.backing;

import static java.lang.Math.sin;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author cherit
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {

    private LineChartModel lineChart;
    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        lineChart = new LineChartModel();
        LineChartSeries s = new LineChartSeries();
        for(int i=0; i<360; i++) {
            s.set(i, sin(i));
        }
        lineChart.addSeries(s);
        lineChart.setLegendPosition("e");
        Axis y = lineChart.getAxis(AxisType.Y);
        y.setMin(-1.2);
        y.setMax(1.2);
        y.setLabel("Sinus value");
        
        Axis x = lineChart.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("15");
        x.setLabel("Degrees");
    }

    /**
     * @return the lineChart
     */
    public LineChartModel getLineChart() {
        return lineChart;
    }

    /**
     * @param lineChart the lineChart to set
     */
    public void setLineChart(LineChartModel lineChart) {
        this.lineChart = lineChart;
    }
    
}
