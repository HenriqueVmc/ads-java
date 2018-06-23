
package model;

public enum Naipe {
    ESPADAS(1),
    COPAS(2),
    PAUS(3),
    OUROS(4);

    private int naipe;

    Naipe(int naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return naipe;
    }
}
