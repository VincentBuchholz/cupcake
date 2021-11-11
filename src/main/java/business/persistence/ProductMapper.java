package business.persistence;


import business.entities.Product;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class ProductMapper {
    private Database database;

    public ProductMapper(Database database) {
        this.database = database;
    }

    public void createProduct(Product product) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO products (topping_id, bottom_id, price, amount) VALUES (?, ?, ?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

                ps.setInt(1, product.getToppingID());
                ps.setInt(2, product.getBottomID());
                ps.setDouble(3, product.getPrice());
                ps.setInt(4, product.getAmount());


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                product.setId(id);
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

    public void removeFromProducts(int id) throws UserException
    {

        try (Connection connection = database.connect())
        {
            String sql = "DELETE FROM products WHERE id = '"+id+"'";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
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
