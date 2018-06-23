package controler;

import java.util.ArrayList;
import model.Baralho;
import model.Carta;
import model.Jogador;
import view.Tela;

public class Jogo {

    Baralho baralho;
    Tela tela = new Tela();
    Jogador j1 = new Jogador();
    Jogador j2 = new Jogador();
    int numJ;//Num de Jogadas Informado

    ArrayList<Carta> monteJ1, monteJ2;

    public void iniciar() {
        numJ = 0;
        baralho = new Baralho();

        j1.setNome("1");
        monteJ1 = new ArrayList<Carta>();

        j2.setNome("2");
        monteJ2 = new ArrayList<Carta>();

        preencheMontes();
        iniciarRodadas();        
    }

    public void preencheMontes() {
        do {
            j1.setCarta(baralho.retirarCarta());
            j2.setCarta(baralho.retirarCarta());
        } while (baralho.quantidade() > 0);
    }

    public void iniciarRodadas() {

        numJ = tela.obterNumJogadas();

        while (numJ > j1.getContJ() && j1.qtdCartas() > 0 && j2.qtdCartas() > 0) {
            
            monteJ1.add(j1.virarCarta());
            monteJ2.add(j2.virarCarta());
            
            vencedorDaRodada();
            
            monteJ1.clear();
            monteJ2.clear();
        }
        analisarResultado();
    }

    public void vencedorDaRodada() {

        Jogador vencedor = null;
        int cartaVirada = 0;
        
        do {
            if (monteJ1.get(cartaVirada).isMaior(monteJ2.get(cartaVirada))) {
                vencedor = j1;
                j1.roubaMonte(monteJ2);                
                j1.roubaMonte(monteJ1);
                //tela.imprimirQtdCartas(j1);

            } else if (monteJ2.get(cartaVirada).isMaior(monteJ1.get(cartaVirada))) {
                vencedor = j2;
                j2.roubaMonte(monteJ1);
                j2.roubaMonte(monteJ2);
                //tela.imprimirQtdCartas(j2);

            } else {

                int cartasDaWAR = 0;//Cada Jogador vira + 2 Cartas durante a WAR

                //System.out.println("\n--- !!! WAR !!! ---");

                while (j1.qtdCartas() > 0 && cartasDaWAR < 2) {
                    monteJ1.add(j1.virarCarta());
                    monteJ2.add(j2.virarCarta());
                    cartasDaWAR++;
                }
                cartasDaWAR = 0;
                cartaVirada++;
            }
        } while (vencedor == null);
    }

    public void analisarResultado() {
        if (j1.qtdCartas() <= 0) {
            tela.vencedor(j2);
        } else if (j2.qtdCartas() <= 0) {
            tela.vencedor(j1);
        } else {
            tela.empate(j1, j2, numJ);
        }
    }    
}
