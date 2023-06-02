package AtmInterface;

import java.util.*;
public class ATMInterface 
{
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash)
    {
        balance=balance+dcash;
    }
    static void showbalance()
    {
        System.out.println(balance);
    }
    public static void homepage()
    {
    
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }
    static void optionMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME "+ATMInterface.name+"! TO ATM SYSTEM");
        System.out.println("--------------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}

class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATMInterface.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATMInterface.accnumber=sc.nextLine();
        System.out.println("REGISTRATION DONE SUCCESSFULLY !");
        System.out.println("---------------------------");
        ATMInterface.optionMenu(); 
    }
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATMInterface.balance){
            ATMInterface.balance=ATMInterface.balance-wcash;
            ATMInterface.history.add(Integer.toString(wcash));
            ATMInterface.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATMInterface.optionMenu();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATMInterface.updatebalance(dcash);
        ATMInterface.history.add(Integer.toString(dcash));
        ATMInterface.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATMInterface.optionMenu();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiver name:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiver:");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATMInterface.balance){
            ATMInterface.balance=ATMInterface.balance-tcash;
            ATMInterface.history.add(Integer.toString(tcash));
            ATMInterface.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("Insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATMInterface.showbalance();
        System.out.println("---------------------------");
        ATMInterface.optionMenu();
    }
}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(ATMInterface.balance>0){
            for(int i=0;i<(ATMInterface.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATMInterface.history.get(k)+" ");
                    k++;
                }
                System.out.println("---------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATMInterface.optionMenu();
    }
}
