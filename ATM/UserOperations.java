package ATM;

import java.util.*;

public class UserOperations {
    AccountOperations acc = new AccountOperations();
    ConsoleColors c = new ConsoleColors();
    public void uoperations() {
        Scanner sc = new Scanner(System.in);
        int viewUid = acc.customerVerification();

        if (viewUid != -1) {
            System.out.println("Choose an operation:");
            System.out.println(c.BLUE+"1. Deposit Amount to the Account"+ c.RESET);
            System.out.println(c.BLUE+"2. Withdraw Amount from the Account"+ c.RESET);
            System.out.println(c.BLUE+"3. Check Balance of the Account"+ c.RESET);
            int option = sc.nextInt();

            switch (option) {
                case 1 -> acc.deposit(viewUid);
                case 2 -> acc.withdraw(viewUid);
                case 3 -> acc.balance(viewUid);
                default -> System.out.println(c.YELLOW+"Enter a valid option."+ c.RESET);
            }
        } else {
            System.out.println(c.RED+"Account verification failed."+ c.RESET);
        }
    }

    public void aoperations() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Verify Admin Details");

        if (!acc.AdminVerification()) return;

        System.out.println(c.BLUE+"Enter the operation to perform as Admin:"+ c.RESET);
        System.out.println(c.BLUE+"1. Create New Account"+ c.RESET);
        System.out.println(c.BLUE+"2. View Account Details"+ c.RESET);
        System.out.println(c.BLUE+"3. Delete the Account"+ c.RESET);

        int option = sc.nextInt();
        switch (option) {
            case 1 -> acc.create(); 
            case 2 -> acc.viewAccountAsAdmin();
            case 3 -> acc.delete();	
            
            default -> System.out.println(c.YELLOW+"Enter a valid option."+c.RESET);
        }
    }
}
