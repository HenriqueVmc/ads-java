package model;

public class Linha {

    //private int maxL, maxC;//[Matriz]super.maxL(heranca)
    private Dot dot1;
    private Dot dot2;

    private int x, y;
    private int valor;

    public Linha(Dot dot1, Dot dot2, int x, int y, int val) {
        this.setDot1(dot1);
        this.setDot2(dot2);
        this.setX(x);
        this.setY(y);
        this.setValor(val);
    }

    public void setValor(int v) {
        this.valor = v;
    }

    public int getValor() {
        return this.valor;
    }

    public void setDot1(Dot d1) {
        this.dot1 = d1;
    }

    public void setDot2(Dot d2) {
        this.dot2 = d2;
    }

    public Dot getDot1() {
        return this.dot1;
    }

    public Dot getDot2() {
        return this.dot2;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean equals(Linha l) {

        return getValor() == l.getValor() && getDot1() == l.getDot1() && getDot2() == l.getDot2() && getX() == l.getX() && getY() == l.getY();
    }
}
