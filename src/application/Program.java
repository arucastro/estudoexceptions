package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.LimitException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			sc.nextLine();
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("Updated balance: %.2f%n", account.getBalance());
		}
		catch(LimitException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Error, enter valid value");
		}
		
		sc.close();
	}

}
