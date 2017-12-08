package andersen.view;


import andersen.controller.TeamController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class TeamView implements View {

    private TeamController controller = new TeamController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write the team's name:");
        String name = sc.nextLine();
        Set<Long> ids = getIds();
        if (controller.create(name, ids))
            System.out.println("Team was created successfully");
        else
            System.out.println("Error during team creation");
    }

    public void read() throws IOException {
        Long id = getId();
        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        System.out.println("Write the team's name:");
        String name = sc.nextLine();
        Set<Long> ids = getIds();
        if (controller.update(id, name, ids)) {
            System.out.println("Team was updated successfully");
        } else {
            System.out.println("Error during team update");
        }
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Team was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the team's id");
            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyId(id))
                    check = true;
                else {
                    System.out.println("There is no team with this id");
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }
}
