package model;

import view.Tela;

public class Humano extends Jogador {

    @Override
    public Linha escolheLinha(Matriz matriz, Tela tela) {
        Dot dot1 = null, dot2 = null;
        Linha linha = null;

        try {
            dot1 = tela.obterDot(matriz);
            dot2 = tela.obterDot(matriz);
            linha = matriz.getLinhaByDot(dot1, dot2);
        } catch (NullPointerException e) {
            System.err.println("\nCOORDENADA INVÁLIDA!\nINFORME NOVAMENTE...");
            tela.readKey();
            linha = escolheLinha(matriz, tela);
        }
        return linha;
    }
}
