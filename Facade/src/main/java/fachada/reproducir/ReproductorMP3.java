package fachada.reproducir;

import javazoom.jl.player.Player;

import java.io.InputStream;

public class ReproductorMP3 {
    public void reproducir(String path) {
        try {
            InputStream archivo = getClass().getClassLoader().getResourceAsStream(path);
            Player reproductor = new Player(archivo);
            reproductor.play();
        } catch (Exception e) {
            System.err.println("Error al reproducir MP3: " + e.getMessage());
        }
    }
}

