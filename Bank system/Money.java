public class Money {

    private double balance = 0.0;

    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public void depositMoney(double depositAmount){
        
        balance += depositAmount;
        System.out.println("You have deposit " +depositAmount +" to your account." + "\n" +
                "Balance is now: " +balance);

    }
    
    public void withdrawMoney(double withdrawalAmount){
        if(balance < withdrawalAmount) {
            System.out.println("You don't have enough funds.");
        } else {
            balance -= withdrawalAmount;
            System.out.println("You have withdrawal " +withdrawalAmount + " from your account." + "\n" +
                        "Balance is now: " + balance);
        }
    }
    
    public void transferMoney(Account toAccount, double amount){
        if(getBalance() > 0) {
            toAccount.money.setBalance(toAccount.money.balance += amount);
            balance -= amount;
        } else {
            System.out.println("You don't have enough funds");
        }
    }


    
}
