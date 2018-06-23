package pctjogodedados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Jogo{    

    boolean venceu;
    int index;
    
    Tela tela = new Tela();
    
    public Jogo(){ 
        index = 0;
        venceu = false;
    }
    
    public void iniciarRodada(ListaDeJogadores listaJ){                                    
        
        tela.imprimeListaDeJogadores(listaJ.jogadores);
        do{    
            if(index == listaJ.jogadores.size()){
                index = 0;            
            }            
            tela.imprimeJogador(listaJ.jogadores.get(index));                    

            if(venceu = verificaVencedor(listaJ.jogadores.get(index).jogarDado())){
                
               tela.imprimeVencedor(listaJ.jogadores.get(index));
            }    
            index++;
            
        }while(venceu == false);
    }  
    
    public Boolean verificaVencedor(int pontos){
              
        if(pontos >= 100){                                    
            return true;                                              
        }
        return false;        
    }  
}

