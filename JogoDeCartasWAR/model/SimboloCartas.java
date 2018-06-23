package model;

public enum SimboloCartas {
    AS(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5),
    SEIS(6),
    SETE(7),
    OITO(8),
    NOVE(9),
    DEZ(10),
    VALETE(11),
    DAMA(12),
    REI(13);

    private int simbolo;

    SimboloCartas(int simbolo) {
        this.simbolo = simbolo;
    }

    public int getValor() {
        return simbolo;
    }
}
