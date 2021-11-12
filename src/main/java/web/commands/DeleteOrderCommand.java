package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderCommand extends CommandProtectedPage{
    LogicFacade logicFacade;
    public DeleteOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade = new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int orderID = 0;
        orderID = Integer.parseInt(request.getParameter("customerOrderID"));
        try {
            logicFacade.deleteOrderLine(orderID);
        } catch (UserException e) {
            e.printStackTrace();
        }
        try {
            logicFacade.deleteOrder(orderID);
        } catch (UserException e) {
            e.printStackTrace();
        }
        String destination = request.getParameter("destination");
        if (destination.equals("vieworderpage")) {
            return "vieworderpage";
        } else {
            User user = null;
            try {
                user = logicFacade.getUser(Integer.parseInt(request.getParameter("customerID")));
            } catch (UserException e) {
                e.printStackTrace();
            }
            request.setAttribute("customerID", user.getId());
            request.setAttribute("customer", user);
            request.setAttribute("customerEmail", user.getEmail());
            request.setAttribute("customerFirstName", user.getFirstName());
            request.setAttribute("customerLastName", user.getLastName());
            request.setAttribute("customerBalance", user.getBalance());
            System.out.println(user.getFirstName());


            return "viewcustomerinfopage";
        }
    }
}
