package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        deposit(balance);
    }

    public int getNumber() {
        return number;
    }


    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        double tax = 5.0;
        if (amount <= (balance - tax))
            this.balance -= amount + tax;
        else {
            System.out.println(" you don't have money enough");
        }
    }

@Override
    public String toString(){
        return "Account "
                + number
                +", Holder: "
                +holder
                +", Balance: $ "
                +String.format("%.2f", balance);
}
}
