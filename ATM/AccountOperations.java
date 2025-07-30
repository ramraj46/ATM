package ATM;

import java.util.*;

public class AccountOperations {
    AccountDetails accs[] = new AccountDetails[10];
    int index = 0;
    ConsoleColors c = new ConsoleColors();
    public void create() {
        Scanner sc = new Scanner(System.in);

        System.out.println(c.BLUE+"Enter your User ID (only numbers): "+c.RESET);
        int uid = sc.nextInt();
        sc.nextLine();

        System.out.println(c.BLUE+"Enter your Username: "+c.RESET);
        String username = sc.nextLine();

        System.out.println(c.BLUE+"Enter your Location: "+c.RESET);
        String location = sc.nextLine();

        System.out.println(c.BLUE+"Enter your Account Number: "+c.RESET);
        double accountNumber = sc.nextDouble();

        AccountDetails a = new AccountDetails(uid, username, location, accountNumber);

        while (true) {
            System.out.println(c.BLUE+"Enter your PIN (must be 4 or more digits): "+c.RESET);
            int pin = sc.nextInt();
            if (pin > 999) {
                a.setPin(pin);
                break;
            }
        }

        while (true) {
            System.out.println(c.BLUE+"Enter the balance (only multiples of 100 allowed): "+c.RESET);
            double balance = sc.nextDouble();
            if ((balance >= 0) && (balance % 100 == 0)) {
                a.setBalance(balance);
                break;
            }
        }

        accs[index++] = a;
        System.out.println(c.GREEN+"Account has been created successfully!\n"+c.RESET);
    }

    public int customerVerification() {
        Scanner sv = new Scanner(System.in);
        System.out.println(c.BLUE+"Enter the User ID:"+c.RESET);
        int viewUid = sv.nextInt();
        System.out.println(c.BLUE+"Enter the PIN:"+c.RESET);
        int viewPin = sv.nextInt();

        for (int i = 0; i < index; i++) {
            AccountDetails acc = accs[i];
            if (acc.getUid() == viewUid && acc.getPin() == viewPin) {
                System.out.println(c.GREEN+"Account Verified."+c.RESET);
                return viewUid;
            }
        }

        System.out.println(c.RED+"Account Not Found. Kindly Check your Details."+c.RESET);
        return -1;
    }

    public void viewAccountAsAdmin() {
        Scanner sa = new Scanner(System.in);
        System.out.println(c.BLUE+"Enter the User ID:"+c.RESET);
        int viewUid = sa.nextInt();
        boolean flag = true;

        for (int i = 0; i < index; i++) {
            AccountDetails acc = accs[i];
            if (acc.getUid() == viewUid) {
                System.out.println("Account Details: ");
                System.out.println(c.BLUE+acc+c.RESET);
                flag = false;
            }
        }

        if (flag) {
            System.out.println(c.YELLOW+"Account Not Found, Kindly Check your Details."+c.RESET);
        }
    }

    public boolean AdminVerification() {
        Scanner sv = new Scanner(System.in);
        System.out.println(c.BLUE+"Enter the Admin ID:"+c.RESET);
        int viewUid = sv.nextInt();
        System.out.println(c.BLUE+"Enter the Admin PIN:"+c.RESET);
        int viewPin = sv.nextInt();

        int apin = 1234;
        int aid = 1234;

        if (viewUid == aid && viewPin == apin) {
            System.out.println(c.GREEN+"Verified as Admin User"+c.RESET);
            return true;
        } else {
            System.out.println(c.RED+"Invalid Admin Credentials"+c.RESET);
            return false;
        }
    }

    public void withdraw(int viewUid) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < index; i++) {
            AccountDetails acc = accs[i];
            if (acc.getUid() == viewUid) {
                System.out.println(c.BLUE+"Enter amount to withdraw (multiples of 100): "+c.RESET);
                double amt = sc.nextDouble();
                if (amt % 100 == 0 && amt <= acc.getBalance()) {
                    acc.setBalance(acc.getBalance() - amt);
                    System.out.println(c.GREEN+"Withdrawal successful. Remaining Balance: " + acc.getBalance()+c.RESET);
                } else {
                    System.out.println(c.YELLOW+"Invalid amount or insufficient balance."+c.RESET);
                }
                return;
            }
        }
    }

    public void deposit(int viewUid) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < index; i++) {
            AccountDetails acc = accs[i];
            if (acc.getUid() == viewUid) {
                System.out.println(c.BLUE+"Enter amount to deposit (multiples of 100): "+c.RESET);
                double amt = sc.nextDouble();
                if (amt % 100 == 0 && amt > 0) {
                    acc.setBalance(acc.getBalance() + amt);
                    System.out.println(c.GREEN+"Deposit successful. New Balance: " + acc.getBalance()+c.RESET);
                } else {
                    System.out.println(c.RED+"Invalid deposit amount."+c.RESET);
                }
                return;
            }
        }
    }

    public void balance(int viewUid) {
        for (int i = 0; i < index; i++) {
            AccountDetails acc = accs[i];
            if (acc.getUid() == viewUid) {
                System.out.println(c.GREEN+"Account Balance: " + acc.getBalance()+c.RESET);
                return;
            }
        }
    }
    
    public void delete() {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println(c.BLUE+"Enter the user id to delete the account"+c.RESET);
        int uid = sc.nextInt();

        for (int i = 0; i < index; i++) {
            if (accs[i].getUid() == uid) {
                // Shift accounts left
                for (int j = i; j < index - 1; j++) {
                    accs[j] = accs[j + 1];
                }
                accs[index - 1] = null; // Clear the last account after shift
                index--; // Decrease the index as we removed an account
                found = true;
                System.out.println(c.GREEN+"Account deleted successfully."+c.RESET);
                break;
            }
        }

        if (!found) {
            System.out.println(c.RED+"Account not found."+c.RESET);
        }
    }

}
