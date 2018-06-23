package model;

import view.Tela;

public abstract class Jogador {

    private String nome;
    private int pontos;

    public Jogador() {
        pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean ganhou(Jogador j2) {

        return getPontos() > j2.getPontos();
    }

    public abstract Linha escolheLinha(Matriz matriz, Tela tela);

}
