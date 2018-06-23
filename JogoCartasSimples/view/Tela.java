package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Jogador;

public class Tela {

    Scanner teclado;

    public Tela() {
        teclado = new Scanner(System.in);
    }

    public Jogador obterJogador() {

        Jogador j = new Jogador();

        System.out.println("Nome do Jogador: ");
        j.setNome(teclado.nextLine());

        return j;
    }

    public int numJogadores() {

        System.out.println("Nº de Jogadores(MÍNIMO 2): ");
        return Integer.parseInt(teclado.nextLine());
    }

    public void imprimirJogada(Jogador j, Baralho baralho, Carta cRetirada) {

        System.out.println("\n--- Jogador da vez: " + j.getNome() + " ---\n");
        System.out.println("Pontos Acumulados: " + j.getPontos());
        System.out.println("Carta retirada: " + cRetirada.getSimbolo() + " de " + cRetirada.getNaipe());
        System.out.println("Qtd de cartas: " + baralho.quantidade());
    }

    public void imprimirResultado(Jogador j1, Jogador j2, int res) {
        
        System.out.println("\n---Fim de Jogo!---\n");
        if (res == 0) {
            System.out.println("Empate!\n"
                    + "Jogador: " + j1.getNome()
                    + " - Pontos: " + j1.getPontos()
                    + "\nJogador: " + j2.getNome()
                    + " - Pontos: " + j2.getPontos());
        } else {
            System.out.println("Parabéns "
                    + j1.getNome()
                    + ", Você Venceu!"
                    + "\nPontos Acumulados: "
                    + j1.getPontos());
        }
    }
}
