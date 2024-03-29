import java.util.ArrayList;

public class Punto2 {
    ArrayList<ArrayList<Integer>> an;

    public Punto2() {
        this.an = new ArrayList<ArrayList<Integer>>();
    }

    public void crearNodo() {
        if (an.isEmpty()) {
            an.add(crearArrayList(3));
            return;
        }

        // buscar siguiente primo();
        int sp = 0;
        int size = an.get(an.size()-1).size();
        for (sp = size; sp <= size + 20; sp++) {
            if (esPrimo(sp)) break;
        }
        System.out.println("Siguiente primo -> "+sp);
        an.add(crearArrayList(sp));
    }

    private ArrayList<Integer> crearArrayList(int e) {

        ArrayList<Integer> nuevo = new ArrayList<>();
        int digitos = 1;
        int primero = 0;
        int x;
        for (int i = 0; i < e; i++) {
            do {
                x = numeroAleatorio(digitos);
            } while (x < primero);
            if (x > Math.pow(10, digitos)*0.7) digitos++;
            nuevo.add(x);
            if (nuevo.size() == 1) primero = x;
        }

        return nuevo;
    }


    public boolean esPrimo(int n) { // se podria reducir el rango de division hasta la mita del nuemero
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int numeroAleatorio(int digitos) {
        int num = (int) Math.floor(Math.random() * (Math.pow(10, digitos)));
        // System.out.println(num);
        return num;
    }
}
