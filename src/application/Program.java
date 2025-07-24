package application;

import entities.Account;
import modelExceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;
        try {
            System.out.print("Enter the account number: ");
            int number = sc.nextInt();
            System.out.print("Enter the account holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Is there an initial deposit [ y / n ]: ");
            Character answer = sc.next().toLowerCase().charAt(0);

            if (answer.equals('n')) {
                account = new Account(number, holder);
            } else {
                System.out.print("Enter the initial deposit value: ");
                account = new Account(number, holder, sc.nextDouble());
            }
            System.out.println();
            System.out.println("Account data: \n" + account);
            System.out.print("Enter a deposit value: ");
            double depositValue = sc.nextDouble();
            account.deposit(depositValue);

            System.out.println();
            System.out.println("Updated account data: ");
            System.out.println(account);
            System.out.print("Enter a withdraw value: ");
            double withdrawValue = sc.nextDouble();
            account.withdraw(withdrawValue);

            System.out.println();
            System.out.println("Updated account data: ");
            System.out.println(account);

        } catch (DomainException e) {
            System.out.println("Erro ao tentar realizar saque: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("unexpected error: ");
        }


        sc.close();

    }
}
