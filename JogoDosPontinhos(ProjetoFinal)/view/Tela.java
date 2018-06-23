package view;

import controller.Jogo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Dot;
import model.Jogador;
import model.Matriz;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Humano;

public class Tela {

    Scanner teclado = new Scanner(System.in);

    public int obterModoJogo() {
        int modo = 0;
        try {
            imprimirHeader();
            System.out.print("\nESCOLHA UM MODO DE JOGO:\n1- JOGADOR VS MAQUINA\n2- JOGADOR VS JOGADOR\n");
            System.out.print("≻ ");
            modo = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("\nOPÇÃO INVÁLIDA! ");
            modo = obterModoJogo();
        }
        return modo;
    }

    public Jogador obterJogador() {
        Humano h = new Humano();
        try {
            System.out.print("\nJOGADOR: ");
            h.setNome(teclado.nextLine().toUpperCase());
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
        return h;
    }

    public Dot obterDot(Matriz m) {
        Dot dot = null;
        do {
            System.out.print("≻ ");
            dot = m.getDotByCoordenada(teclado.nextLine().toUpperCase());
            if (dot == null) {
                System.err.println("\nESSA COORDENADA NÃO EXISTE!\nINFORME NOVAMENTE...");
                readKey();
            }
        } while (dot == null);

        return dot;
    }

    public void imprimirResultado(Jogador j1, Jogador j2, int res) {
        try {
            limpaTela();
            imprimirHeader();
            if (res == 0) {
                empate(j1, j2);
            } else {
                System.out.println("\n     --- VENCEDOR! ---    ");
                imprimirJogador(j1);
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public void empate(Jogador j1, Jogador j2) {
        System.out.println("\n        --- EMPATE! ---      ");
        System.out.println("JOGADOR: " + j1.getNome()
                + " - BOXES: " + j1.getPontos()
                + "\nJOGADOR: " + j2.getNome()
                + " - BOXES: " + j2.getPontos());
    }

    public void limpaTela() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("");
        }
    }

    public void imprimirHeader() {
        System.out.println("\n▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪");
        System.out.println("■ ● ■ .DOTS & BOXES. ● ■ ●");
        System.out.println("▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪");
    }

    public void imprimirJogador(Jogador j) {
        try {
            System.out.println("\nJOGADOR: " + j.getNome());
            System.out.println("BOXES: " + j.getPontos() + "/9");
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public void imprimir(Matriz m) {
        try {

            imprimeCabecalho();
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {//IMPRIME LINHAS TOP

                    imprimeLinhaTop(i, j, m);
                }

                System.out.print("●  ⌇");
                System.out.println("");

                for (int j = 0; j < 3; j++) {//IMPRIME LINHAS LEFT

                    imprimeLinhaLeft(i, j, m);
                }

                imprimeLinhaRight(i, 2, m);//IMPRIME LINHAS RIGHT
            }

            for (int j = 0; j < 3; j++) {//IMPRIME LINHAS BOTTOM

                imprimeLinhaBottom(2, j, m);
            }
            imprimeRodape();

        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }

    public void imprimeLinhaTop(int i, int j, Matriz m) {

        if (j == 0) {
            System.out.print((i + 1) + " ⌇  ");
        }
        if (m.getBoxByXY(i, j).getLinhaT().getValor() == 0) {
            System.out.print("●  ˒  ");
        } else {
            System.out.print("● ▬▬▬ ");
        }
    }

    public void imprimeLinhaLeft(int i, int j, Matriz m) {
        if (j == 0) {
            System.out.print("˒ ⌇ ");
        }
        if (m.getBoxByXY(i, j).getLinhaL().getValor() == 0) {
            System.out.print(" ˒    ");
        } else {
            System.out.print(" ❚    ");
        }
    }

    public void imprimeLinhaRight(int i, int j, Matriz m) {

        if (m.getBoxByXY(i, j).getLinhaR().getValor() == 1) {
            System.out.print(" ❚  ⌇");
        } else {
            System.out.print(" ˒  ⌇");
        }
        System.out.println("");
    }

    public void imprimeLinhaBottom(int i, int j, Matriz m) {
        if (j == 0) {
            System.out.print(4 + " ⌇  ");
        }
        if (m.getBoxByXY(i, j).getLinhaB().getValor() == 0) {
            System.out.print("●  ˒  ");
        } else {
            System.out.print("● ▬▬▬ ");
        }
    }

    public void imprimeCabecalho() {

        System.out.println("");
        System.out.println("     A  ˒  B  ˒  C  ˒  D   ");
        System.out.println("  ˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒");
    }

    public void imprimeRodape() {

        System.out.print("●  ⌇");
        System.out.println("\n  ˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒˒\n");
        System.out.println("\n▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪▫▪");
        System.out.println("Ex.: a1 e A2 ou a2 e A1 ");
    }

    public void readKey() {//"PAUSA" TELA
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public void instrucoes() {
        //JOptionPane.showMessageDialog(null, "■ ● ■ .DOTS & BOXES. ● ■ ●\nINFORME UMA COORDENADA\nCOMO: 'A1' E 'A2' OU 'A2' E 'A1'\n");        
    }*/
}
