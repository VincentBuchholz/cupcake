package business.persistence;

import business.entities.Cart;
import business.entities.Order;
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
}
