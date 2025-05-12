package fachada.modelo;

import fachada.reproducir.ReproductorMP3;

public class Amplificador {
    private final String tipo;
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
