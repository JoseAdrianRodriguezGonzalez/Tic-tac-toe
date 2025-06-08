import java.lang.annotation.Repeatable;
import java.util.Scanner;
/*I
 * Clase dedica a imprimir el menu
 */
public class Menu{
    /*
     * Función que no recibe párametros ni retorna un valor.
     * Imprime un titulo con colores
     */
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
    /** Función que no recibe párametros ni retorna un valor.
     * Despliega el menu y las opciones posibles */
    public void RunMenu() {
        Scanner Scanf = new Scanner(System.in);
        byte Option;
        final String PURPLE = "\u001B[38;5;93m";
        final String PINK = "\u001B[38;5;201m";
        final String RESET = "\u001B[0m";
        do {
            PrintTitle();
            System.out.println("Choose an option: ");
            System.out.println("1. Player VS Player");
            System.out.println("2. Player VS AI");
            System.out.println("3. Exit");
            Option = Scanf.nextByte();

            if (!(Option > 0 && Option < 4)) {
                System.out.println("Invalid option!!!");
                continue;
            }
            switch (Option) {
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
            System.out.println("Selected option: " + Option);
        } while (Option != 3);
    }
}