package web.commands;

import business.entities.Cart;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class removeFromCartCommand extends CommandProtectedPage {

    LogicFacade logicFacade;
    List<Cart> cartList;

    public removeFromCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade = new LogicFacade(database);
        cartList = null;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemID"));
        int userID = Integer.parseInt(request.getParameter("userID"));


        if (cartList == null) {
            try {
                cartList = logicFacade.getCustomerCartItems(userID);
            } catch (UserException e) {
                e.printStackTrace();
            }
        }

        int productId = 0;

        for (Cart cart : cartList) {
            if (cart.getId() == cartItemId) {
                productId = cart.getProductID();
            }
            try {
                logicFacade.removeFromProducts(productId);
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
        try {
            logicFacade.removeFromCart(cartItemId);
        } catch (UserException e) {
            e.printStackTrace();
        }

        System.out.println("product id: " + productId);
        return "cart";
    }
}
