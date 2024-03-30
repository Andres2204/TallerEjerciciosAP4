import java.util.ArrayList;
import java.util.Iterator;

public class Punto3 {

    private ArrayList<Docente> docentes;

    public Punto3() {
        docentes = new ArrayList<>();
    }

    public Punto3(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    // -- metodos --

    public float porcentajeTipo(String tipo) {
        float porcentaje = 0;
        return porcentaje;
    }

    public ArrayList<Docente> DocentesMes(String mes) {
        // mes.lenght -> 2
        ArrayList<Docente> docentesMes = new ArrayList<>();
        return docentesMes;
    }

    // utilidad
    public boolean cedulaUnica(String cc) {
        Iterator<Docente> i = docentes.iterator();
        while (i.hasNext()) {
            if(i.next().getCC().equals(cc)) return false;
        }
        return true;
    }

}
