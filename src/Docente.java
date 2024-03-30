public class Docente {
    private String CC;
    private String tipo;
    private String fecha;
    private int intentos;

    public Docente(String CC, String tipo, String fecha, int intentos) {
        this.CC = CC;
        this.tipo = tipo;
        this.fecha = fecha;
        this.intentos = intentos;
    }

    public Docente(Docente d) {
        this.CC = d.getCC();
        this.tipo = d.getTipo();
        this.fecha = d.getFecha();
        this.intentos = d.getIntentos();
    }

    // Getters and Setters
    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
