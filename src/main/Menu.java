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
        final String PURPLE = "\u001B[38;5;93m";
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
    /** Función que no recibe párametros y retorna un entero que indica la opción elegida que inidca el tipo de juego que se va a jugar.
     * Despliega el menu y las opciones posibles */
    public void RunMenu() {
        Scanner Scanf = new Scanner(System.in);
        byte Option;
        final String BLUE = "\u001B[38;2;0;255;255m";
        final String PINK = "\u001B[38;5;201m";
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        Game g=new Game();
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
            System.out.println("Selected option: " + Option);
            switch (Option) {
                case 1:
                    System.out.print(BLUE +
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
                    g.TwoPlayerGame();
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
                    g.OnePlayerGame();
                    break;
                    //funcion de Player vs AI
                case 3:
                    System.out.print(RED +
                        "\n" +
                        "  _                      _                         \n" +
                        " | |                    (_)                        \n" +
                        " | |     ___  __ ___   ___ _ __   __ _             \n" +
                        " | |    / _ \\/ _` \\ \\ / / | '_ \\ / _` |            \n" +
                        " | |___|  __/ (_| |\\ V /| | | | | (_| |  _   _   _ \n" +
                        " |______\\___|\\__,_| \\_/ |_|_| |_|\\__, | (_) (_) (_)\n" +
                        "                                  __/ |            \n" +
                        "                                 |___/             \n" +
                        RESET);

                    break;
                default:
                    System.out.println("Invalid option!!!");
            }

        } while (Option != 3);
        Scanf.close();
    }
}