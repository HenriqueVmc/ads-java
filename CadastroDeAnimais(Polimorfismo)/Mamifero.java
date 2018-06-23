package pctcadastrodeanimais;

public class Mamifero extends Animal {

    private String alimento;

    public Mamifero(String alimento, String nome, String cor, float comprimento, float velocidade) {
        super(nome, cor, "terra", comprimento, velocidade, 4);
        setAlimento(alimento);
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    @Override
    public String emitirSom() {

        return "César... está em casa";
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println("\nAlimento: " + getAlimento());
    }
}
