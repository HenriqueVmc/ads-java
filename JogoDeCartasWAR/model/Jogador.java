package model;

import java.util.ArrayList;

public class Jogador {

    private String nome;
    private ArrayList<Carta> monte;
    private int cont;
    
    public Jogador() {            
        cont = 0;
        monte = new ArrayList<>(52);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carta getCarta(){
        return monte.remove(0);
    }
    
    public void setCarta(Carta c){
        monte.add(c);        
    }            

    public int qtdCartas(){        
        return monte.size();             
    }
    
    public void setContJ(){        
        this.cont +=1;
    }
    
    public int getContJ(){        
        return cont;
    }                
    
     public void roubaMonte(ArrayList<Carta> monte) {
        while (monte.size() > 0) {
            setCarta(monte.remove(0));
            //System.out.println("\nJogador: " + getNome() + " Roubou a carta");
        }        
    }
     
    public Carta virarCarta() {
        Carta cRetirada = null;
        if (qtdCartas() > 0) {
            cRetirada = getCarta();
            setContJ();//incrementa jogada
            //System.out.println("\nJogador: " +getNome() + " Carta Virada: " + cRetirada.getSimbolo().getValor());
        }
        return cRetirada;
    }
}
