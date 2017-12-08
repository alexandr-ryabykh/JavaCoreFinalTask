package andersen.view;

import andersen.controller.SkillController;

import java.io.IOException;
import java.util.Scanner;

public class SkillView implements View {

    private SkillController controller = new SkillController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Write the skill name");
        if (controller.create(sc.nextLine())) {
            System.out.println("Skill was created successfully");
        } else {
            System.out.println("Error during skill creation");
        }
    }

    public void read() throws IOException {
        Long id = getId();
        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        System.out.println("Write the skill name");
        String name = sc.nextLine();
        if (controller.update(id, name))
            System.out.println("Skill was updated successfully");
        else
            System.out.println("Error during skill update");
    }

    public void delete() throws IOException {
        Long id = getId();
        controller.delete(id);
        System.out.println("Skill was deleted");
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;
        while (!check) {
            System.out.println("Write the skill's id");
            if (sc.hasNextLong()) {
                id = Long.parseLong(sc.nextLine());
                if (controller.verifyId(id))
                    check = true;
                else {
                    System.out.println("Skill with such id doesn't exist");
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return id;
    }
}
