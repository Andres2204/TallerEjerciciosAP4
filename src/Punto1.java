import java.util.ArrayList;

public class Punto1 {
    ArrayList<Numeros> n;

    public Punto1() {
        n = new ArrayList<>();
    }

    // metodos
    public void siguientesNodos() {
        if (n.isEmpty()) {
            n = new ArrayList<>();
            n.add(llenarNodo(new Numeros(), 1));
            return;
        }

        // buscar siguiente primo();
        int sp = 0;
        for(sp = n.size()+1; sp <= n.size()+20; sp++ ) {
            if (esPrimo(sp)) break;
        }
        System.out.println(sp);

        // añadir el siguiente primo
        for (int i = 0; i <= (sp-n.size());i++) {
            n.add(llenarNodo(new Numeros(), n.size()+1));
        }


    }

    public boolean esPrimo(int n) {
        for(int i=2;i<n;i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public Numeros llenarNodo(Numeros nodo, int digitos) {
        int x=2;

        // verificar rangos

        while(nodo.getN3() == null) {
            do {x = numeroAleatorio(digitos);} while(x > (10*digitos-3));
            // cambiar verificaciones por regex de ser necesario.
            if (nodo.getN1() == null) {
                nodo.setN1(x);
                continue;
            }
            if (x > nodo.getN1()) {
                if (nodo.getN2() == null) {
                    nodo.setN2(x);
                } else if (nodo.getN3() == null ) {
                    nodo.setN3(x);
                } else {
                    System.out.println("Numero llenos;");
                }
            } else {
                System.out.println("El numero es menor o igual a n1 (" +nodo.getN1()+")");
            }
        }


        return nodo;
    }

    public int numeroAleatorio(int digitos) {
        int num = (int)Math.floor(Math.random()*(digitos*10));
        System.out.println(num);
        return num;
    }

    public ArrayList<Numeros> getArrayList() {
        return n;
    }

    public void setArrayList(ArrayList<Numeros> n) {
        this.n = n;
    }
}
