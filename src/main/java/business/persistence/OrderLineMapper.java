package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

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

}
