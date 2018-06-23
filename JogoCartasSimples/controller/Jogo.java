package controller;

import java.util.ArrayList;
import model.Baralho;
import model.Carta;
import model.Jogador;
import model.ListaJogadores;

import view.Tela;

public class Jogo {

    ListaJogadores jogadores = new ListaJogadores();
    Baralho baralho;
    Tela telaSistema = new Tela();

    public void iniciar() {
        baralho = new Baralho();
        adicionarJogadores();
        iniciarRodadas();
    }

    private void iniciarRodadas() {
        do {
            for (Jogador jAtual : jogadores.obterProximoJogador()) {

                if (baralho.quantidade() > 0) {
                    Carta cRetirada = baralho.retirarCarta();
                    
                    jAtual.addPontos(cRetirada);
                    //log das operacoes
                    telaSistema.imprimirJogada(jAtual, baralho, cRetirada);
                }
            }
        } while (baralho.quantidade() > 0);

        analisarResultadoJogo();
    }

    private void adicionarJogadores() {
        int numJ = 0;
        do {
            numJ = telaSistema.numJogadores();
        } while (numJ < 2);

        for (int i = 0; i < numJ; i++) {
            jogadores.adicionarJogador(telaSistema.obterJogador());
        }
    }

    public void analisarResultadoJogo() {

        ArrayList<Jogador> listaJ = jogadores.obterListaOrdenadaPontos();
        Jogador primeiro = listaJ.get(0);
        Jogador segundo = listaJ.get(1);
       
        if(primeiro.ganhou(segundo)){
            telaSistema.imprimirResultado(primeiro, null, 1);
        } else{
            telaSistema.imprimirResultado(primeiro, segundo, 0);
        }
                        
       /* 
        Não fazer isso...
        if (jogadores.obterListaOrdenadaPontos().get(0).getPontos() == jogadores.obterListaOrdenadaPontos().get(1).getPontos()) {
            //EMPATE
            telaSistema.imprimirResultado(jogadores.obterListaOrdenadaPontos(), 0);
        } //VITORIA
        else {
            telaSistema.imprimirResultado(jogadores.obterListaOrdenadaPontos(), 1);
        }
        */
    }
}
