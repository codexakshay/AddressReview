package com.blz.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewBook {
	static Map<String, NewBook> addressBookObj = new HashMap();
	static NewBook addressobj = new NewBook();
	static Scanner sc = new Scanner(System.in);

	public static void addAddressBook() {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"Enter choice \n1.Create new addressbook " + "\n2.Add contacts into existing address Book \n3.Exit ");
		int entry = input.nextInt();
		if (entry != 3) {
			switch (entry) {
			case 1:
				Scanner nameInput = new Scanner(System.in);
				System.out.println("Enter name of new address book: ");
				String nameOfNewBook = nameInput.nextLine();
				if (addressBookObj.containsKey(nameOfNewBook)) {
					System.out.println("Address book already exists");
					break;
				}
				addressBookObj.put(nameOfNewBook, addressobj);
				System.out.println("Address book " + nameOfNewBook + " has been added");
				NewBook.entries();
				break;
			case 2:
				Scanner existingAddressName = new Scanner(System.in);
				System.out.println("Enter name of address book: ");
				String nameOfExistingAddressBook = existingAddressName.nextLine();
				if (addressBookObj.containsKey(nameOfExistingAddressBook)) {
					addressBookObj.get(nameOfExistingAddressBook);
					NewBook.entries();
				} else {
					System.out.println("Address book not found!!");
				}
			case 3:
				entry = 3;
				break;
			default:
				System.out.println(" Enter valid Input");
				break;
			}
		}
	}

	public static void entries() {
		int choice;
		System.out.println("Welcome to Address Book");

		do {
			System.out.println("1.Add Contact \n2.Edit Existing Contact \n3.Delete Contact "
					+ "\n4.Add Multiple Contacts \n5.Search By City or State \n6.View By City or State \n7.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ContactOperations.addContact();
				break;
			case 2:
				if (!ContactOperations.ContactList.isEmpty())
					ContactOperations.editContact();
				else
					System.out.println("Address Book is empty");
				break;
			case 3:
				if (!ContactOperations.ContactList.isEmpty())
					ContactOperations.deleteContact();
				else
					System.out.println("Address Book is empty");
				break;
			case 4:
				ContactOperations.addMultipleContacts();
				break;
			case 5:
				if (!ContactOperations.ContactList.isEmpty()) {
					System.out.println("1)Search By City   2)Search By State");
					int ch = sc.nextInt();
					if (ch == 1) {
						ContactOperations.searchByCity();
					} else if (ch == 2) {
						ContactOperations.searchByState();
					} else {
						System.out.println("Choose correct option");
					}
				} else {
					System.out.println("Address book is empty");
				}
				break;
			case 6:
				if (!ContactOperations.ContactList.isEmpty()) {
					System.out.println("1)View By City   2)View By State");
					int ch = sc.nextInt();
					if (ch == 1) {
						ContactOperations.viewByCity();
					} else if (ch == 2) {
						ContactOperations.viewByState();
					} else {
						System.out.println("Choose correct option");
					}
				} else {
					System.out.println("Address book is empty");
				}
				break;
			case 7:
				System.out.println("Exited to main menu!!");
				Menu.menu();
			default:
				System.out.println("Choose correct option from above mentioned option only!!");
				break;
			}
		} while (choice != 7);
	}
}
