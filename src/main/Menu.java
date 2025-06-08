import java.util.Scanner;

public class Menu{
    public void PrintTitle(){
        final String PURPLE = "\u001B[35m";
        final String RESET = "\u001B[0m";
        System.out.print(PURPLE +
            "                                                          \n"+
            "      _______ _        _______           _______          \n" +
            "     |__   __(_)      |__   __|         |__   __|         \n" +
            "        | |   _  ___     | | __ _  ___     | | ___   ___  \n" +
            "        | |  | |/ __|    | |/ _` |/ __|    | |/ _ \\ / _ \\ \n" +
            "        | |  | | (__   _ | | (_| | (__     | | (_) |  __/ \n" +
            "        |_|  |_|\\___| | ||_|\\__,_|\\___|    |_|\\___/ \\___| \n" +
            "  ______ ______       | | __ ___   ____ _   ______ ______ \n" +
            " |______|______|  _   | |/ _` \\ \\ / / _` | |______|______|\n" +
            "                 | |__| | (_| |\\ V / (_| |                \n" +
            "                  \\____/ \\__,_| \\_/ \\__,_|                \n"
            + RESET);
    }
    
    public void RunMenu() {
    Scanner scanf = new Scanner(System.in);
    byte option;
    final String PURPLE = "\u001B[38;5;93m";
    final String PINK = "\u001B[38;5;201m";
    final String RESET = "\u001B[0m";

    do {
        System.out.println("Choose an option: ");
        System.out.println("1. Player VS Player");
        System.out.println("2. Player VS AI");
        System.out.println("3. Exit");
        option = scanf.nextByte();

        if (!(option > 0 && option < 4)) {
            System.out.println("Invalid option!!!");
        } else {
            switch (option) {
                case 1:
                    System.out.print(PURPLE +
                    "\n" +
                    "  _____  _                         __      _______     _____  _                       \n" +
                    " |  __ \\| |                        \\ \\    / / ____|   |  __ \\| |                      \n" +
                    " | |__) | | __ _ _   _  ___ _ __    \\ \\  / / (___     | |__) | | __ _ _   _  ___ _ __ \n" +
                    " |  ___/| |/ _` | | | |/ _ \\ '__|    \\ \\/ / \\___ \\    |  ___/| |/ _` | | | |/ _ \\ '__|\n" +
                    " | |    | | (_| | |_| |  __/ |        \\  /  ____) |   | |    | | (_| | |_| |  __/ |   \n" +
                    " |_|    |_|\\__,_|\\__, |\\___|_|         \\/  |_____/    |_|    |_|\\__,_|\\__, |\\___|_|   \n" +
                    "                  __/ |                                                __/ |          \n" +
                    "                 |___/                                                |___/           \n" +
                    RESET);

                    //funcion de Player vs Player
                    break;
                case 2:
                    System.out.print(PINK +
                        "\n" +
                        "  _____  _                         __      _______              _____ \n" +
                        " |  __ \\| |                        \\ \\    / / ____|       /\\   |_   _|\n" +
                        " | |__) | | __ _ _   _  ___ _ __    \\ \\  / / (___        /  \\    | |  \n" +
                        " |  ___/| |/ _` | | | |/ _ \\ '__|    \\ \\/ / \\___ \\      / /\\ \\   | |  \n" +
                        " | |    | | (_| | |_| |  __/ |        \\  /  ____) |    / ____ \\ _| |_ \n" +
                        " |_|    |_|\\__,_|\\__, |\\___|_|         \\/  |_____/    /_/    \\_\\_____|\n" +
                        "                  __/ |                                               \n" +
                        "                 |___/                                               \n" +
                        RESET);
                    //funcion de Player vs AI
                    break;
                case 3:
                    System.out.println("Leaving ...");
                    break;
                default:
                    System.out.println("Invalid option!!!");
            }
            System.out.println("Selected option: " + option);
        }
    } while (option != 3);
}
}