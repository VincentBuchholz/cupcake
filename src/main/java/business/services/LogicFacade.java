package business.services;

import business.entities.Bottom;
import business.entities.Topping;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.BottomMapper;
import business.persistence.Database;
import business.persistence.ToppingMapper;
import business.persistence.UserMapper;

import java.util.List;

public class LogicFacade {
    private BottomMapper bottomMapper;
    private ToppingMapper toppingMapper;
    private UserMapper userMapper;


    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
        userMapper = new UserMapper(database);
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
}
