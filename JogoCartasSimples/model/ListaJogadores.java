package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaJogadores {

    private final ArrayList<Jogador> listaJogadores;

    public ListaJogadores() {
        listaJogadores = new ArrayList<Jogador>();
    }

    public void adicionarJogador(Jogador j) {
        this.listaJogadores.add(j);
    }

    public ArrayList<Jogador> obterProximoJogador() {
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
