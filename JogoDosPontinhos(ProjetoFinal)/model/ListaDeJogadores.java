package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaDeJogadores {

    private final ArrayList<Jogador> listaJogadores;

    public ListaDeJogadores() {
        listaJogadores = new ArrayList<>();
    }

    public void addJogador(Jogador j) {
        this.listaJogadores.add(j);
    }

    public ArrayList<Jogador> obterTodosJogadores() {
        return listaJogadores;
    }

    public ArrayList<Jogador> obterListaOrdenadaPontos() {
        Collections.sort(listaJogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                if (j1.getPontos() > j2.getPontos()) {
                    return -1;
                }
                if (j1.getPontos() < j2.getPontos()) {
                    return 1;
                }
                return 0;
            }
        });
        return listaJogadores;
    }
}
