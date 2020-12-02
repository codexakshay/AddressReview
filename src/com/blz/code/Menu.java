package com.blz.code;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t*BOOK OPERATIONS*" + "\n\n1.Add Contact\t\t2.Edit Contact"
				+ "\n3.Delete Contact\t\t4.Add Multiple Contacts" + "\n5.Add AddressBook\t6.Search Name\n7.Exit");
		System.out.println("\nEnter An Operation :");
		int operation = sc.nextInt();
		switch (operation) {
		case 1: {
			// Adding Contact Details
			ContactOperations.addContact();
			menu();
		}
		case 2: {
			// Editing Contact Details
			ContactOperations.editContact();
			menu();
		}
		case 3: {
			// Delete Contact Details
			ContactOperations.deleteContact();
			menu();
		}
		case 4: {
			//Adding Multiple Contacts
			ContactOperations.addMultipleContacts();
			menu();
		}
		case 5: {
			//Adding Address Books
			ContactOperations.addBooks();
			menu();
		}
		case 6: {
			//Adding Search by Name
			ContactOperations.searchFirstName();
			menu();
		}
		case 7: {
			//Exit from Project
			System.exit(0);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

	}

}
