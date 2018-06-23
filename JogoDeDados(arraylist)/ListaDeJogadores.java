package pctjogodedados;

import java.util.ArrayList;

public class ListaDeJogadores {
    
    ArrayList<Jogador> jogadores;
    public ListaDeJogadores(){
        jogadores = new ArrayList<Jogador>();
    }
    
    public Boolean addJogador(Jogador j){
        
        jogadores.add(j);                        
        return true;
    }
    
    public Jogador getJogador(int index){
        
        Jogador j = jogadores.get(index);
        return j;
    }
}
