public class MenuPrincipal extends Menu {
    public MenuPrincipal(String title) {
        super(title);
    }

    public void menu() {
        while (true) {
            int opt = Integer.parseInt(input("Menu: \n1. Primer Punto."));

            switch (opt) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    new MenuP1("Menu del punto 1").menu();
                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }
        }


    }
}
