import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Punto1 {
    ArrayList<Numeros> n;

    public Punto1() {
        n = new ArrayList<>();
    }

    // metodos
    public void siguientesNodos() {
        if (n.isEmpty()) {
            n = new ArrayList<>();
            n.add(crearNodo(1));
            return;
        }

        // buscar siguiente primo();
        int sp = 0;
        for (sp = n.size() + 1; sp <= n.size() + 20; sp++) {
            if (esPrimo(sp)) break;
        }
        System.out.println("Siguiente primo -> "+sp);

        // añadir el siguiente primo
        int diff = sp - n.size();
        for (int i = 0; i < diff; i++) {
            n.add(crearNodo(n.size() + 1));
        }


    }

    public boolean esPrimo(int n) { // se podria reducir el rango de division hasta la mita del nuemero
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public Numeros crearNodo(int digitos) {
        int x;
        while (true) {
            // crear cadena
            String cadena = "";
            for (int i = 0; i < 3; i++) {
                if ( i == 0) {
                    do {
                        x = numeroAleatorio(digitos);
                    } while (x <= ((Math.pow(10, digitos)) * 0.7));
                } else {
                    do {
                        x = numeroAleatorio(digitos);
                    } while (x > (Math.pow(10, digitos)));
                }

                cadena += x + " ";
            }

            // verificar cadena.
            if( verificarCadena(cadena))
                return new Numeros(Arrays.stream(cadena.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
    }

    // verificacion
    public boolean verificarCadena(String cadena) {
        Pattern p = Pattern.compile("\\d+ \\d+ \\d+ ");
        if (p.matcher(cadena).matches()) {
            int[] nms = Arrays.stream(cadena.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (nms[0] < nms[1] && nms[0] < nms[2]) {
                System.out.println("[!] Cadena valida: " + Arrays.toString(nms));
                return true;
            }
            System.out.println("[x] Cadena invalida: " + Arrays.toString(nms));
        }
        return false;
    }

    // UTILIDAD
    public int numeroAleatorio(int digitos) {
        int num = (int) Math.floor(Math.random() * (Math.pow(10, digitos)));
        // System.out.println(num);
        return num;
    }

    // Getters and Setters
    public ArrayList<Numeros> getArrayList() {
        return n;
    }

    public void setArrayList(ArrayList<Numeros> n) {
        this.n = n;
    }
}
