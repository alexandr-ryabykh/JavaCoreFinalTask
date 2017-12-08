package andersen.view;

import andersen.controller.DeveloperController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView implements View {

    private DeveloperController controller = new DeveloperController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write developer's first name:");
        String firstName = sc.nextLine();
        System.out.println("Write developer's last name:");
        String lastName = sc.nextLine();
        System.out.println("Write developer's speciality:");
        String speciality = sc.nextLine();
        Set<Long> skillsId = getIds();
        BigDecimal salary = getSalary();

        if (controller.create(firstName, lastName, speciality, skillsId, salary))
            System.out.println("Developer was created successfully");
        else
            System.out.println("Error during developer creation");
    }

    public void read() throws IOException {
        Long id = getId();

        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();

        System.out.println("Write developer's first name:");
        String firstName = sc.nextLine();
        System.out.println("Write developer's last name:");
        String lastName = sc.nextLine();
        System.out.println("Write speciality:");
        String speciality = sc.nextLine();

        Set<Long> skillsId = getIds();
        BigDecimal salary = getSalary();

        if (controller.update(id, firstName, lastName, speciality, skillsId, salary)) {
            System.out.println("Developer was updated successfully");
        } else {
            System.out.println("Error during developer update");
        }
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Developer was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the developer's id");

            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyIf(id))
                    check = true;
                else {
                    System.out.println("There is no developer with this id");
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }

    private BigDecimal getSalary() {
        boolean check = false;
        BigDecimal salary = null;
        while (!check) {
            System.out.println("Write the salary:");
            if (sc.hasNextBigDecimal()) {
                salary = new BigDecimal(sc.nextLine());
                check = true;
            } else {
                System.out.println("Error during getting salary");
                sc.next();
                check = false;
            }
        }
        return salary;
    }
}
