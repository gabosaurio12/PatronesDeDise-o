package fachada.fachadaguitarraelectrica;

import fachada.modelo.Amplificador;
import fachada.modelo.Cable;
import fachada.modelo.Guitarra;
import fachada.modelo.Pedal;

public class FachadaGuitarraElectrica {
    private final Pedal pedal;
    private final Amplificador amplificador;
    private final Guitarra guitarra;

    public FachadaGuitarraElectrica() {
        pedal = new Pedal();
        amplificador = new Amplificador();
        guitarra = new Guitarra();
    }

    public Pedal getPedal() {
        return pedal;
    }

    public Amplificador getAmplificador() {
        return amplificador;
    }

    public Guitarra getGuitarra() {
        return guitarra;
    }

    public void conectarInstrumentos() {
        Cable guitarraCable = new Cable();
        guitarraCable.conectarEntradaA(guitarra);
        guitarraCable.conectarEntradaB(pedal);
        pedal.setCableEntrada(guitarraCable);
        guitarra.setCable(guitarraCable);
        Cable amplificadorCable = new Cable();
        amplificadorCable.conectarEntradaA(pedal);
        amplificadorCable.conectarEntradaB(amplificador);
        pedal.setCableSalida(amplificadorCable);
    }

    public void desconectarInstrumentos() {
        Cable guitarraCable = guitarra.getCable();
        guitarraCable.desconectarEntradaA();
        guitarraCable.desconectarEntradaB();
        pedal.setCableEntrada(null);
        guitarra.setCable(null);
        Cable amplificadorCable = new Cable();
        amplificadorCable.desconectarEntradaA();
        amplificadorCable.desconectarEntradaB();
        pedal.setCableSalida(null);
    }

    public void iniciarSesion() {
        conectarInstrumentos();
        guitarra.setAfinacion("EADGBE");
        pedal.encender();
        amplificador.encender();
    }

    public void finalizarSesion() {
        desconectarInstrumentos();
        pedal.apagar();
        amplificador.apagar();
    }

    public void tocarGuitarra(String[] notas) {
        guitarra.tocarNotas(notas);
    }
}
