package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;
import business.util.Initializer;

public class UserFacade
{
    UserMapper userMapper;
    Initializer initializer = new Initializer();

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password,String firstName,String lastName) throws UserException
    {
        User user = new User(email, password, "customer",firstName,lastName);
        userMapper.createUser(user);
        initializer.initCustomerList();
        return user;
    }

}
