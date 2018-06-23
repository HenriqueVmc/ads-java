package controller;

import java.util.ArrayList;
import model.Box;
import model.Dot;
import model.Jogador;
import model.Linha;
import model.ListaDeJogadores;
import model.Maquina;
import model.Matriz;
import model.ModoDeJogo;
import view.Tela;

public class Jogo {

    Tela tela;
    ListaDeJogadores listaJ;
    Matriz matriz;
    ArrayList<Box> boxesDaRodada;
    Dot dot1, dot2;
    Linha linha;    

    public Jogo() {
        tela = new Tela();
        listaJ = new ListaDeJogadores();
        boxesDaRodada = new ArrayList<>();           
    }

    public void iniciar() {
        matriz = new Matriz();
        addJogadores(tela.obterModoJogo());
        iniciarRodadas();
    }

    private void addJogadores(int modo) {
        int ModoMaquina = ModoDeJogo.MAQUINA.getModoDeJogo();//ModoMaquina trata-se de uma Constante
        if (modo == ModoMaquina) {

            listaJ.addJogador(tela.obterJogador());
            Maquina m = new Maquina();
            listaJ.addJogador(m);
        } else {
            for (int i = 0; i < 2; i++) {
                listaJ.addJogador(tela.obterJogador());
            }
        }
    }

    private void iniciarRodadas() {
        while (matriz.getContL() > 0) {
            for (Jogador jAtual : listaJ.obterTodosJogadores()) {
                if (matriz.getContL() > 0) {
                    jogada(jAtual);
                }
            }
        }
        analisarResultado();
    }

    private void jogada(Jogador j) {
        boolean linhaPreenchida = false;
        do {
            tela.limpaTela();
            boxesDaRodada.clear();
            tela.imprimirHeader();
            tela.imprimirJogador(j);
            tela.imprimir(matriz);
            try {
                linha = j.escolheLinha(matriz, tela);
                boxesDaRodada = matriz.getBoxByLinha(linha);
                linhaPreenchida = boxesDaRodada.get(0).preencheLinha(linha);

                if (!linhaPreenchida) {
                    System.err.println("\nESSA LINHA JA FOI PREENCHIDA!\nINFORME OUTRA...");
                    tela.readKey();
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("\nOS PONTOS DEVEM SER ADJASCENTES!\nINFORME NOVAMETE...");
                tela.readKey();
            }
        } while (!linhaPreenchida);
        matriz.removeLinha();

        if (verificarBoxPreenchido(j) && matriz.getContL() > 0) {//JOGA NOVAMENTE
            jogada(j);
        }
    }

    private boolean verificarBoxPreenchido(Jogador j) {
        boolean jogarNovamente = false;
        for (Box box : boxesDaRodada) {
            if (box.estaCompleto()) {
                j.setPontos(1);
                jogarNovamente = true;
                System.out.println(j.getNome() + " PREENCHEU UM BOX!");
                tela.readKey();
            }
        }
        return jogarNovamente;
    }

    private void analisarResultado() {

        ArrayList<Jogador> jogadores = listaJ.obterListaOrdenadaPontos();
        Jogador primeiro = jogadores.get(0);
        Jogador segundo = jogadores.get(1);

        if (primeiro.ganhou(segundo)) {
            tela.imprimirResultado(primeiro, null, 1);
        } else {
            tela.imprimirResultado(primeiro, segundo, 0);
        }
    }
}
