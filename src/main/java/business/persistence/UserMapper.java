package business.persistence;

import business.entities.Bottom;
import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO users (email, password, role,first_name,last_name) VALUES (?, ?, ?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.setString(4, user.getFirstName());
                ps.setString(5, user.getLastName());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role,first_name,last_name,balance FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    int id = rs.getInt("id");
                    double balance = rs.getDouble("balance");

                    User user = new User(email, password, role,firstName,lastName,balance);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<User> getAllCustomers() throws UserException {
        List<User> customerList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM users WHERE role = 'customer'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (customerList == null) {
                        customerList = new ArrayList<>();
                    }

                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    double balance = rs.getDouble("balance");

                    User user = new User(email, password,role,firstName,lastName,balance);
                    user.setId(id);
                    customerList.add(user);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return customerList;
    }

}
