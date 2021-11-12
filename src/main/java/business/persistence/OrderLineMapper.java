package business.persistence;

import business.entities.Cart;
import business.entities.OrderLine;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderLineMapper {
    private Database database;

    public OrderLineMapper(Database database) {
        this.database = database;
    }

    public void createOrderLine(int orderID, int productID) throws UserException
    {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO order_lines (order_id, product_id) VALUES (?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, orderID);
                ps.setInt(2, productID);

                ps.executeUpdate();
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

    public List<OrderLine> getOrderlines(int orderID) throws UserException {
        List<OrderLine> orderLineList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM order_line_overview WHERE order_id='" + orderID + "'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (orderLineList == null) {
                        orderLineList = new ArrayList<>();
                    }

                    int id = rs.getInt("id");
                    int productID = rs.getInt("product_id");
                    double price = rs.getDouble("price");
                    int amount = rs.getInt("amount");
                    String toppingName = rs.getString("topping_name");
                    String bottomName = rs.getString("bottom_name");
                    OrderLine orderLine = new OrderLine(orderID,productID);
                    orderLine.setId(id);
                    orderLine.setPrice(price);
                    orderLine.setAmount(amount);
                    orderLine.setToppingName(toppingName);
                    orderLine.setBottomName(bottomName);
                    orderLineList.add(orderLine);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return orderLineList;
    }

    public void deleteOrderLine(int orderID) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM order_lines WHERE order_id = '" + orderID + "'";

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
