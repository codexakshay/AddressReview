package com.blz.code;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t*BOOK OPERATIONS*" + "\n\n1.Add Contact\t\t2.Edit Contact"
				+ "\n3.Delete Contact\t\t4.Add Multiple Contacts" + "" + "\n5.Add AddressBook\t6.Search Name"
				+ "\n7.Search State\t\t\t8.Search City" + "\n9.View By State\t\t10.View By City\n11.Count By State\t\t12.Count By City\n13.Sort By Name\t\t14.Exit");
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
			// Adding Multiple Contacts
			ContactOperations.addMultipleContacts();
			menu();
		}
		case 5: {
			// Adding Address Books
			ContactOperations.addBooks();
			menu();
		}
		case 6: {
			// Adding Search by Name
			ContactOperations.searchFirstName();
			menu();
		}
		case 7: {
			// Searching By State
			ContactOperations.searchByState();
		}
		case 8: {
			// Searching by City
			ContactOperations.searchByCity();
		}
		case 9: {
			// View By State
			ContactOperations.viewByState();
		}
		case 10: {
			// View By City
			ContactOperations.viewByCity();
		}
		case 11: {
			// Count By State
			ContactOperations.countByState();
		}
		case 12: {
			// Count By City
			ContactOperations.countByCity();
		}
		case 13: {
			// Sort Contact By Name
			ContactOperations.sortByName();
		}
		case 14: {
			// Exit from Project
			System.exit(0);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

	}

}
