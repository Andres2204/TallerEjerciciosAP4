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

                case 1:
                    msg("caso 1, nuevos nodos");
                    p1.siguientesNodos();
                    break;

                case 2:
                    msg("Mostrar");
                    StringBuilder sb = new StringBuilder();
                    sb.append("No hay nodos");

                    if(!p1.getArrayList().isEmpty()) {
                        sb.delete(0, sb.toString().length());
                        ArrayList<Numeros> n = p1.getArrayList();
                        for (int i = 0; i < n.size(); i++) {
                            sb.append("Nodo " + (i+1) + "\n\tN1: " + n.get(i).getN1() + "\n\tN2:" + n.get(i).getN2() + "\n\tN3: " + n.get(i).getN3()+"\n");
                        }
                    }
                    msgScroll(sb.toString());
                    break;

                default:
                    msg("opcion invalida.");
                    break;
            }

        }
    }
}
