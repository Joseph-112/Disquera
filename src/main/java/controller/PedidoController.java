/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.DAOSale;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pojo.Sale;

/**
 *
 * @author Joseph
 */
@Named(value = "pedidoController")
@RequestScoped
public class PedidoController {

    private List<Sale> orderList;
    private BarChartModel barModel;
    private Sale order;

    /**
     * Creates a new instance of PedidoController
     */
    public PedidoController() {

    }

    @PostConstruct
    public void init() {
        orderList = new DAOSale().saleListSong();
        createBarModels();
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Canciones más vendidas");
        barModel.setLegendPosition("ne");
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Canciones");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries songs = new ChartSeries();
        songs.setLabel("Canciones");
        List<Sale> saleList = new DAOSale().saleListSongCount();
        for (Sale sale : saleList) {
            songs.set(sale.getSongName(), sale.getCount());
        }
        /*songs.set("2004", 52);
        songs.set("2005", 60);
        songs.set("2006", 110);
        songs.set("2007", 135);
        songs.set("2008", 120);*/

        model.addSeries(songs);

        return model;
    }

    public List<Sale> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Sale> orderList) {
        this.orderList = orderList;
    }

    public Sale getOrder() {
        return order;
    }

    public void setOrder(Sale order) {
        this.order = order;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

}
