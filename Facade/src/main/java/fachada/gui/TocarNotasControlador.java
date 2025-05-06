package fachada.gui;

import fachada.prepararguitarra.FachadaGuitarraElectrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.Arrays;

public class TocarNotasControlador {
    private FachadaGuitarraElectrica fachada;
    @FXML
    private ComboBox<String> comboPrimeraCuerda;
    @FXML
    private ComboBox<String> comboSegundaCuerda;
    @FXML
    private ComboBox<String> comboTerceraCuerda;
    @FXML
    private ComboBox<String> comboCuartaCuerda;
    @FXML
    private ComboBox<String> comboQuintaCuerda;
    @FXML
    private ComboBox<String> comboSextaCuerda;
    @FXML
    private Button rockanrolea;

    public void tocarNotas() {
        String[] notas = new String[6];
        notas[0] = comboPrimeraCuerda.getValue();
        notas[1] = comboSegundaCuerda.getValue();
        notas[2] = comboTerceraCuerda.getValue();
        notas[3] = comboCuartaCuerda.getValue();
        notas[4] = comboQuintaCuerda.getValue();
        notas[5] = comboSextaCuerda.getValue();

        fachada.tocarGuitarra(notas);
    }

    public void configurarCuerdas() {
        String[] notasPosibles = {"","C", "D", "E", "F", "G", "A", "B"};
        ObservableList<String> notas = FXCollections.observableArrayList(
                Arrays.asList(notasPosibles));

        comboPrimeraCuerda.setItems(notas);
        comboSegundaCuerda.setItems(notas);
        comboTerceraCuerda.setItems(notas);
        comboCuartaCuerda.setItems(notas);
        comboQuintaCuerda.setItems(notas);
        comboSextaCuerda.setItems(notas);
    }

    public void setFachada(FachadaGuitarraElectrica fachada) {
        this.fachada = fachada;
    }
}
