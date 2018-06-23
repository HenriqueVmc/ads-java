package pctcadastrodeanimais;

public abstract class Animal {

    protected String nome;
    protected float comprimento;
    protected int patas = 0;
    protected String cor;
    protected String ambiente;
    protected float velocidade;

    public Animal(String nome, String cor, String ambiente, float comprimento, float velocidade, int patas) {
        setNome(nome);
        setCor(cor);
        setAmbiente(ambiente);
        setComprimento(comprimento);
        setVelocidade(velocidade);
        setPatas(patas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public void imprimirDetalhes() {
        System.out.println("\nNome: " + getNome()
                + "\nCor: " + getCor()
                + "\nAmbiente: " + getAmbiente()
                + "\nComprimento: " + getComprimento()
                + "\nVelocidade: " + getVelocidade()
                + "\nPatas: " + getPatas());
    }

    public abstract String emitirSom();
}
