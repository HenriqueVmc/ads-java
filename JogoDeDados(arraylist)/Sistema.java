package pctjogodedados;

public class Sistema {
    
    Tela tela = new Tela();
    ListaDeJogadores listaJ = new ListaDeJogadores();    
    Jogador j = new Jogador();
    Jogo jogo = new Jogo();
    
    public void iniciarSistema(){
        //if(tela.menu() == 1){
            int qtd = tela.obterQtdJogadores();                      

            for(int i = 0; i < qtd; i++){
                listaJ.addJogador(tela.cadastarJogadores(i));
                    //j = listaJ.getJogador(i);
                System.out.println("\nJogador "+listaJ.getJogador(i).getNome()+" Cadastrado! ");                
            }            
            jogo.iniciarRodada(listaJ);
        /*}else
            System.exit(0);*/
    }
    
    public static void main(String arg[]) {
        
      Sistema s = new Sistema();
      s.iniciarSistema();
    }
}
