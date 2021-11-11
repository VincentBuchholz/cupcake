package business.entities;

public class Cart {
    private int id;
    private int userID;
    private int productID;
    private double price;
    private int amount;
    private String toppingName;
    private String bottomName;

    public Cart(int id, int userID, int productID, double price, int amount, String toppingName, String bottomName) {
        this.id = id;
        this.userID = userID;
        this.productID = productID;
        this.price = price;
        this.amount = amount;
        this.toppingName = toppingName;
        this.bottomName = bottomName;
    }

    public Cart(int id, int userID, int productID) {
        this.id = id;
        this.userID = userID;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }
}

