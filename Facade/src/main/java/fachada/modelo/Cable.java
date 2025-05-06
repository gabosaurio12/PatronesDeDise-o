package fachada.modelo;

public class Cable {
    private String marca;
    private String entradaA;
    private String entradaB;
    private boolean estadoEntradaA;
    private boolean estadoEntradaB;

    public Cable() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEntradaA() {
        return entradaA;
    }

    public void setEntradaA(String entradaA) {
        this.entradaA = entradaA;
    }

    public String getEntradaB() {
        return entradaB;
    }

    public void setEntradaB(String entradaB) {
        this.entradaB = entradaB;
    }

    public boolean isEstadoEntradaA() {
        return estadoEntradaA;
    }

    public void setEstadoEntradaA(boolean estadoEntradaA) {
        this.estadoEntradaA = estadoEntradaA;
    }

    public boolean isEstadoEntradaB() {
        return estadoEntradaB;
    }

    public void setEstadoEntradaB(boolean estadoEntradaB) {
        this.estadoEntradaB = estadoEntradaB;
    }

    public void conectarEntradaA(Object objeto) {
        setEntradaA(objeto.toString());
        this.estadoEntradaA = true;
    }

    public void conectarEntradaB(Object objeto) {
        setEntradaB(objeto.toString());
        this.estadoEntradaB = true;
    }

    public void desconectarEntradaA() {
        setEntradaA("");
        this.estadoEntradaA = false;
    }

    public void desconectarEntradaB() {
        setEntradaB("");
        this.estadoEntradaB = false;
    }
}
