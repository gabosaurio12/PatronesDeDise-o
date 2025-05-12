package fachada.modelo;

import javafx.scene.control.Alert;

public class Guitarra {
    private final int cuerdas;
    private final String marca;
    private boolean[] pastillas;
    private String afinacion;
    private Cable cable;

    public Guitarra() {
        cuerdas = 6;
        marca = "Gibson Les Paul";
        pastillas = new boolean[] {true, true};
        afinacion = "EADGBE";
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

    public void tocarNotas(String[] notas) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tocar notas en la guitarra");
        String mensaje = "Se estan tocando las notas: \n";
        for (String i : notas) {
            if (i != null) {
                mensaje = mensaje.concat(i + "\n");
            } else {
                mensaje = mensaje.concat("0\n");
            }
        }
        alert.setContentText(mensaje);
        alert.showAndWait();

        Pedal pedal = (Pedal) cable.getEntradaB();
        pedal.codificarSonido(notas);
    }

    @Override
    public String toString() {
        return "Guitarra " + marca;
    }

}
