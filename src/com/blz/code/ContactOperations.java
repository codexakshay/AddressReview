package com.blz.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactOperations {
	public static List<Contact> ContactList = new ArrayList<Contact>();
	public static String bookName;

	public static void addContact(String bookName) {
		Contact newEntry;
		boolean isExist = false;
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
		if (ContactList.size() > 0) {
			for (Contact details : ContactList) {
				newEntry = details;
				if (firstName.equals(newEntry.firstName) && lastName.equals(newEntry.lastName)) {
					System.out.println("Contact " + newEntry.firstName + " " + newEntry.lastName + " already exists");
					isExist = true;
					break;
				}
			}
		}
		if (!isExist) {
			newEntry = new Contact(firstName, lastName, email, mobileNum, state, city, address, zipCode);
			ContactList.add(newEntry);
			addDataToFile(firstName, lastName, email, mobileNum, state, city, address, zipCode, bookName);
		}
		System.out.println(ContactList);
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
		System.out.println("Enter number of persons to add to Address Book: ");
		Scanner sc = new Scanner(System.in);
		int noOfPersons = sc.nextInt();
		sc.nextLine();
		int count = 1;
		while (count <= noOfPersons) {
			addContact(bookName);
			count++;
		}
	}

	public static void addBooks() {
		NewBook.addAddressBook();
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

	public static void viewByState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter State Name:");
		String state = sc.nextLine();
		ContactList.stream().filter(n -> n.getState().equals(state)).forEach(i -> System.out.println(i));
	}

	public static void viewByCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City Name:");
		String city = sc.nextLine();
		ContactList.stream().filter(n -> n.getCity().equals(city)).forEach(i -> System.out.println(i));
	}

	public static void countByCity() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City Name : ");
		String city = sc.nextLine();
		count = (int) ContactList.stream().filter(n -> n.getCity().equals(city)).count();
		System.out.println(count);
	}

	public static void countByState() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter State Name : ");
		String state = sc.nextLine();
		count = (int) ContactList.stream().filter(n -> n.getState().equals(state)).count();
		System.out.println(count);
	}

	public static void sortByName() {
		ContactList = ContactList.stream().sorted(Comparator.comparing(Contact::getFirstName))
				.collect(Collectors.toList());
		ContactList.forEach(i -> System.out.println(i));
	}

	public static void sortByCity() {
		ContactList = ContactList.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
		ContactList.forEach(i -> System.out.println(i));
	}

	public static void sortByState() {
		ContactList = ContactList.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
		ContactList.forEach(i -> System.out.println(i));
	}

	public static void sortByZipCode() {
		ContactList = ContactList.stream().sorted(Comparator.comparing(Contact::getZipCode))
				.collect(Collectors.toList());
		ContactList.forEach(i -> System.out.println(i));
	}

	public static void getDataFromFile() {
		System.out.println("Enter address book name : ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		Path filePath = Paths.get("D:\\COURSES\\BRIDGELABZ\\FELLOWSHIP\\FILES" + fileName + ".txt");
		try {
			Files.lines(filePath).map(line -> line.trim()).forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addDataToFile(String firstName, String lastName, String address, String city, String state,
			String mobileNum, String zipCode, String email, String addressBookName) {
		System.out.println("Enter name for txt written file : ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		File file = new File("D:\\COURSES\\BRIDGELABZ\\FELLOWSHIP\\FILES" + fileName + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("\nFirst Name : " + firstName + "\nLast Name : " + lastName + "\nUser Email : " + email
					+ "\nUser Mobile Number : " + mobileNum + "\nUser State : " + state + "\nUser City : " + city
					+ "\nAddress : " + address + "\nUser ZipCode : " + zipCode + "\n");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
