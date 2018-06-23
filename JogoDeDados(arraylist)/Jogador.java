package pctjogodedados;

import java.util.ArrayList;

public class Jogador {
  
    private String nome;
    private int idade;
    private int pontos;
    
    Tela tela = new Tela();
           
    public Jogador(){       
        
        this.idade = 0;
        this.nome = null;
        this.pontos = 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }  
    
    public int getPontos() {
        return pontos;
    }
    
    public void setPontos(int pontos) {
        
        this.pontos += pontos;        
    }  
    
    public int jogarDado(){
        Dado d = new Dado();
        int p = 0;
        do{
            p = d.pontuacao();
            setPontos(p);    
            
            tela.imprimePontuacao(p, getPontos());           
            
        }while((p == 6) || (p == 1));           
        
        return getPontos();
    }        
}
