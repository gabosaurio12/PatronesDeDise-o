package fachada.prepararguitarra;

import fachada.modelo.Amplificador;
import fachada.modelo.Cable;
import fachada.modelo.Guitarra;
import fachada.modelo.Pedal;

public class FachadaGuitarraElectrica {
    private Pedal pedal;
    private Amplificador amplificador;
    private Guitarra guitarra;

    public FachadaGuitarraElectrica() {
        pedal = new Pedal();
        amplificador = new Amplificador();
        guitarra = new Guitarra();
    }

    public Pedal getPedal() {
        return pedal;
    }

    public void setPedal(Pedal pedal) {
        this.pedal = pedal;
    }

    public Amplificador getAmplificador() {
        return amplificador;
    }

    public void setAmplificador(Amplificador amplificador) {
        this.amplificador = amplificador;
    }

    public Guitarra getGuitarra() {
        return guitarra;
    }

    public void setGuitarra(Guitarra guitarra) {
        this.guitarra = guitarra;
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
        guitarra.tocarNotas(notas, this);
    }
}
