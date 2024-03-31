import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class MenuP3 extends Menu {
    public MenuP3(String title) {
        super(title);
    }

    public void menu() {
        Punto3 p3 = new Punto3();
        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(input("Menu 😁: \n1. Añadir nuevo docente \n2. Buscar procentaje de docentes por tipo. \n3. Buscar docentes con un mes. \n4. Mostrar los docentes. \n5. Mostrar total de intentos. \n6. Docentes de prueba\n0. Salir."));
            } catch (Exception e) {
                e.printStackTrace();
                // control de la excepcion.
                if (e.toString().contains("Cannot parse null string")) return;
                msg("Se necesita una opcion valida.");
                continue;
            }


            String tipo;
            boolean continuar;
            try {


                switch (opt) {
                    case 0: {
                        return;
                    } // Quit

                    case 1: // añadir un docente

                        // patrones
                        Pattern patronCC = Pattern.compile("[0-9]{6,10}");
                        Pattern patronFecha = Pattern.compile("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})"); // (dd)-(mm)-(mmmm)

                        String CC;
                        int intentos = 0;

                        do {
                            CC = input("Ingresa la cedula del docente (de 6 a 10 numeros seguidos, sin puntos ni comas): ").trim();
                            continuar = !patronCC.matcher(CC).matches();
                            if (continuar) {
                                msg("La cedula no coincide con el formato!");
                                intentos++;
                            }
                        } while (continuar);

                        if (!p3.cedulaUnica(CC)) {
                            msg("La cedula ya existe!");
                            break;
                        }

                        String fecha;
                        do {
                            fecha = input("Ingrese la fecha (dd-mm-aaaa): ").trim();
                            continuar = !patronFecha.matcher(fecha).matches();
                            if (continuar) msg("la fecha no coincide con el formato!");
                        } while (continuar);

                        tipo = tipoDocente();
                        p3.nuevoDocente(new Docente(CC, tipo, fecha, intentos));
                        break;

                    case 2: // Buscar procentaje tipo
                        tipo = tipoDocente();
                        msg("El porcentaje de los docentes " + (tipo.equals("ocasional") ? " " : "de ") + tipo + " son: " + p3.porcentajeTipo(tipo) + "%");
                        break;

                    case 3: // Buscar mes
                        String mes;
                        Pattern patronMes = Pattern.compile("0[1-9]|1[0-2]");

                        do {
                            mes = input("Escriba el mes en formato numerico (01 - 12 y sin espacioes)").trim();
                            continuar = !patronMes.matcher(mes).matches();
                            if (continuar) msg("El mes no cuenta con el formato adecuado");
                        } while (continuar);

                        ArrayList<Docente> docentesMes = p3.DocentesMes(mes);
                        mostrarDocentes(docentesMes);
                        break;

                    case 4: // mostrar todos los docentes
                        ArrayList<Docente> docentes = p3.getDocentes();
                        mostrarDocentes(docentes);
                        break;

                    case 5: // equivocaciones
                        msg("El total de intentos de cedula fueron: " + p3.intentos());
                        break;

                    case 6:// añadir los docentes de prueba.
                        p3.DocentesDePrueba();
                        break;

                    default:
                        msg("opcion invalida.");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void mostrarDocentes(ArrayList<Docente> docentes) {
        if (!docentes.isEmpty()) {
            Iterator<Docente> i = docentes.iterator();
            StringBuilder sb = new StringBuilder();
            while (i.hasNext()) {
                Docente d = i.next();
                sb.append("Docente 🧔: ").append("\n\tCC: " + d.getCC() + "\n\tTipo:" + d.getTipo() + "\n\tFecha: " + d.getFecha() + "\n\tIntentos: " + d.getIntentos() + "\n");

            }
            msgScroll(sb.toString());
        } else msg("No hay docentes");
    }

    private String tipoDocente() {
        String[] tipos = {"planta", "ocasional", "catedra"};

        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(input("Escoja el tipo de docente: \n1. Docente de Planta 🌿. \n2. Docente Ocasional 🎱. \n3. Docente de Cátedra ⛪."));
            } catch (Exception e) {
                msg("Opcion no identificada");
                continue;
            }
            if (opt >= 1 && opt <= 3) {
                return tipos[opt - 1];
            }
            msg("Opcion invalida.");
        }
    }

}
