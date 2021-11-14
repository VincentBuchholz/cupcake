package business.services;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.*;

import java.util.List;

public class LogicFacade {
    private BottomMapper bottomMapper;
    private ToppingMapper toppingMapper;
    private UserMapper userMapper;
    private OrderMapper orderMapper;
    private CartMapper cartMapper;
    private ProductMapper productMapper;
    private OrderLineMapper orderLineMapper;


    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
        userMapper = new UserMapper(database);
        orderMapper = new OrderMapper(database);
        cartMapper = new CartMapper(database);
        productMapper = new ProductMapper(database);
        orderLineMapper = new OrderLineMapper(database);
    }

    public  List<Bottom> getAllBottoms() throws UserException {
        return bottomMapper.getAllBottoms();
    }

    public  List<Topping> getAllToppings() throws UserException {
        return toppingMapper.getAllToppings();
    }

    public List<User> getAllCustomers() throws UserException {
        return userMapper.getAllCustomers();
    }
    public List<Order> getAllOrders() throws UserException {
        return orderMapper.getAllOrders();
    }

    public List<Order> getAllCustomerOrders(int id) throws UserException {
        return orderMapper.getAllCustomerOrders(id);
    }
    public List<Cart> getCustomerCartItems(int id) throws UserException {
        return cartMapper.getCustomerCartItems(id);
    }

    public void createProduct(Product product) throws UserException {

        productMapper.createProduct(product);
    }

    public void addToCart(int userID, Product product) throws UserException {
        cartMapper.addToCart(userID,product);
    }

    public void removeFromCart(int id) throws UserException {
        cartMapper.removeFromCart(id);
    }


    public void removeFromProducts(int id) throws UserException {
        productMapper.removeFromProducts(id);
    }
    public Double getCustomerCartTotalPrice(int customerID) throws UserException {
        return cartMapper.getCustomerCartTotalPrice(customerID);
    }

    public int createOrder(int userID) throws UserException {
        return orderMapper.createOrder(userID);
    }

    public void createOrderLine(int orderID, int productID) throws UserException{
        orderLineMapper.createOrderLine(orderID,productID);
    }
    public List<OrderLine> getOrderlines(int orderID) throws UserException {
        return orderLineMapper.getOrderlines(orderID);
    }

    public double getUserBalance(int userID) throws UserException {
         return userMapper.getUserBalance(userID);
    }

    public void updateUserBalance(int userID, double balance) throws UserException{
        userMapper.updateUserBalance(userID,balance);
    }
    public User getUser(int userID) throws UserException {
        return userMapper.getUser(userID);
    }
    public void deleteOrderLine(int orderID) throws UserException {
        orderLineMapper.deleteOrderLine(orderID);
    }

    public void deleteOrder(int id) throws UserException{
        orderMapper.deleteOrder(id);
    }

    public Double getOrderTotalPrice(int orderID) throws UserException {
        return orderMapper.getOrderTotalPrice(orderID);
    }
}
