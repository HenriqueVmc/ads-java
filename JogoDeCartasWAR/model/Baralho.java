package model;

import java.util.ArrayList;
import java.util.Collections;

public final class Baralho {

    private ArrayList<Carta> cartas;
    

    public Baralho() {
        cartas = new ArrayList<Carta>();                
        criarCartas();
        embaralhar();                
    }

    private void criarCartas() {

        for (Naipe n : Naipe.values()) {
            for (SimboloCartas s : SimboloCartas.values()) {
                Carta c = new Carta(n, s);
                adicionarCarta(c);
            }
        }
    }

    public void adicionarCarta(Carta c) {
        cartas.add(c);
    }

    public Carta retirarCarta() {
        return cartas.remove(0);
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public int quantidade() {
        return cartas.size();
    }     
}
