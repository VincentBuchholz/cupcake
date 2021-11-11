package business.entities;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int userID;
    private Timestamp Date;

    public Order(int id, int userID, Timestamp date) {
        this.id = id;
        this.userID = userID;
        Date = date;
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

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }
}

