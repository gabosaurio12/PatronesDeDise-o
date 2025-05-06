package fachada.modelo;

import fachada.prepararguitarra.FachadaGuitarraElectrica;

public class Pedal {
    private String tipo;
    private int volumen;
    private int efecto;
    private int efectoAuxiliar;
    private boolean estado;
    private Cable cableEntrada;
    private Cable cableSalida;

    public Pedal() {
        tipo = "Overdrive";
        volumen = 5;
        efecto = 5;
        efectoAuxiliar = 5;
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

    public Cable getCableEntrada() {
        return cableEntrada;
    }

    public void setCableEntrada(Cable cableEntrada) {
        this.cableEntrada = cableEntrada;
    }

    public Cable getCableSalida() {
        return cableSalida;
    }

    public void setCableSalida(Cable cableSalida) {
        this.cableSalida = cableSalida;
    }


        public void encender() {
        this.estado = true;
    }

    public void apagar() {
        this.estado = false;
    }

    public void codificarSonido(String[] notas, FachadaGuitarraElectrica fachada) {
        String[] notasCodificadas = new String[6];
        int i = 0;
        for (String j : notas) {
            if (j == null || j.equals("")) {
                notasCodificadas[i] = "blanco.mp3";
            } else {
                notasCodificadas[i] = "Overdrive/" + j + ".mp3";
            }
            i++;
        }

        fachada.getAmplificador().emitirSonido(notasCodificadas);
    }

    @Override
    public String toString() {
        return "Pedal " + tipo;
    }
}
