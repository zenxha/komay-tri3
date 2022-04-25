import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import Week0.*;
import Week1.*;
import Week2.*;
import Week3.*;

// The Menu Class has a HashMap of Menu Rows
public class Menu {
    // Format
    // Key {0, 1, 2, ...} created based on order of input menu
    // Value {MenuRow0, MenuRow1, MenuRow2,...} each corresponds to key
    // MenuRow  {<Exit,Noop>, Option1, Option2, ...}
    Map<Integer, MenuRow> menu = new HashMap<>();


    public Menu(MenuRow[] rows) {
        int i = 0;
        for (MenuRow row : rows) {
            // Build HashMap for lookup convenience
            menu.put(i++, new MenuRow(row.getTitle(), row.getAction()));
        }
    }

    public MenuRow get(int i) {
        return menu.get(i);
    } // Get menu object form hashmap by user inputted integer


    public void print() {
        for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }
    }



    public static void main(String[] args) {
        Driver.main(args);
    }

}

// The MenuRow Class has title and action for individual line item in menu
class MenuRow {
    String title;       // menu item title
    Runnable action;    // menu item action, using Runnable


    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title;
    }
    public Runnable getAction() {
        return this.action;
    }


    public void run() {
        action.run();
    }
}

// The Main Class illustrates initializing and using Menu with Runnable action
class Driver {
    /**
     *  Menu Control Example
     */
    public static void main(String[] args) {
        // Row initialize
        MenuRow[] rows = new MenuRow[]{
          new MenuRow("Exit", () -> main(null)),
          new MenuRow("Week 0", () -> Menu0.main(null)),
          new MenuRow("Week 1", () -> Menu1.main(null)),
          new MenuRow("Week 2", () -> Menu2.main(null)),
          new MenuRow("Week 3", () -> Menu3.main(null)),
          // lambda style, () -> to point to Week.Menu
        };

        // Menu construction
        Menu menu = new Menu(rows);

        // Run menu forever, exit condition contained in loop
        while (true) {

            System.out.println("Weeks Menu:");
            // print rows
            menu.print();

            // Scan for input
            try {
                Scanner sc = new Scanner(System.in);
                int selection = sc.nextInt(); // get user input
                try {
                    MenuRow row = menu.get(selection);
                    if (row.getTitle().equals("Exit"))
                        return;
                    row.run();
                } catch (Exception e) {
                    System.out.printf("lmao thats not even an option bruh %d\n", selection);
                }
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
    }
}

