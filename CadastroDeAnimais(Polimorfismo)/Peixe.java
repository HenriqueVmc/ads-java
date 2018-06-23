package pctcadastrodeanimais;

public class Peixe extends Animal {

    private String caracteristica;

    public Peixe(String nome, float comprimento, float velocidade) {
        super(nome, "Cinza", "Mar", comprimento, velocidade, 0);
        setCaracteristica("Barbatanas e Caldas");
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String emitirSom() {
        return "glub glub";
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println("\nCaracteristica: " + getCaracteristica());
    }

}
