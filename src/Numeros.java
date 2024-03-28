public class Numeros {
    private Integer n1,n2,n3;

    public Numeros(int num1,int num2,int num3) {
        n1 = num1;
        n2 = num2;
        n3 = num3;
    }
    public Numeros() {
        n1 = null;
        n2 = null;
        n3 = null;
    }

    // metodos (de control)

    public void adicionarNumero(int x) {
        if (n1 == null) {
            n1 = x;
            return;
        }

        if (x > n1) {
            if (n2 == null) {
                n2 = x;
            } else if (n3 == null ) {
                n3 = x;
            } else {
                System.out.println("Numero llenos;");
            }
        } else {
            System.out.println("El numero es menor o igual a n1 (" +n1+")");
        }
    }

    // getters and setters

    public Integer getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public Integer getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }
}
