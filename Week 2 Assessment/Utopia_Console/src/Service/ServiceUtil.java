package Service;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUtil {

    public Integer displayMenu(ArrayList<String> options) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < options.size(); ++ i) {
            System.out.print(i + 1 + ". ");
            System.out.println(options.get(i));
        }
        System.out.println();

        Integer selection = -1;

        // Get Selection
        while (selection < 1 || selection > options.size()) {
            System.out.print("Input the menu option number: ");
            try {
                selection = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                e.getMessage();
            }
        }
        System.out.println();
        return selection;
    }
}
