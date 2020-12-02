package com.blz.code;

import java.util.Scanner;

public class Menu {
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t*BOOK OPERATIONS*" + "\n\n1.Add Contact\t2.Edit Contact"
				+ "\n3.Delete Contact\t4.Add Multiple Contacts" + "\n5.Add AddressBook\t6.Exit");
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
			ContactOperations.addMultipleContacts();
			menu();
		}
		case 5: {
			ContactOperations.addBooks();
			menu();
		}
		case 6: {
			System.exit(0);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}

	}

}
