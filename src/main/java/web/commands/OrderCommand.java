package web.commands;

import business.entities.Cart;
import business.exceptions.UserException;
import business.services.LogicFacade;
import com.mysql.cj.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderCommand extends CommandProtectedPage {

    LogicFacade logicFacade;
    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade = new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int orderID = 0;
        try {
           orderID =  logicFacade.createOrder(Integer.parseInt(request.getParameter("userID")));
        } catch (UserException e) {
            e.printStackTrace();
        }
        List<Cart> cartList = null;
        try {
            cartList = logicFacade.getCustomerCartItems(Integer.parseInt(request.getParameter("userID")));
        } catch (UserException e) {
            e.printStackTrace();
        }

        for (Cart cart : cartList) {
            try {
                logicFacade.createOrderLine(orderID,cart.getProductID());
                logicFacade.removeFromCart(cart.getId());
            } catch (UserException e) {
                e.printStackTrace();
            }
        }



        request.setAttribute("orderID",orderID);

        return "orderedpage";
    }
}
