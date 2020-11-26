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
import pojo.Sale;

/**
 *
 * @author Joseph
 */
@Named(value = "pedidoController")
@RequestScoped
public class PedidoController {

    private List<Sale> orderList;
    private Sale order;
    
    /**
     * Creates a new instance of PedidoController
     */
    public PedidoController() {
    }
    
    @PostConstruct
    public void init() {
        orderList = new DAOSale().saleList();
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
    
}
