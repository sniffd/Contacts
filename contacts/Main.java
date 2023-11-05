package contacts;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import contacts.utils.SerializationUtils;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PhoneBook pb;

        if (args.length > 0) {
            File file = new File(args[0]);
            if (!file.createNewFile()) {
                pb = (PhoneBook) SerializationUtils.deserialize(args[0]);
            } else {
                pb = new PhoneBook();
            }
        } else {
            pb = new PhoneBook();
        }
        Scanner sc = new Scanner(System.in);
        String action;

        do {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            action = sc.nextLine();

            switch (action) {
                case "add" -> pb.add();
                case "list" -> pb.list();
                case "search" -> pb.search();
                case "count" -> pb.count();
            }
        } while (!"exit".equals(action));
        System.out.println();
    }
}
