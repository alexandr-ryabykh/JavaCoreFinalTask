package andersen.view;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public interface View {

    Scanner sc = new Scanner(System.in);

    void create() throws IOException;

    void read() throws IOException;

    void update() throws IOException;

    void delete() throws IOException;

    default Set<Long> getIds() {

        Set<Long> ids = new HashSet<>();
        boolean check = false;
        int numberOfEntities = -1;

        while (!check) {
            System.out.println("Write the number of entities:");
            if (sc.hasNextInt()) {
                numberOfEntities = Integer.parseInt(sc.nextLine());
                check = true;
            } else {
                System.out.println("Invalid input");
                sc.next();
                check = false;
            }
        }
        int i = 0;
        while (i != numberOfEntities) {
            System.out.println("Write the entity's id");
            if (sc.hasNextLong()) {
                ids.add(Long.parseLong(sc.nextLine()));
                i += 1;
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return ids;
    }
}
