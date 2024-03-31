import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Punto3 {

    private ArrayList<Docente> docentes;

    public Punto3() {
        docentes = new ArrayList<>();
    }

    public Punto3(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public void DocentesDePrueba() {
        try {
            FileManager fm = new FileManager("Docentes.txt");
            ArrayList<String> lineas = fm.readFileArrayList();
            Iterator<String> i = lineas.iterator();
            while (i.hasNext()) {
                String[] d = i.next().split(",");
                docentes.add(new Docente(d[0], d[1], d[2], Integer.parseInt(d[3])));
                System.out.println("Se añadio a -> " + Arrays.stream(d).toList());
            }
        } catch (Exception e) {
            System.out.println("[x] No se ha podido cargar los docentes de prueba");
            e.printStackTrace();
        }
    }

    // -- metodos --
    // nuevo docente
    public void nuevoDocente(Docente d) {
        docentes.add(d);
    }

    // busqueda
    public double porcentajeTipo(String tipo) {
        if (docentes.isEmpty()) return 0;

        double porcentaje = 0;
        Iterator<Docente> i = docentes.iterator();
        while (i.hasNext()) {
            porcentaje += i.next().getTipo().equals(tipo) ? 1 : 0;
        }
        return (porcentaje / docentes.size()) * 100;
    }

    public ArrayList<Docente> DocentesMes(String mes) {
        // mes.lenght -> 2
        ArrayList<Docente> docentesMes = new ArrayList<>();
        Iterator<Docente> i = docentes.iterator();
        while (i.hasNext()) {
            Docente d = i.next();
            if (d.getFecha().split("-")[1].equals(mes))
                docentesMes.add(d);
        }

        return docentesMes;
    }

    // utilidad
    public boolean cedulaUnica(String cc) {
        Iterator<Docente> i = docentes.iterator();
        while (i.hasNext()) {
            if (i.next().getCC().equals(cc)) return false;
        }
        return true;
    }

    public int intentos() {
        if (docentes.isEmpty()) return 0;

        int intentos = 0;
        Iterator<Docente> i = docentes.iterator();
        while (i.hasNext()) {
            intentos += i.next().getIntentos();
        }
        return intentos;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }
}
