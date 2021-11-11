package business.persistence;

import business.entities.Cart;
import business.entities.Order;
import business.entities.Product;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartMapper {
    private Database database;

    public CartMapper(Database database) {
        this.database = database;
    }

    public List<Cart> getCustomerCartItems(int customerID) throws UserException {
        List<Cart> cartList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cart_view WHERE user_id='"+customerID+"'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (cartList == null) {
                        cartList = new ArrayList<>();
                    }

                    int id = rs.getInt("id");
                    int userID = rs.getInt("user_id");
                    int productID = rs.getInt("product_id");
                    double price = rs.getDouble("price");
                    int amount = rs.getInt("amount");
                    String toppingName = rs.getString("topping_name");
                    String bottomName = rs.getString("bottom_name");
                    Cart cart = new Cart(id, userID,productID,price,amount,toppingName,bottomName);
                    cartList.add(cart);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return cartList;
    }

    public void addToCart(int userID, Product product) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO cart (user_id, product_id) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, userID);
                ps.setInt(2, product.getId());

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

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

    public void removeFromCart(int id) throws UserException
    {

        try (Connection connection = database.connect())
        {
            String sql = "DELETE FROM cart WHERE id = '"+id+"'";

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
