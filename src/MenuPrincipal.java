public class MenuPrincipal extends Menu {
    public MenuPrincipal(String title) {
        super(title);
    }

    public void menu() {
        while (true) {
            int opt = Integer.parseInt(input(
                    "Menu: \n1. Primer Punto. \n2. Segundo Punto. \n3. Tercer Punto. \n4. Cuarto Punto. \n5. Quinto Punto. \n0. Salir"));

            switch (opt) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    new MenuP1("Menu del punto 1").menu();
                    break;

                case 2:
                    new MenuP2("Menu del punto 2").menu();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    new MenuP5("Menu del punto 5").menu();
                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }
        }

    }
}
