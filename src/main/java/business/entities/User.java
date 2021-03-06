package business.entities;

public class User
{

    public User(String email, String password, String role,String firstName,String lastName,double balance)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName=firstName;
        this.lastName = lastName;
        this.balance = balance;

    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private String firstName;
    private String lastName;
    private double balance;

    public User(String email, String firstName, String lastName, double balance) {
        this.email=email;
        this.firstName=firstName;
        this.lastName = lastName;
        this.balance = balance;
    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
