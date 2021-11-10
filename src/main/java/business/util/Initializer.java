package business.util;

import business.entities.Bottom;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.LogicFacade;


import java.util.List;

import static web.FrontController.database;


public class Initializer {



    LogicFacade LF = new LogicFacade(database);

    List<Bottom> bottomList = null;
    List<Topping> toppingList = null;

    public void initBottomList(){
        try {
            bottomList = LF.getAllBottoms();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Bottom> getBottomList (){
        if(bottomList == null){
            try {
                bottomList = LF.getAllBottoms();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return bottomList;
    }

    public void initToppingList(){
        try {
            toppingList = LF.getAllToppings();
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public List<Topping> getToppingList (){
        if(toppingList == null){
            try {
                toppingList = LF.getAllToppings();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return toppingList;
    }

}