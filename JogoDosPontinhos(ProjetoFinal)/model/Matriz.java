package model;

import java.util.ArrayList;

public class Matriz {

    ArrayList<Dot> dots;
    ArrayList<Linha> linhasV;
    ArrayList<Linha> linhasH;
    Box[][] boxes;
    int contL;

    public Matriz() {

        contL = 24;
        dots = new ArrayList<>();
        linhasV = new ArrayList<>();
        linhasH = new ArrayList<>();
        boxes = new Box[3][3];

        criarDot();
        criarLinha();
        criarBox();
    }

//----------------- DOT -------------------
    private void criarDot() {

        Coordenada c = new Coordenada();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Dot d = new Dot(c.getCoordenada(i, j), i, j);
                dots.add(d);
            }
        }
    }

    public Dot getDotByCoordenada(String coordenada) {
        Dot dotBuscado = null;

        for (Dot d : dots) {
            if (d.getCoordenada().compareTo(coordenada) == 0) {
                dotBuscado = d;
                return dotBuscado;
            }
        }
        return dotBuscado;
    }

    public Dot getDotByXY(int x, int y) {
        Dot dotBuscado = null;

        for (Dot d : dots) {
            if (d.getX() == x && d.getY() == y) {
                dotBuscado = d;
                return dotBuscado;
            }
        }
        return dotBuscado;
    }

//----------------- LINHA -------------------
    private void criarLinha() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Linha linhaV = new Linha(getDotByXY(i, j), getDotByXY(i + 1, j), i, j, 0);
                linhasV.add(linhaV);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 3; k++) {
                Linha linhaH = new Linha(getDotByXY(i, k), getDotByXY(i, k + 1), i, k, 0);
                linhasH.add(linhaH);
            }
        }
    }

    public Linha getLinhaV(int x, int y) {
        Linha linhaBuscada = null;

        for (Linha l : linhasV) {
            if (l.getX() == x && l.getY() == y) {
                linhaBuscada = l;
                return linhaBuscada;
            }
        }
        return linhaBuscada;
    }

    public Linha getLinhaH(int x, int y) {
        Linha linhaBuscada = null;

        for (Linha l : linhasH) {
            if (l.getX() == x && l.getY() == y) {
                linhaBuscada = l;
                return linhaBuscada;
            }
        }
        return linhaBuscada;
    }

    public Linha getLinhaByDot(Dot dot1, Dot dot2) {
        Linha linhaBuscada = null;

        for (Linha lV : linhasV) {
            if (lV.getDot1().equals(dot1) && lV.getDot2().equals(dot2)
                    || lV.getDot2().equals(dot1) && lV.getDot1().equals(dot2)) {

                linhaBuscada = lV;
                return lV;
            }
        }
        for (Linha lH : linhasH) {
            if (lH.getDot1().equals(dot1) && lH.getDot2().equals(dot2)
                    || lH.getDot2().equals(dot1) && lH.getDot1().equals(dot2)) {

                linhaBuscada = lH;
                return lH;
            }
        }
        return linhaBuscada;
    }

//----------------- BOX -------------------   
    private void criarBox() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Box box = new Box(getLinhaH(i, j), getLinhaH(i + 1, j), getLinhaV(i, j), getLinhaV(i, j + 1));
                boxes[i][j] = box;
            }
        }
    }

    public ArrayList<Box> getBoxByLinha(Linha linha) {
        ArrayList<Box> boxBuscado = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boxes[i][j].getLinhaT().equals(linha)
                 || boxes[i][j].getLinhaB().equals(linha)
                 || boxes[i][j].getLinhaR().equals(linha)
                 || boxes[i][j].getLinhaL().equals(linha)) {

                    boxBuscado.add(boxes[i][j]);
                }
            }
        }
        return boxBuscado;
    }

    public ArrayList<Box> getListaBoxes() {
        ArrayList<Box> listaBox = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                listaBox.add(boxes[i][j]);
            }
        }
        return listaBox;
    }

    public Box getBoxByXY(int i, int j) {
        return boxes[i][j];
    }

    public void removeLinha() {
        this.contL--;
    }

    public int getContL() {
        return this.contL;
    }
}
