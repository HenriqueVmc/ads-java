package pctjogodedados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tela {

    public int obterQtdJogadores(){
        
        return Integer.parseInt(JOptionPane.showInputDialog(null,"\nQuantidade de Jogadores: "));
    }
    
    public Jogador cadastarJogadores(int i){
        Jogador j = new Jogador();        
        
        j.setNome(JOptionPane.showInputDialog("Jogador "+(i+1)+" - Nome: "));
        j.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Jogador "+(i+1)+" - Idade: ")));
        
        return j;
    }
    
    public void imprimeVencedor(Jogador j){
        JOptionPane.showMessageDialog(null,"\nParabéns " + j.getNome()+" você Venceu!\n Pontos: "+j.getPontos());
    }
    
    public void imprimeListaDeJogadores(ArrayList<Jogador> jogadores){
        int qtd = jogadores.size();
        System.out.println("\nLista de Jogadores:");            
        for(int i = 0; i < qtd; i++){
            System.out.println("\n"+jogadores.get(i).getNome()+" - "+ jogadores.get(i).getNome()+" anos");            
        }        
    }
    
    public void imprimeJogador(Jogador j){
        System.out.println("\nJogador da vez: "+j.getNome());
    }     
    
    public void imprimePontuacao(int pontos, int total){
        
        System.out.println("\nPontos: "+pontos+" - Acumulado: "+total);
    }
}
