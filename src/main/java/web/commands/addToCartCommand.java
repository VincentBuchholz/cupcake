package web.commands;

import business.entities.Bottom;
import business.entities.Product;
import business.entities.Topping;
import business.entities.User;
import business.exceptions.UserException;
import business.services.LogicFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class addToCartCommand extends CommandProtectedPage{
    LogicFacade logicFacade;
    List<Bottom> bottomList;
    List<Topping> toppingList;
    public addToCartCommand(String pageToShow, String role) {
        super(pageToShow, role);
        logicFacade = new LogicFacade(FrontController.database);
        bottomList = null;
        toppingList = null;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int bottomID = Integer.parseInt(request.getParameter("selectBottom"));
        int toppingID = Integer.parseInt(request.getParameter("selectTopping"));
        System.out.println("topping id: " + toppingID);
        int amount = Integer.parseInt(request.getParameter("amount"));
        System.out.println("amount: " + amount);
        int userID = Integer.parseInt(request.getParameter("user"));
        System.out.println("userID: " + userID);

        if(bottomList == null){
            try {
                bottomList = logicFacade.getAllBottoms();
                toppingList = logicFacade.getAllToppings();
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
            double price = 0;

        for (Bottom bottom : bottomList) {

            if(bottom.getId() == bottomID){
                price = bottom.getPrice()*amount;
            }
        }

        for (Topping topping : toppingList) {
            if (topping.getId() == toppingID){
                price += topping.getPrice()*amount;
            }
        }

        System.out.println("price: " + price);


        Product product = new Product(toppingID,bottomID,amount,price);


        try {
            logicFacade.createProduct(product);

           logicFacade.addToCart(userID,product);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return "customerpage";
    }
}
