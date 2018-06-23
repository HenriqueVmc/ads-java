package pctcadastrodeanimais;

public class Sistema {

    public void iniciar() {

        Tela tela = new Tela();        
        tela.iniciarSistema();
    }

    public static void main(String[] args) {
        
        Sistema s = new Sistema();
        s.iniciar();
    }
}
