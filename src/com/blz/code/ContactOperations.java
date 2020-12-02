package com.blz.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactOperations {
	public static List<Contact> ContactList = new ArrayList<Contact>();
	private static String email;

	public static void addContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t*Enter Contact Details*\n");
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter User Email : ");
		String email = sc.next();
		System.out.println("Enter Mobile Number: ");
		String mobileNum = sc.next();
		System.out.println("Enter User State: ");
		String state = sc.next();
		System.out.println("Enter User City: ");
		String city = sc.next();
		System.out.println("Enter User Address : ");
		String address = sc.next();
		System.out.println("Enter zipCode: ");
		String zipCode = sc.next();
		Contact Contact1 = new Contact(firstName, lastName, email, mobileNum, state, city, address, zipCode);
		ContactList.add(Contact1);
		System.out.println("Contact details added successfully");
	}

	public static void editContact() {
		System.out.println("\t*Edit Contact Details*\n");
		Scanner sc = new Scanner(System.in);
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to print");
		} else {
			String address, city, state, mobileNum, zipCode;
			int id;
			for (Contact contact : ContactList) {
				System.out.println("ID " + ContactList.indexOf(contact) + ":\n" + contact);
			}
			System.out.println("Enter ID of contact to edit : ");
			id = sc.nextInt();
			System.out.println(ContactList.get(id));
			System.out
					.print("Please select the option to edit\n1.Address\n2.City\n3.State\n4.zipCode\n5.Mobile Number");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Address: ");
				address = sc.nextLine();
				ContactList.get(id).setAddress(address);
				break;
			case 2:
				System.out.println("Enter City: ");
				city = sc.nextLine();
				ContactList.get(id).setCity(city);
				break;
			case 3:
				System.out.println("Enter State: ");
				state = sc.nextLine();
				ContactList.get(id).setState(state);
				break;
			case 4:
				System.out.println("Enter Zip Code: ");
				zipCode = sc.nextLine();
				ContactList.get(id).setZipCode(zipCode);
				break;
			case 5:
				System.out.println("Enter Mobile Number: ");
				mobileNum = sc.nextLine();
				ContactList.get(id).setMobileNum(mobileNum);
				break;
			default:
				System.out.println("Error!!");
				editContact();
			}
		}
	}

	public static void deleteContact() {
		System.out.println("\t*Delete Contact Details*\n");
		Scanner sc = new Scanner(System.in);
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to delete in the addressbook");
		} else {
			System.out.println("Enter First Name to delete the Contact");
			String firstName = sc.nextLine();
			for (int count = 0; count < ContactList.size(); count++) {
				if (ContactList.get(count).getFirstName().equals(firstName)) {
					ContactList.remove(ContactList.get(count));
				}
			}
		}
	}

	public static void addMultipleContacts() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many contacts you want to add: ");
		int numofContacts = sc.nextInt();
		int createdContacts = 1;
		while (createdContacts <= numofContacts) {
			if (addBooks() == true)
				addContact();
			createdContacts++;
		}
	}

	public static boolean addBooks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Address Book Name :");
		String firstName = sc.next();
		for (int count = 0; count < ContactList.size(); count++) {
			if (ContactList.get(count).getFirstName().equals(firstName)) {
				System.out.println("Already an AddressBook exist with this name");
				return false;
			}
		}
		return true;
	}

	public static boolean searchFirstName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First Name to check Duplicate Entry");
		String name = sc.next();
		boolean result = ContactList.stream().allMatch(n -> n.getFirstName().equals(name));
		if (result == true) {
			System.out.println("Already an AddressBook exist with this name");
			return false;
		} else {
			return true;
		}
	}

	public static void searchByState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User State : ");
		String state = sc.nextLine();
		sc.close();
		ContactList.stream().filter(n -> n.getCity().equals(state)).forEach(n -> System.out.println(n.firstName));
	}

	public static void searchByCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User City : ");
		String city = sc.nextLine();
		sc.close();
		ContactList.stream().filter(n -> n.getCity().equals(city)).forEach(n -> System.out.println(n.firstName));
	}
}
