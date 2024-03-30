import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

public class MenuP3 extends Menu {
    public MenuP3(String title) {
        super(title);
    }

    public void menu() {
        Punto3 p3 = new Punto3();
        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(input("Menu: \n1. Añadir nuevo nodo manualmente \n2. Añadir nuevo nodo automaticamente \n3. Mostrar nodos"));
            } catch (Exception e) {
                e.printStackTrace();
                // control de la excepcion.
                if (e.toString().contains("Cannot parse null string")) return;
                msg("Se necesita una opcion valida.");
                continue;
            }

            switch (opt) {
                case 0: { return; } // Quit

                case 1: // añadir un docente

                    // patrones
                    Pattern patronCC = Pattern.compile("\\d{6,10}]");
                    Pattern patronFecha = Pattern.compile();


                    String CC = input("Ingresa la cedula del docente: ");
                    
                    break;

                case 2: // Buscar procentaje
                    break;

                case 3: // Buscar mes

                    break;

                case 4: // mostrar todos los docentes

                    break;

                case 5: // equivocaciones

                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }

        }
    }

}
