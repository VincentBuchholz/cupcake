package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewCustomerInfoCommand extends CommandProtectedPage {
    LogicFacade logicFacade;

    public ViewCustomerInfoCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade=new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user=null;
        try {
           user= logicFacade.getUser(Integer.parseInt(request.getParameter("customerID")));
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
