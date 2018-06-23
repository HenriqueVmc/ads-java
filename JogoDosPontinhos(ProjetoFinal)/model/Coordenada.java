package model;

public class Coordenada {

    private static String[][] coordenada = {
        {"A1", "B1", "C1", "D1"},
        {"A2", "B2", "C2", "D2"},
        {"A3", "B3", "C3", "D3"},
        {"A4", "B4", "C4", "D4"}};

    public String getCoordenada(int x, int y) {
        return coordenada[x][y];
    }
}
