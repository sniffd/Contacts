package contacts;

import java.util.Scanner;

public class OrganizationContact extends Contact {

    private String name;
    private String address;

    public OrganizationContact(String name, String address, String number) {
        super(number, false);
        this.name = name;
        this.address = address;
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Select a field (address, number): ");
        String fieldName = sc.nextLine();
        System.out.print("Enter " + fieldName + ": ");
        String field = sc.nextLine();

        switch (fieldName) {
            case "address" -> address = field;
            case "number" -> setNumber(field);
        }

        super.edit();
    }

    @Override
    public String toString() {
        return "Organization name: " + name + System.lineSeparator()
                + "Address: " + address + System.lineSeparator()
                + "Number: " + (getNumber() == null ? "[no data]" : getNumber()) + System.lineSeparator()
                + "Time created: " + getCreated() + System.lineSeparator()
                + "Time last edit: " + getUpdated();
    }

    @Override
    public String getInfo() {
        return name;
    }
}
