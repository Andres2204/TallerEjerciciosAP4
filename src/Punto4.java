import java.util.ArrayList;
import java.util.regex.Pattern;

public class Punto4 {
    private ArrayList<DatosP4> Array;

    public Punto4() { // constructor
        Array = new ArrayList<DatosP4>();
    }

    public ArrayList<String> NumerosIgualesSeguidos(){ // metodo que busca 2 numeros iguales en cualquier parte del string de entrada
        ArrayList<String> codigos = new ArrayList<String>();
        Pattern patron = Pattern.compile("00|11|22|33|44|55|66|77|88|99");
        for (DatosP4 datosP4 : Array) { // recorro todo el Array buscando quien cumple con el patron
            if(patron.matcher(datosP4.getCodigo()).find()){
                codigos.add(datosP4.getCodigo());
            }
        }
        return codigos;
    }

    public String Mostrar(){ // devuelve un string que contiene todos los datos del Array
        String s = "";
        for (DatosP4 datosP4 : Array) {
            int i = 1;
            s += "Nodo "+i+": \n  Dato1: "+datosP4.getDato1()+"\n  Dato2: "+datosP4.getDato2()+"\n  Codigo: "+datosP4.getCodigo()+"\n\n";
        }
        return s;
    }

    public ArrayList<DatosP4> getArray() {
        return Array;
    }

    public void setArray(ArrayList<DatosP4> array) {
        Array = array;
    }

    
}
