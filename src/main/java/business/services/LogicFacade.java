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


    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
        userMapper = new UserMapper(database);
        orderMapper = new OrderMapper(database);
        cartMapper = new CartMapper(database);
        productMapper = new ProductMapper(database);
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
}
