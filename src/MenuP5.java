
import java.util.regex.Pattern;

public class MenuP5 extends Menu {

    public MenuP5(String title) {
        super(title);
    }

    @Override
    public void menu() {
        Punto5 p5 = new Punto5();
        while (true) {
            int opt;
            try {
                opt = Integer.parseInt(
                        input("Menu: \n1. Mostrar todas las tarjetas.\n" +
                                "2. Mostrar todas las tarjetas MasterCard. \n" + //
                                "3. Mostrar todas las tarjetas Visa.  \n" + //
                                "4. Mostrar todas las tarjetas con un año determinado. \n" + //
                                "5. Ingresar una tarjeta. \n" + //
                                "0. Regresar"));
            } catch (Exception e) {
                e.printStackTrace();
                // control de la excepcion.
                if (e.toString().contains("Cannot parse null string"))
                    return;
                msg("Se necesita una opcion valida.");
                continue;
            }

            switch (opt) {

                case 0: { // Regresar
                    return;
                }

                case 1: // mostrar todas las tarejtas
                    msgScroll(p5.MostrarTrajetas());
                    break;

                case 2: // mostrar las tarjetas mastercard
                    msgScroll(p5.MostrarMasterCard());
                    break;

                case 3:// mostrar las tarjetas visa
                    msgScroll(p5.MostrarVisa());
                    break;

                case 4:// mostrar las tarjetas con un año determinado
                    String año = Validaciones("\\d{2}", "Ingrese el año");
                    System.out.println(p5.TarjetasAño(año));
                    break;

                case 5: // ingresar una tarjeta nueva
                    String numero = ValidacionNumero(p5);
                    String fecha = Validaciones("(\\d{2}[/]\\d{2})", "Ingrese la fecha (mm/yy)");
                    String codigo = Validaciones("\\d{3}", "Ingrese el codigo (numero de 3 digitos)");
                    String tipo = Validaciones("(MasterCard|Visa)", "Ingrese el tipo de tarjeta (MaterCard o Visa)");
                    String nombre = Validaciones(".+", "Ingrese el nombre del dueño de la tarjeta").trim();
                    String apellido = Validaciones(".+", "Ingrese el apellido del dueño de la tarjeta").trim();
                    p5.Ingresar(nombre, apellido, numero, fecha, codigo, tipo);
                    msg("Se a ingresado exitosamente");
                    break;

                default:
                    break;
            }
        }
    }

    public String Validaciones(String patron, String msginput) {// metodo para realizar todas las valdiaciones con expresiones regulares
        Pattern Patron = Pattern.compile(patron);
        String input;
        while (true) {
            input = input(msginput);
            if (!Patron.matcher(input).matches()) { // validar el formato correcto
                msg("Formato invalido");
            } else
                return input;
        }
    }

    public String ValidacionNumero(Punto5 p5) {// metodo para validar el numero de una tarjeta
        String input;
        while (true) {
            input = Validaciones("\\d{16}", "Ingrese el numero de la tarjeta (numero de 16 digitos)");
            if (!p5.TarjetaNueva(input)) { // validar de que sea un numero nuevo
                msg("La tarjeta ya existe");
            } else
                return input;
        }
    }
}
