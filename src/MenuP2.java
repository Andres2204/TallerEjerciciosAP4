import java.util.ArrayList;

public class MenuP2 extends Menu {
    public MenuP2(String title) {
        super(title);
    }

    public void menu() {
        Punto2 p2 = new Punto2();
        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(input("Menu: \n1. Caso 1. \n2. Caso 2."));
            } catch (Exception e) {
                e.printStackTrace();
                // control de la excepcion.
                if (e.toString().contains("Cannot parse null string")) return;
                msg("Se necesita una opcion valida.");
                continue;
            }

            switch (opt) {
                case 0: {
                    return;
                }

                case 1:
                    msg("Caso 1");

                    break;

                case 2: // mostrar
                    msg("Caso 2");
                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }

        }
    }
}
