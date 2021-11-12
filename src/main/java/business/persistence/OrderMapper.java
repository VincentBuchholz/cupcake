package business.persistence;

import business.entities.Bottom;
import business.entities.Order;
import business.entities.Product;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = null;


        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (orderList == null) {
                        orderList = new ArrayList<>();
                    }

                    int id = rs.getInt("id");
                    int userID = rs.getInt("user_id");
                    Timestamp date = rs.getTimestamp("created");
                    Order order = new Order(id, userID, date);
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return orderList;
    }
    public List<Order> getAllCustomerOrders(int customerID) throws UserException {
        List<Order> customerOrderList = null;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id = '"+customerID+"'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (customerOrderList == null) {
                        customerOrderList = new ArrayList<>();
                    }
                    int id = rs.getInt("id");
                    int userID = rs.getInt("user_id");
                    Timestamp date = rs.getTimestamp("created");
                    Order order = new Order(id, userID, date);
                    customerOrderList.add(order);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return customerOrderList;
    }
    public int createOrder(int userID) throws UserException
    {
        int orderID = 0;
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders (user_id) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, userID);


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderID = ids.getInt(1);
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
        return orderID;
    }

    public void deleteOrder(int id) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM orders WHERE id = '" + id + "'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
