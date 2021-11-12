package web.commands;

import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBalanceCommand extends CommandProtectedPage {
    LogicFacade logicFacade;

    public UpdateBalanceCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade = new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        double userBalance= Double.parseDouble(request.getParameter("userBalance"));
        int userID= Integer.parseInt(request.getParameter("customerID"));
        System.out.println("USER balance: " +userBalance + " USERID="+userID);
        try {
            logicFacade.updateUserBalance(userID,userBalance);
        } catch (UserException e) {
            e.printStackTrace();
        }

        return "viewcustomerinfopage";
    }
}
