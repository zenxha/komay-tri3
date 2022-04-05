import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import Week0.*;
import Week1.*;
import Week2.*;
import Week3.*;
/**
 * Menu: custom implementation
 * @author     John Mortensen
 *
 * Uses String to contain Title for Option
 * Uses Runnable to store Class-Method to be run when Title is selected
 */

// The Menu Class has a HashMap of Menu Rows
public class Menu {
    // Format
    // Key {0, 1, 2, ...} created based on order of input menu
    // Value {MenuRow0, MenuRow1, MenuRow2,...} each corresponds to key
    // MenuRow  {<Exit,Noop>, Option1, Option2, ...}
    Map<Integer, MenuRow> menu = new HashMap<>();

    /**
     *  Constructor for Menu,
     *
     * @param  rows,  is the row data for menu.
     */
    public Menu(MenuRow[] rows) {
        int i = 0;
        for (MenuRow row : rows) {
            // Build HashMap for lookup convenience
            menu.put(i++, new MenuRow(row.getTitle(), row.getAction()));
        }
    }

    /**
     *  Get Row from Menu,
     *
     * @param  i,  HashMap key (k)
     *
     * @return  MenuRow, the selected menu
     */
    public MenuRow get(int i) {
        return menu.get(i);
    }

    /**
     *  Iterate through and print rows in HashMap
     */
    public void print() {
        for (Map.Entry<Integer, MenuRow> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " ==> " + pair.getValue().getTitle());
        }
    }

    public String getAscii() {
        return "^^::................:^~?YPGGGGGGGGGGGGGPP55YYJJJJJYY5PPP5J??777777777777??777777!!~^!~~~!!!!!7?!!77?\n" +
                "................:^!?YPGGBBBBBBGGGGPP55YYJJ??JJY55PPP5YJJ??J?J????????7?7??777???77^!!~~~!!~^:!!!!~~:\n" +
                "............:~7J5GBBBBBBBGGGGPP55YYJJ??JJYY5PPP55YYYJYYJJJJJJJJJJJ???????777?????!~?!!!!!!~:~?!!!!^:\n" +
                ".......:^~?YPGBBBBBBGGGGPP55YYJJJJJJJY5PPPPP555555PPPP5YY5YYJY5YJ??JJJJ?7777????J~77!!!!!!^^77!!!~^~\n" +
                "...:^!?YPGBBBBBBGGGPP55YYJJJJJJJY55PPP55555555GBBGBBBBGGGGGGPGGGPP55PPPP577??J?J!!?7!!!!!~:!7!77!^^?\n" +
                "^!J5GBBBBBBGGGPPP55YYJJJJJJYY55PPP55Y55P55PGGBBB#BB###BBBBBBBBBBBBBGGGGPP??????J~?77!!!!~^~77!7!~^7?\n" +
                "GBBBBBBBGGPP55YYJJJJJJJYY55P555YYYY55PGGBB#########BBBBBBBBBB#BBBB#BBGGP5JJJY?J77?7!77!!~^77!!7!^~J7\n" +
                "BBBGGGPP55YYJJJJJJJY55555YYJJJYYYY5PGB##############BBBBBBB#######BBBBBBGGPPPYJ7JJ??777!^!?7777!^??7\n" +
                "GGPP55YJJJJJJJYY5PPGGGPPP555YYYY5PBB###########BBBBBB#BBBB#######BBBBBBBBBGGGPPPP5YYY?7~~J77777^!J?7\n" +
                "5YYJJJJJJJYY555YJJJYY5PPGGBBBGGGBBBBB#########BBBBBBBBBBBBB#####B#BBBBBBBBGBBBBBBGGP5J7^7J77?7!^JJ??\n" +
                "JJJJJJYY555P5YYJYYYYYYYYYYY55GBBBB##B#######BBBBBBGBBGGGGBBBBBBBBBBBGGBGGBBBBBBBGGGGG57!Y????7^!YJ??\n" +
                "JJYY555YYJY5JJYYYYYY555555PGBBBBBB##BB######BBBGGGGGGGGGGGGGGGPPPGGGGGGGBBBBBBBBBBBGBBPYPY???7^?YJJJ\n" +
                "55YJJJ?JJ?YYJJYYYYYYYYYY55GBB#BBBB###BB#BB#BBBGGGGPGPPPPPPPPPP555PGGGGGBB#BBB#BBBBBGGBGGGG5J?!~5J??J\n" +
                "YJ7??JJYJJ5JJJJJYYYYYYYY5PGBB#BBBB###BBBBBBBBGPPPP5GP555555555Y5PPGGGGGGGBBBBBBBBBGGBBBGPPGP?^?5???J\n" +
                "Y??JJJYYJY5JJJJYYYYYYYYY5GBB##BBBBBB#BBBBBBBGG55P5YP5555555555PPPPGGPPP5PGGGBGBBBBGBBBBGGPPGJ~YY???J\n" +
                "Y?J?JJJYJYYJJJJYJYYYYYYYPGB#####BGBB##BBBBBBGGP55YY55YY555555PP5PPGP5555PGGGGGGBBPGGBGGGGGPGY75JJJJJ\n" +
                "Y?JJJJJJJ5JJJJYYJJYYYYY5GB####BP5GBB#BBBBBBBBGGP55YY5YY5555555555PP55Y5PPGGPPGGGPPGPPPGGGBGG5J5JJJJJ\n" +
                "JJJJJJJJJ5JJJYJJJJJJYYYPGB###GYY5PGBBBBBGBBBBGGP55YJJYYY55YYYY555P55Y5PPPPPPGGGGPPP5PGBBGGGPP5J?JJJJ\n" +
                "?YJJJJJJYYJJJJJJJJJJYJ5BBB#B5Y5PGGGGBBBBBGGGBBBG5J?7?JYPPGGGGGP55YYYPGPPPPPGGPGPPPPGGGBBGG55PGP5JJJJ\n" +
                "?YJJJJJJYYJJJJJJJJJJJ5BBBBPY5PGGBGPPBBBBBGGGGGPY?7!!7?Y55PPGGGBGGPPGBPP5PPGGPGGPGPGGGGGGG55GGGBGYJYJ\n" +
                "?YJJJJJJ5YJJJJJJJJJJYB#BGYY5PPPPPPPPGGGGBGGG5J7~~^^~7?JJJJYYY55PBBBBG5Y5PGGPGG5PPGGPPGGP55PGBGGGG5YJ\n" +
                "JYJJJJJJ5JJJJJJJJJJJ5BB5?JY55YYYYYYY55PGPPY?!~~^^^^~7JYYYYYYY5PPP5P5PG55GBGGG5PGGBBPPPP5Y5PGPGPPPGGY\n" +
                "YJJJJYJY5JJJJJJJJJJJYBY7JYYYYYYYYYY5PPPYJ7!~^^^^^^~!JY5PPP55Y???JJJJJYPPBGGGPPGGGBGPPPP5YYGP5PPGPPGG\n" +
                "YJJJJJJ5YJJYYJJJJJJJ5Y7?JYYYYYYY55PP5YY?!~^^^^^^^^^!?YPGPPBBPY?7??JJ?7PBGGBBPGGGGBPPPPPPP5G5PPPPPGPP\n" +
                "YJJJJJJ5JJJJJJJJJJJY577??JYYYY55PPYYJJJ?!~^::^^^^^^^!?JYY5PGBPP5??JY?YPPPGBBGGGGBGPPPGGGGPG5P55PGGGP\n" +
                "YJJJJJY5JJYJJJJJJJJY777??YYYY555PPJPB5J?!!~^:^^^^^^^^~!77777?7JPPYJJY5Y55GBBBBBBBGP5PGGBBGGPPPPPGGBP\n" +
                "YYJJJJYYJJJJJJJJJJY?777?JYYYY555PPP5P5Y?75G?^::^^^^^^^~~~~~~~^~!77?777?Y5GBBBBBBGGPPGPGBBBG5PGPGPGG5\n" +
                "YYYJJJ5YJJJJJJJJJJJ7777?JJYY5555555YJJJ7!!Y5!^:^^^^^^^^^^^^^:::::^^^~~7J5GBBBBBBBGGGGGPGBBGPPGGGPPGG\n" +
                "YYYYJJ5JJJJJJJJYJJ?7777?JYYYYY5555J7!?7~^^~7!~^^^^^^^^^^^^^::::::::^^^~7YGB#BBBBBBBGGGGBBBGGPGGGPPPG\n" +
                "YYYYJY5JJJJJJJJYYY7777??JYYYY5555P5J?7!^^^:::^^^^^^^^^^^^^::::::::::^^~!JG##BBBBBBBBBBBBBBGPGPPGGGGP\n" +
                "YY55Y55JJJYYYYYYYY7777?JYY5PPPPGGPPP5Y?7~:::::::^^^^^^^^^::::::::::^^^~~?G###BBB##BBBBBBBBGPGPPGBBGP\n" +
                "5555Y55YYYYYYYY55Y?77??JYYY55555YYY5PP5YJ7^::^::^^^^^^^::::::::::^^^^^^!YGBBBBBBB#BBBBBBBGGGGPPGBBBG\n" +
                "5555YP5YYYYYYYYY5Y?????JJYYYYY55YYJ777?JY5?~^^^::^^^^^^^^^::::::^^^^^^~JGGB#BBBBB#BBBBBBGGGGGGPGBGPP\n" +
                "5555YP5YYYYYYYYY5Y?????JJYYYYJJJJYJ?7!~~~7YY!^^^^^^^^^^^^^^:::^^^^^^^~?PPBBGPGBBBBGPG#BGGGGGGPGGGJYP\n" +
                "YPP5YG5555YYYYYY55J????JJYYJJ??77!!!!~~~^^~7!~^^^^^^^^^^::::::^^^^^^~755PPPP55PYY5P5BBBBBBBGGGG5PJPP\n" +
                "Y5PP5G55555YYYYY5PY????JJJJJ??7!!~~~^^^^^^^^^^^^^^^^^^^:^:::^^^^^^^~!?J?J?5YJJ7^7YYB#BBBBBBGGPPP555Y\n" +
                "YYPG5GP5555555YY5PGY??JJJJJJ?77!~~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~~~!~!~^!7??~^7YB##BBBBGGGGGPPP555\n" +
                "YY5PPGP555555555PGGYJJJJJJJJJ?77!~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^~~~~~^^^:^:^~~^^!P####BBBGBBBGGPPPGGP\n" +
                "YJ5PPBPP5PP5555555YJJJJJJJJJJJ?77!!~~^^^^^^^^^^^^^^^^^^^^^^~~~~~~!7!:::::.:^~!YB###BBBBBBBBGGGGGBGGG\n" +
                "YJJPGBGP5PPP55555YJJJJ??JJJJJJJ??77!!~~~~~^^^^^^~^^~~~~~~~~~~~~!J5BPJ!~!!7J5PB###BBBBBBBBBBGGBBBBGGG\n" +
                "YYJ5GBGGGPPP55555JJYJJ????JJJJJJJ????77!!!!~~~~~~~~~~~~~~~~~~!7?Y5B###B####BB##BBBBBB#BBBBBBBBBBBGGG\n" +
                "J5JYG#BBBGPP55Y??JYYJJJ????JJJJJJJJ??????777777!!!!!!!!!~~~~~~~!?G####B#BBBB##BBBBBB#BBBBBBBBBBBBBBB\n" +
                "YPJJ5P5YYJJ??7!?JJYJJJ?????JJJJ????????777777777!!!!~~~~~^^^^^^7P####BBBBBB##BBBBBB#BBBBBBB#BBBBBBBB\n" +
                "77!!77!!!77!~~7YJJJJJJ?????J??????77777!!!!!!!!!~~~~~~^^^^^^^^~7P##BBBBBBBB#BBBBBB##BBBBBBBBBBBBBB#B\n" +
                "~!77777777~^~!J5JJJJJJ??????????777!!!!!!!~~~~~~~~~~~^^^^^^^^^:::?GBBBBBBB#BBBBBBB#BBBBBBBBBBBBBB#BB\n" +
                "!!!!!!7?7~^~~!?5YJJJJJ?????????77!!!!~~~~~~~~~~~~~~~^^^^^^^^:.....^5#BBBBB#BBBBBB#BBBBBB#BBBBBBBB#BB\n" +
                "!!!!77?7^^~~~~7YYJJJJJ????????777!!!~~~~~~~~~~~~~~~~^^^^^^^:.......:Y#BBBB#BBBBBB#BBBBBB#BBBBBBB#BBB\n" +
                "!!!7??!^~~~~~~775YJJJJ???????777!!!!~~~~~~~~~~~~~~~~~^^^^~^..........J####BBBBBBBBBBBBBBBBBBBBBBBBBB\n" +
                "!77??!^^^~~^^!7~JYJJJ?????????777!!!~~~~~~~~~~~~~~~~~~^~!^............~JG##BBBBB#BBBBBBBBBBBBBB#BBBB\n" +
                "777!~^^^:::^^!!~~JJJJJ????????777!!!~~~~~~~~~~~~~~~~~~!J^...............:!YB##B##BBBBBBBBBBBBBBBBBBB\n" +
                "!~^^::::::::^!~~~!YJJJ???????7777!!!~~~~~~~~~~~~~~~~!?Y~...................^?P###BBBBBBBBBBBBBBBBBBB\n" +
                "~^^:::::::::~!~~~^!YYJJ???????777!!!!!~~~~~~~~~~~~!7J5!..................::..:~YB##BBBBBBBBBBBBBBBBB\n" +
                "^^:::::::..:~~^^^^^!YJJJJ??????777!!!!!!!!!!~~~!!7?JP?....................:::...^?G####BBBBBBBBBBBBB\n" +
                "^:::::::...^!^^^^^^^~JJJJ??????777!!!!!!!!!!!!!77?Y5Y:.......::...........:^::....:!5##BBBBBBBBBBBBB\n" +
                ":::::::....~~^^^^^^^^^7JJJ?????77777!!!!!!!!!77?JY55~.....::..............:^^:.......~YB#BBBBBBBBBBB\n" +
                "::::::....:!~^^^^^^^^^^~7??????777777777777777?JYYY!::::::::..............::^^:........~YB#B##BBBBBB\n" +
                ":::::.....^!^::^^^^~~~^^^~!7777!77777777777?????7!!::::::::::.............::^^::.........~YB##BBBBBB\n" +
                ":::.......^~~^::^^^~~~~~~~~~~~^:::^~!!!!!!!~~^^^!!~:.:::::::::............:^~^::...........~5##BBBBB\n" +
                "::.......:~~~^^::^~~~~~~!!~~~~^:.....:::....::^~!!:..:^^::::::...........::^~~^::...........:!P##BBB\n" +
                ".........:^~~^^::^~~~~~!!!!!~~^:..........::::^^~^:.::^^^::::::.........:::^~~^:::..........:.:JB#BB\n" +
                "........:^^~~^^::^~~~~!!!!!!~~^:.........::::::^^::::^^^^::::::.........::::^~^:::............::~P##\n" +
                "........:^^~~^^^^^~~~!!77!!!~!~:.........:::::^^::::^^^^^^::::::........::::^~:.^^.............:::JB\n" +
                "........:^~~~~^^^^~~!!!77!!!!!!~:........:::^~::^::::^^^^:::::::::...:::::^^~^.:^:...............::!\n" +
                "........:^~~~~^^^^~~!!7777!!!!!~^:.......::^~^..^::::^^^^^^^^^~^:::^^^^^^~~~~::~^:................::\n" +
                "......:::^~!~~^^^^~~!!7777!!!!!!~^:......:^!^...^^^^^^^^^^^^^~~::.::^^^^^~~~^.^~::..:...............\n" +
                ".....::::^~!~~~^^^~~~!7777!~~!!!!~:.....:^!~:...::^^^^^^^^^^^~^:....::^^~~~^::~^::..:...............\n" +
                "....:^:::^~!!~~^^^^~~!7777~~~!!!!!~:....:!!:::....::^^^^^^^^~~^:.....::^~~~^:~~^::::^:..............\n" +
                "....^^:::^~!!~~^^^^~~!77?7!~^~!!!!!~::..^!^::........:^^^^^^~~^:.....::^~~^:^~^:::::^:............:.\n" +
                "...:~^^::^~!!~~^^^^^~!!7?7!!^^^~!!!!~:.:~^:::.......:^^^^^^~~~^:.....::^~^^:~^^::::^^^............:.\n" +
                "...^~^^::~~!!~~^^:^^~~!77?7!!^:^~!!!!^:~~:::.......:^^^^^^^~~~^::....:^~~^:^~^::::^^:^:...........:.\n" +
                "..^~^^^::~~!!~!^:::^^~!!7777!!^::~!!!~~~:::.......:^^^^^^^^~~~^^:....:^~^^:~^^:::^^^:::....::::::::.\n" +
                ".:~~^^^.:~!!!~!~^::^^~~!!7777!!^::~!!!!:::.......::^^^:^^^^~~~~^:::..::^^:^~^^:^^^^:::^:.:::::::::::\n" +
                ".^~~^^^.:~!!!~!~^:::^~~!!!!!!7!~::^!77^::........::^^^::^^^^~~~~^::::::^:^~^^^^^^^:::::^:::::::::^^:\n" +
                ":~~^~~:.:~~!!~!~^:::^^~!!!!!!!!!~^^!?!:::.......:::^^^::^^^^^~~~^^^::::::~^^^^^^^::::::^:::::::::^^^\n" +
                "~~~~~~:.:~!!!~!!^:::^^~!!!!!!!!!!!~!7^::.......::::^^:::^^^^^^~~~^^^::::~~^^^^^^::::::^^^^^^^^:::^~~\n" +
                "~~~~~^:.:~~!!~!!~^::^^^~!!!!!!!!!7!7~::.....::.:::^^^::::^^^^^~~~^^^::^^~^^^^^:::^^:::^^^^^^^^^^^^~~\n" +
                "~~~~~^:.:~~!!~!!~^^^^^^~~~~~!!!!777!^::..::::::::::^^::::^^^^^^~~^^^:^^~^^^^:^^^:^:::^^^^^^^^^^^^^~~\n" +
                "~!!~~::.:~~~~~~!~^^^^^~~~~~~~~~!777~^:::::::.:::::^^:::::^^^^^^~~^^^^^~~^^^^:^^^::::::^^^^^^^^^^^^~~\n" +
                "!!!~^::.:~~~~~~!!~^~~~^^~~~~~~~!777^:::::::::..:::^::::::^^^^^:^~^^^^~~^^^^^:^^:::::::^^^^^^^^^^^^~~\n" +
                "!!~~^::.:~~~~~!!!~~!~^^^^~~~~~~!!7!:.:::::::::.:::::::::::^^^^::~^^^~~^^^^^^:^^::::::^^^^^^^^^^^^^~~\n" +
                "!~~~:::..^~~~~!!!~!~^^^^~~~^^^^~!!~:.:::::::::::::::::::::^^^^^:~~^^~~^^^^^^:::::::::^^^^^^~^^^^^^~~\n" +
                "~~~^:::..^~~~~!!!!!~^^^~~~~^^^^~~~:..::::::::::::::::.:::::^^^^:^~^~~~^^^^^::::::::::^^^^^^^^^^^^^^~\n" +
                "~~~^:::..^~~~~~!!!~~~^^~~~^^^^^~~~:...:::::::::::::::.:::::^^^^^:^^~~^^^^^^::::::::::^^^^^^^^^^^^^^~";
    }

    /**
     *  To test run Driver
     */
    public static void main(String[] args) {
        Driver.main(args);
    }

}

// The MenuRow Class has title and action for individual line item in menu
class MenuRow {
    String title;       // menu item title
    Runnable action;    // menu item action, using Runnable

    /**
     *  Constructor for MenuRow,
     *
     * @param  title,  is the description of the menu item
     * @param  action, is the run-able action for the menu item
     */
    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    /**
     *  Getters
     */
    public String getTitle() {
        return this.title;
    }
    public Runnable getAction() {
        return this.action;
    }

    /**
     *  Runs the action using Runnable (.run)
     */
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
          // lambda style, () -> to point to Class.Method
        };

        // Menu construction
        Menu menu = new Menu(rows);

        // Run menu forever, exit condition contained in loop
        while (true) {
            System.out.println(menu.getAscii());
            System.out.println("Weeks Menu:");
            // print rows
            menu.print();

            // Scan for input
            try {
                Scanner sc = new Scanner(System.in);
                int selection = sc.nextInt();

                // menu action
                try {
                    MenuRow row = menu.get(selection);
                    // stop menu condition
                    if (row.getTitle().equals("Exit"))
                        return;
                    // run option
                    row.run();
                } catch (Exception e) {
                    System.out.printf("Invalid selection %d\n", selection);
                }
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
    }
}

