import java.util.ArrayList;

public class Punto1 {
    ArrayList<Numeros> n;

    public Punto1() {
        n = null;
    }

    // metodos
    public void siguientesNodos() {
        if (n == null) {
            n = new ArrayList<>();
            n.add(llenarNodo(new Numeros(), 1));
            return;
        }

        // buscar siguiente primo();
        int i;
        for(i = n.size(); i <= 100; i++ ) {
            if (esPrimo(i)) break;
        }

        System.out.println(i);

    }

    public boolean esPrimo(int n) {
        for(int i=2;i<n;i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public Numeros llenarNodo(Numeros nodo, int digitos) {
        int x = numeroAleatorio(digitos);
        // verificar rangos


        // cambiar verificaciones por regex de ser necesario.
        if (nodo.getN1() == null) {
            nodo.setN1(x);
            return;
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
            System.out.println("El numero es menor o igual a n1 (" +n1+")");
        }
        return nodo;
    }

    public int numeroAleatorio(int digitos) {
        return (int)Math.floor(Math.random()*digitos);
    }
}
