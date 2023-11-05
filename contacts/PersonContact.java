package contacts;

import contacts.enumertion.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonContact extends Contact {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public PersonContact(String name, String surname, String birthDate, String gender, String number) {
        super(number, true);
        this.name = name;
        this.surname = surname;
        this.birthDate = validateBirthDate(birthDate);
        this.gender = validateGender(gender);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + name + System.lineSeparator()
                + "Surname: " + surname + System.lineSeparator()
                + "Birth date: " + (birthDate == null ? "[no data]" : birthDate) + System.lineSeparator()
                + "Gender: " + (gender == null ? "[no data]" : gender) + System.lineSeparator()
                + "Number: " + (getNumber() == null ? "[no data]" : getNumber()) + System.lineSeparator()
                + "Time created: " + getCreated() + System.lineSeparator()
                + "Time last edit: " + getUpdated();
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String fieldName = sc.nextLine();
        System.out.print("Enter " + fieldName + ": ");
        String field = sc.nextLine();

        switch (fieldName) {
            case "name" -> name = field;
            case "surname" -> surname = field;
            case "birth" -> birthDate = validateBirthDate(field);
            case "gender" -> gender = validateGender(field);
            case "number" -> setNumber(field);
        }

        super.edit();
    }

    @Override
    public String getInfo() {
        return name + " " + surname;
    }

    private LocalDate validateBirthDate(String birthDate) {
        try {
            return LocalDate.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            return null;
        }
    }

    private Gender validateGender(String gender) {
        try {
            return Gender.valueOf(gender);
        } catch (Exception e) {
            System.out.println("Bad gender!");
            return null;
        }
    }
}
