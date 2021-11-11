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


    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
        userMapper = new UserMapper(database);
        orderMapper = new OrderMapper(database);
        cartMapper = new CartMapper(database);
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
}
