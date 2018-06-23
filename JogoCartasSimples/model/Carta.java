package model;

public class Carta {

    private final Naipe naipe;
    private final SimboloCartas simbolo;

    public Carta(Naipe naipe, SimboloCartas simbolo) {
        this.naipe = naipe;
        this.simbolo = simbolo;
    }

    public SimboloCartas getSimbolo() {
        return simbolo;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public int getValor() {
        
        return getSimbolo().getValor();        
    }
}
