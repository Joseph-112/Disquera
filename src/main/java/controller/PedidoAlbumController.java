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
@Named(value = "pedidoAlbumController")
@RequestScoped
public class PedidoAlbumController {

    private List<Sale> orderList;
    private BarChartModel barModel;
    private Sale order;

    /**
     * Creates a new instance of PedidoAlbumController
     */
    public PedidoAlbumController() {
    }

    @PostConstruct
    public void init() {
        orderList = new DAOSale().saleListAlbum();
        createBarModels();
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Albums más vendidas");
        barModel.setLegendPosition("ne");
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Album");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries albums = new ChartSeries();
        albums.setLabel("Albums");
        List<Sale> saleList = new DAOSale().saleLisAlbumCount();
        for (Sale sale : saleList) {
            albums.set(sale.getAlbumName(), sale.getCount());
        }
        /*songs.set("2004", 52);
        songs.set("2005", 60);
        songs.set("2006", 110);
        songs.set("2007", 135);
        songs.set("2008", 120);*/

        model.addSeries(albums);

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
