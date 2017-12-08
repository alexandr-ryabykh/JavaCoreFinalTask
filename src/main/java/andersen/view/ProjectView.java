package andersen.view;


import andersen.controller.ProjectController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class ProjectView implements View {

    private ProjectController controller = new ProjectController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write the project's name:");
        String name = sc.nextLine();
        Set<Long> ids = getIds();
        if (controller.create(name, ids))
            System.out.println("Project was created successfully");
        else
            System.out.println("Error during project creation");
    }

    public void read() throws IOException {
        Long id = getId();
        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        System.out.println("Project's name:");
        String name = sc.nextLine();
        Set<Long> ids = getIds();
        if (controller.update(id, name, ids)) {
            System.out.println("Project was updated successfully");
        } else {
            System.out.println("Error during project update");
        }
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Project was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the project's id");
            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyId(id))
                    check = true;
                else {
                    System.out.println("Project with such id doesn't exist");
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }
}
