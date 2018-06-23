package model;

public class Box {

    private Linha linhaR;
    private Linha linhaL;
    private Linha linhaT;
    private Linha linhaB;
    //private int qtdLinha;

    public Box(Linha lT, Linha lB, Linha lL, Linha lR) {
        setLinhaT(lT);
        setLinhaB(lB);
        setLinhaL(lL);
        setLinhaR(lR);
        //qtdLinha = 4;
    }

    public void setLinhaT(Linha linha) {
        this.linhaT = linha;
    }

    public void setLinhaB(Linha linha) {
        this.linhaB = linha;
    }

    public void setLinhaR(Linha linha) {
        this.linhaR = linha;
    }

    public void setLinhaL(Linha linha) {
        this.linhaL = linha;
    }

    public Linha getLinhaT() {
        return this.linhaT;
    }

    public Linha getLinhaB() {
        return this.linhaB;
    }

    public Linha getLinhaR() {
        return this.linhaR;
    }

    public Linha getLinhaL() {
        return this.linhaL;
    }

    public boolean preencheLinha(Linha linha) {

        if (linhaT.equals(linha) && linhaT.getValor() == 0) {
            linhaT.setValor(1);
            return true;
        }
        if (linhaB.equals(linha) && linhaB.getValor() == 0) {
            linhaB.setValor(1);
            return true;
        }
        if (linhaR.equals(linha) && linhaR.getValor() == 0) {
            linhaR.setValor(1);
            return true;
        }
        if (linhaL.equals(linha) && linhaL.getValor() == 0) {
            linhaL.setValor(1);
            return true;
        }
        return false;
    }

    public boolean estaCompleto() {
        return getLinhaT().getValor() == 1 && getLinhaB().getValor() == 1 && getLinhaR().getValor() == 1 && getLinhaL().getValor() == 1;
    }
}
