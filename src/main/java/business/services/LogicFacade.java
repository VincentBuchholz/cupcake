package business.services;

import business.entities.Bottom;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.BottomMapper;
import business.persistence.Database;
import business.persistence.ToppingMapper;
import business.persistence.UserMapper;

import java.util.List;

public class LogicFacade {
    private BottomMapper bottomMapper;
    private ToppingMapper toppingMapper;


    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
    }

    public  List<Bottom> getAllBottoms() throws UserException {
        return bottomMapper.getAllBottoms();
    }

    public  List<Topping> getAllToppings() throws UserException {
        return toppingMapper.getAllToppings();
    }
}
