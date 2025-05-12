package fachada.gui;

import fachada.modelo.Amplificador;
import fachada.modelo.Guitarra;
import fachada.modelo.Pedal;
import fachada.fachadaguitarraelectrica.FachadaGuitarraElectrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

import static fachada.gui.Utilidades.abrirVentana;


public class PaginaPrincipalControlador {
    FachadaGuitarraElectrica fachada = new FachadaGuitarraElectrica();

    @FXML
    private TableView<FachadaGuitarraElectrica> tabla;
    @FXML
    private TableColumn<Guitarra, String> columnaGuitarra;
    @FXML
    private TableColumn<Amplificador, String> columnaAmplificador;
    @FXML
    private TableColumn<Pedal, String> columnaPedal;

    public void iniciarSesion() {
        fachada.iniciarSesion();
        llenarTabla();
    }

    public void finalizarSesion() {
        fachada.finalizarSesion();
        vaciarTabla();
    }

    public void llenarTabla() {
        columnaGuitarra.setCellValueFactory(new PropertyValueFactory<>("guitarra"));
        columnaAmplificador.setCellValueFactory(new PropertyValueFactory<>("amplificador"));
        columnaPedal.setCellValueFactory(new PropertyValueFactory<>("pedal"));
        ArrayList<FachadaGuitarraElectrica> fachadas = new ArrayList<>();
        fachadas.add(fachada);
        ObservableList<FachadaGuitarraElectrica> listaFachadas = FXCollections.observableArrayList(fachadas);
        tabla.setItems(listaFachadas);
    }

    public void vaciarTabla() {
        ObservableList<FachadaGuitarraElectrica> listaFachadas = FXCollections.observableArrayList(new ArrayList<>());
        tabla.setItems(listaFachadas);
    }

    public void tocarGuitarra() {
        TocarNotasControlador controlador = abrirVentana("/TocarNotas.fxml", "Notas",
                TocarNotasControlador.class);
        assert controlador != null;
        controlador.configurarCuerdas();
        controlador.setFachada(fachada);
    }
}
