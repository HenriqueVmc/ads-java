package model;

public class Jogador {

    private String nome;
    private int pontos;

    public Jogador() {
        pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        
        this.pontos += pontos;
    }

    public int getPontos() {
        return pontos;
    }
    
    public void addPontos(Carta c){
        setPontos(c.getValor());
    }
    
    public boolean ganhou(Jogador j2){

        if(getPontos() > j2.getPontos()){
            
            return true;
        }
        else
            return false;
    }
}
