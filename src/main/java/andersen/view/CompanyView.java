package andersen.view;

import andersen.controller.CompanyController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class CompanyView implements View {

    private CompanyController controller = new CompanyController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write the company name:");
        String name = sc.nextLine();
        Set<Long> id = getIds();
        if (controller.create(name, id))
            System.out.println("Company was created successfully");
        else
            System.out.println("Error during company creation");
    }

    public void read() throws IOException {
        Long id = getId();
        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        System.out.println("Write the company name:");
        String name = sc.nextLine();
        Set<Long> ids = getIds();
        if (controller.update(id, name, ids)) {
            System.out.println("Company was updated successfully");
        } else {
            System.out.println("Error during company update");
        }
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Company was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the company's id");
            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyId(id))
                    check = true;
                else {
                    System.out.println("There is no company with this id");
                    sc.next();
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }
}
