package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private Scanner sc = new Scanner(System.in);
    private List<Contact> contacts = new ArrayList<>();

    public void add() {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();

        switch (type) {
            case "person" -> addPerson();
            case "organization" -> addOrganization();
        }

        System.out.println();
    }

    public void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
        System.out.println();
    }

    public void list() {
        int index = 1;

        for (Contact contact : contacts) {
            System.out.println(index++ + ". " + contact.getInfo());
        }

        System.out.println();
        System.out.println("[list] Enter action ([number], back): ");

        String input = sc.nextLine();

        if (input.equals("back")) {
            return;
        } else {
            Contact contact = contacts.get(Integer.parseInt(input) - 1);
            System.out.println(contact);
            if (!contact.doAction()) {
                contacts.remove(contact);
            }
        }
    }

    public void search() {
        System.out.print("Enter search query: ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Contact> results = contacts
                .stream()
                .filter(contact -> contact.getInfo().toLowerCase().contains(input) || contact.getNumber().contains(input))
                .toList();

        System.out.println("Found " + results.size() + " results:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + 1 + ". " + results.get(i).getInfo());
        }

        System.out.println();
        System.out.println("[search] Enter action ([number], back, again): ");

        String newInput = sc.nextLine();
        switch (newInput) {
            case "again" -> search();
            case "back" -> {
                return;
            }
            default -> {
                Contact contact = results.get(Integer.parseInt(newInput) - 1);
                System.out.println(contact);
                if (!contact.doAction()) {
                    contacts.remove(contact);
                }
            }
        }
    }

    private void addPerson() {
        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the surname: ");
        String surname = sc.nextLine();

        System.out.print("Enter the birth date: ");
        String birthDate = sc.nextLine();

        System.out.print("Enter the gender (M, F): ");
        String gender = sc.nextLine();

        System.out.print("Enter the number: ");
        String number = sc.nextLine();

        contacts.add(new PersonContact(name, surname, birthDate, gender, number));

        System.out.println("The record added.");
    }

    private void addOrganization() {
        System.out.print("Enter the organization name: ");
        String name = sc.nextLine();

        System.out.print("Enter the address: ");
        String address = sc.nextLine();

        System.out.print("Enter the number: ");
        String number = sc.nextLine();

        contacts.add(new OrganizationContact(name, address, number));

        System.out.println("The record added.");
    }
}
