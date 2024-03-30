import java.util.ArrayList;

public class MenuP1 extends Menu {

    public MenuP1(String title) {
        super(title);
    }

    public void menu() {
        Punto1 p1 = new Punto1();
        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(input("Menu: " + p1.getArrayList().size() + " \n1. Caso 1. \n2. Caso 2."));
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

                case 1: // añadir automaticamente
                    msg("Añadiendo nodos hasta el siguiente numero primo...");
                    p1.siguientesNodos();
                    break;

                case 2:
                    if(!p1.getArrayList().isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        ArrayList<Numeros> n = p1.getArrayList();
                        for (int i = 0; i < n.size(); i++) {
                            sb.append("Nodo " + (i+1) + "\n\tN1: " + n.get(i).getN1() + "\n\tN2:" + n.get(i).getN2() + "\n\tN3: " + n.get(i).getN3()+"\n");
                        }
                        msgScroll(sb.toString());
                    } else msg("El ArrayList esta vacio.");
                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }

        }
    }
}
