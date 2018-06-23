package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Baralho;
import model.Carta;
import model.Jogador;

public class Tela {

    Scanner teclado;

    public Tela() {
        teclado = new Scanner(System.in);
    }

    public int obterNumJogadas() {
        int numJ = 0;
        do{
            System.out.println("Informe o Número de Jogadas: ");
            numJ = Integer.parseInt(teclado.nextLine());
        }while(numJ <= 0);
        
        return numJ;
    }

    public void vencedor(Jogador j) {
        System.out.println("\nParabens Jogador " + j.getNome() + ", você venceu com "+j.getContJ()+" passos!");
    }

    public void empate(Jogador j1, Jogador j2, int numJ) {
        System.out.println("\nJogo empatado após "+numJ+" jogadas."); 
        System.out.println("\nJogador "+j1.getNome()+" - "+j1.qtdCartas()+" cartas"); 
        System.out.println("\nJogador "+j2.getNome()+" - "+j2.qtdCartas()+" cartas"); 
    }
    
    public void imprimirQtdCartas(Jogador j){
        System.out.println("\nQtdade de Cartas: " + j.qtdCartas());
    }   
}
