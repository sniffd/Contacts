package contacts;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;

public abstract class Contact {

    private String number;
    private Boolean isPerson;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Contact(String number, Boolean isPerson) {
        this.number = validateNumber(number);
        this.isPerson = isPerson;

        LocalDateTime instant = LocalDateTime.now();
        created = instant;
        updated = instant;
    }

    public void setNumber(String number) {
        this.number = validateNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreated() {
        return created.truncatedTo(ChronoUnit.MINUTES);
    }

    public LocalDateTime getUpdated() {
        return updated.truncatedTo(ChronoUnit.MINUTES);
    }

    public void edit() {
        updated = LocalDateTime.now();
    }

    public abstract String getInfo();

    public boolean doAction() {
        System.out.println();
        System.out.println("[record] Enter action (edit, delete, menu): ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "menu" -> {
                return true;
            }
            case "edit" -> edit();
            case "delete" -> {
                return false;
            }
        }
        return true;
    }

    private String validateNumber(String number) {
        if (!number.matches(
                "^\\+?((\\([0-9A-Za-z]+\\)([- ]([0-9A-Za-z]{2,}))*)|([0-9A-Za-z]+[- ]\\([0-9A-Za-z]{2,}\\)([- ]([0-9A-Za-z]{2,}))*)|([0-9A-Za-z]+([- ]([0-9A-Za-z]{2,}))*))$"
        )) {
            System.out.println("Wrong number format!");
            return null;
        }
        return number;
    }
}
