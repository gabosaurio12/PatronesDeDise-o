package fachada.modelo;

import fachada.reproducir.ReproductorMP3;

public class Amplificador {
    private String tipo;
    private int volumen;
    private int efecto;
    private int efectoAuxiliar;
    private boolean estado;
    private Cable cable;

    public Amplificador() {
        tipo = "VOX";
        volumen = 5;
        efecto = 0;
        efectoAuxiliar = 0;
        estado = false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }

    public int getEfectoAuxiliar() {
        return efectoAuxiliar;
    }

    public void setEfectoAuxiliar(int efectoAuxiliar) {
        this.efectoAuxiliar = efectoAuxiliar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cable getCable() {
        return cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }

    public void encender() {
        this.estado = true;
    }

    public void apagar() {
        this.estado  = false;
    }

    public void emitirSonido(String[] notas) {
        ReproductorMP3 reproductorMP3 = new ReproductorMP3();
        for (String i : notas) {
            if (!"blanco.mp3".equals(i)) {
                reproductorMP3.reproducir(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Amplificador " + tipo;
    }
}
