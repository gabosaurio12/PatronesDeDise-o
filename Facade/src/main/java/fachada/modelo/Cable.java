package fachada.modelo;

public class Cable {
    private String marca;
    private Object entradaA;
    private Object entradaB;
    private boolean estadoEntradaA;
    private boolean estadoEntradaB;

    public Cable() {
    }

    public Object getEntradaB() {
        return entradaB;
    }

    public void setEntradaB(Object entradaB) {
        this.entradaB = entradaB;
    }

    public void setEntradaA(Object entradaA) {
        this.entradaA = entradaA;
    }

    public void conectarEntradaA(Object objeto) {
        setEntradaA(objeto);
        this.estadoEntradaA = true;
    }

    public void conectarEntradaB(Object objeto) {
        setEntradaB(objeto);
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
