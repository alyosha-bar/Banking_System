
public class Customer {

    private String username;
    private String password;
    //possible PIN

    private int bank_balance;

    Customer(){

    }

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBank_balance() {
        return bank_balance;
    }

    public void setBank_balance(int bank_balance) {
        this.bank_balance = bank_balance;
    }

    public void changeBank_balance(int increment) {
        this.bank_balance = this.bank_balance + increment;
    }



}
