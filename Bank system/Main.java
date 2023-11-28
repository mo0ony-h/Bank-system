import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {   
        PrintWriter print = new PrintWriter("Customers.txt");     
        try (Scanner keyboard = new Scanner(System.in)) {
            Bank bank = new Bank();
            boolean exit = false;
            while(!exit) {
                System.out.println("Hello, press: " + "\n" +
                "\r" + "1.Register" + "\n" +
                "\r" + "2.Log in" + "\n" +
                "\r" + "3.Exit");
                int choice = Integer.parseInt(keyboard.next());
                switch (choice) {
                    case 1:
                        bank.registerAccount(print);
                        break;
                    case 2:
                        bank.loginAccount();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            
            e.printStackTrace();
        }
        print.flush();
        print.close();
    }
}
