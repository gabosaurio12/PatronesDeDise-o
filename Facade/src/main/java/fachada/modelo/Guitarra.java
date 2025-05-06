package fachada.modelo;

import fachada.prepararguitarra.FachadaGuitarraElectrica;
import javafx.scene.control.Alert;

public class Guitarra {
    private int cuerdas;
    private String marca;
    private boolean[] pastillas;
    private String afinacion;
    private Cable cable;

    public Guitarra() {
        cuerdas = 6;
        marca = "Gibson Les Paul";
        pastillas = new boolean[] {true, true};
        afinacion = "EADGBE";
    }

    public int getCuerdas() {
        return cuerdas;
    }

    public void setCuerdas(int cuerdas) {
        this.cuerdas = cuerdas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean[] getPastillas() {
        return pastillas;
    }

    public void setPastillas(boolean[] pastillas) {
        this.pastillas = pastillas;
    }

    public String getAfinacion() {
        return afinacion;
    }

    public void setAfinacion(String afinacion) {
        this.afinacion = afinacion;
    }

    public Cable getCable() {
        return cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }

    public void tocarNotas(String[] notas, FachadaGuitarraElectrica fachada) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tocar notas en la guitarra");
        String mensaje = "Se estan tocando las notas: \n";
        for (String i : notas) {
            if (i != null) {
                mensaje = mensaje.concat(i + "\n");
            } else {
                mensaje = mensaje.concat("\n");
            }
        }
        alert.setContentText(mensaje);
        alert.showAndWait();

        fachada.getPedal().codificarSonido(notas, fachada);
    }

    @Override
    public String toString() {
        return "Guitarra " + marca;
    }

}
