package andersen.view;


import andersen.controller.CustomerController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class CustomerView implements View {

    private CustomerController controller = new CustomerController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write customer's first name:");
        String firstName = sc.nextLine();
        System.out.println("Write customer's last name:");
        String lastName = sc.nextLine();
        System.out.println("Write customer's address:");
        String address = sc.nextLine();
        Set<Long> projectsId = getIds();

        if (controller.create(firstName, lastName, address, projectsId))
            System.out.println("Customer was created successfully");
        else
            System.out.println("Error during customer creation");
    }

    public void read() throws IOException {
        Long id = getId();
        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        System.out.println("Write customer's first name:");
        String firstName = sc.nextLine();
        System.out.println("Write customer's last name:");
        String lastName = sc.nextLine();
        System.out.println("Write the customer's address:");
        String address = sc.nextLine();
        Set<Long> projectsId = getIds();

        if (controller.update(id, firstName, lastName, address, projectsId))
            System.out.println("Customer was updated");
        else
            System.out.println("Error during customer update");
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Customer was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the customer's id");
            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyId(id))
                    check = true;
                else {
                    System.out.println("There is no customer with this id");
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }
}
