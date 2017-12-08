package andersen;


import andersen.view.*;

import java.io.IOException;
import java.util.Scanner;

public class MenuRunner {

    private SkillView skillView = new SkillView();
    private DeveloperView developerView = new DeveloperView();
    private TeamView teamView = new TeamView();
    private ProjectView projectView = new ProjectView();
    private CompanyView companyView = new CompanyView();
    private CustomerView customerView = new CustomerView();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() throws IOException {
        boolean exit = false;
        int pick;
        while (!exit) {
            System.out.println("What do you want to operate with? \n(Enter the corresponding number)");
            System.out.println();
            entityMenu();
            if (sc.hasNextInt()) {
                pick = Integer.parseInt(sc.nextLine());
                switch (pick) {
                    case 1:
                        switchMenu(skillView);
                        break;
                    case 2:
                        switchMenu(developerView);
                        break;
                    case 3:
                        switchMenu(teamView);
                        break;
                    case 4:
                        switchMenu(projectView);
                        break;
                    case 5:
                        switchMenu(companyView);
                        break;
                    case 6:
                        switchMenu(customerView);
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
    }

    private void switchMenu(View view) throws IOException {
        boolean exit = false;
        int operation;

        while (!exit) {
            System.out.println();
            System.out.println("Choose the option");
            System.out.println();
            operationMenu();
            if (sc.hasNextInt()) {
                operation = Integer.parseInt(sc.nextLine());
                switch (operation) {
                    case 1:
                        view.create();
                        break;
                    case 2:
                        view.read();
                        break;
                    case 3:
                        view.update();
                        break;
                    case 4:
                        view.delete();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } else {
                System.out.println("Invalid input");
                sc.next();
            }
        }
    }

    private void entityMenu() {
        System.out.println("1. Skill");
        System.out.println("2. Developer");
        System.out.println("3. Team");
        System.out.println("4. Project");
        System.out.println("5. Company");
        System.out.println("6. Customer");
        System.out.println("7. Exit");
    }

    private void operationMenu() {
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Back");
    }
}
