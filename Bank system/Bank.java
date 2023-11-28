import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank { 

private final List<Account> bankAccounts;


public Bank() throws FileNotFoundException {
    bankAccounts = new ArrayList<>();
    try (Scanner keyboard = new Scanner(System.in)) {
    }
}

public Account exist(int accountID, String phoneNumber) {
    for (Account account : bankAccounts) {
        if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
            return account;
        }
    }
    System.out.println("One of the details is incorrect");
    return null;
}

//overload method -
public Account exist(String phoneNumber) {
    for (Account account : bankAccounts) {
        if (account.getPhoneNumber().equals(phoneNumber)) {
            return account;
        }
    }
    System.out.println("One of the details is incorrect");
    return null;
}


public void registerAccount(PrintWriter print) {
    try (Scanner keyboard = new Scanner(System.in)) {
        System.out.println("First name?");
        String firstName = keyboard.next();

        System.out.println("Last name?");
        String lastName = keyboard.next();

        System.out.println("Phone number?");
        String phoneNumber = keyboard.next();

        if (PNCorrect(phoneNumber)) {
            bankAccounts.add(new Account(firstName, lastName, phoneNumber));
            System.out.println("You have created account successfully!" + "\n" +
                    "Your account ID is: " + bankAccounts.get(bankAccounts.size() - 1).getID());
            print.print("First name: ");
            print.println(firstName);
            print.print("Last name: ");
            print.println(lastName);
            print.print("Phone number: ");
            print.println(phoneNumber);
            print.print("ID: ");
            print.println(bankAccounts.get(bankAccounts.size() - 1).getID());
            print.println("------------------------------------------------");

        }
    }
}

public void loginAccount() {
    try (Scanner keyboard = new Scanner(System.in)) {
        System.out.println("Please enter your ID:");
        int accountID = keyboard.nextInt();

        System.out.println("Please enter your phone number:");
        String phoneNumber = keyboard.next();

        if (PNCorrect(phoneNumber)) {
            Account myAccount = exist(accountID, phoneNumber);
            Money M = myAccount.getMoney();
            boolean exitRequested = false;

            while (!exitRequested) {
                System.out.println("What would you like to do?" + "\n" +
                    "\r" + "1.Info" + "\n" +
                    "\r" + "2.Deposit money" + "\n" +
                    "\r" + "3.Withdraw money" + "\n" +
                    "\r" + "4.Transferring money " + "\n" +
                    "\r" + "5.Exit");
                int choice = Integer.parseInt(keyboard.next());

                switch (choice) {
                    case 1:
                        System.out.println(myAccount.toString());
                        break;
                    case 2:
                        System.out.println("Please enter deposit amount:");
                        double depositAmount = keyboard.nextDouble();
                        M.depositMoney(depositAmount);
                        break;
                    case 3:
                        System.out.println("Please enter withdrawal amount:");
                        double withdrawalAmount = keyboard.nextDouble();
                        M.withdrawMoney(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Please enter the phone number of the account you want to transfer to: ");
                        String accountPhoneNumber = keyboard.next();

                        if (PNCorrect(accountPhoneNumber)) {
                            Account otherAccount = exist(accountPhoneNumber);

                            System.out.println("Enter the amount of money you would like to transferAmount:");
                            double transferAmount = keyboard.nextDouble();

                            M.transferMoney(otherAccount, transferAmount);
                            break;                        
                        }
                            case 5:
                                exitRequested = true;
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                }
            }
    } catch (NumberFormatException e) {
        
        e.printStackTrace();
    }
    }

public static boolean PNCorrect(String phoneNumber){
    if(phoneNumber.length() != 10){
        System.out.println("Phone number must be 10 digits.");
        return false;

} else {
        return true;
    }
}
}
