public class Account {
private String firstName;
private String lastName;
private static int uid = 0;
private String phoneNumber;
private int id;
Money money = new Money();


public Account(String fName, String lName, String pNumber){
    firstName = fName;
    lastName = lName;
    phoneNumber = pNumber;
    uid++;
    id = uid;
}


public String getFirstName(){
    return firstName + "";
}
public String getLastName(){
    return lastName + "";
}
public int getID(){
    return id;
}
public String getPhoneNumber(){
    return phoneNumber + "";
}
public Money getMoney() {
    return money;
}

@Override
public String toString(){
    return "Name: " + getFirstName() + "\n" +
            "Last name: " +getLastName() +"\n" +
            "Balance: " + money.getBalance() + "\n" +
            "ID: " + getID();
}
}
