package model;


public class Dot {

    private String coordenada;
    private int x, y;

    public Dot(String c, int x, int y) {
        setCoordenada(c);
        setX(x);
        setY(y);
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String c) {
        this.coordenada = c;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    private boolean isAdj(Dot dot2) {

        if ((getX() == 0 && dot2.x == getX() + 1)
                || (getY() == 0 && dot2.y == getY() + 1)) {
            return true;
        }

        if ((getX() == 4 && dot2.x == getX() - 1)
                || (getY() == 4 && dot2.y == getY() - 1)) {
            return true;

        } else if ((getX() < 4 && dot2.x == getX() + 1)
                || (getX() < 4 && dot2.x == getX() - 1)
                || (getY() < 4 && dot2.y == getY() + 1)
                || (getY() < 4 && dot2.y == getY() - 1)) {
            return true;
        }

        return false;
    }

    private boolean equals(Dot d) {

        if (getCoordenada() == d.getCoordenada() && getX() == d.getX() && getY() == d.getY()) {
            return true;
        }
        return false;
    }
}
