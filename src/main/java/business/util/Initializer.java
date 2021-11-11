package business.util;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.LogicFacade;


import java.util.List;

import static web.FrontController.database;


public class Initializer {



    LogicFacade LF = new LogicFacade(database);

    List<Bottom> bottomList = null;
    List<Topping> toppingList = null;
    List<User> customerList = null;
    List<Order> orderList = null;
    List<Cart> cartList = null;
    List<OrderLine> orderLineList=null;

    public void initBottomList(){
        try {
            bottomList = LF.getAllBottoms();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Bottom> getBottomList (){
        if(bottomList == null){
            try {
                bottomList = LF.getAllBottoms();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return bottomList;
    }

    public void initToppingList(){
        try {
            toppingList = LF.getAllToppings();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Topping> getToppingList (){
        if(toppingList == null){
            try {
                toppingList = LF.getAllToppings();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return toppingList;
    }

    public void initCustomerList(){
        try {
            customerList = LF.getAllCustomers();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<User> getCustomerList (){
            try {
                customerList = LF.getAllCustomers();
            } catch (Exception e){
                e.printStackTrace();
            }
        return customerList;
    }

    public void initOrderList(){
        try {
            orderList = LF.getAllOrders();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderList (){
            try {
                orderList = LF.getAllOrders();
            } catch (Exception e){
                e.printStackTrace();
            }
        return orderList;
    }

    public void initCustomerOrderList(int id){
        try {
            orderList = LF.getAllCustomerOrders(id);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getCustomerOrderList (int id){
            try {
                orderList = LF.getAllCustomerOrders(id);
            } catch (Exception e){
                e.printStackTrace();
            }
        return orderList;
    }

    public List<Cart> getCustomerCartItems (int id){
        try {
            cartList = LF.getCustomerCartItems(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return cartList;
    }
    public double getCustomerCartTotalPrice(int customerID){
        double totalPrice=0;
        try {
            totalPrice= LF.getCustomerCartTotalPrice(customerID);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public List<OrderLine> getOrderlines (int orderID){
        try {
            orderLineList = LF.getOrderlines(orderID);
        } catch (Exception e){
            e.printStackTrace();
        }
        return orderLineList;
    }



}
