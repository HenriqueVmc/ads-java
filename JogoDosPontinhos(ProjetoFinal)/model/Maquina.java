package model;

import view.Tela;

public class Maquina extends Jogador {

    public Maquina() {
        super.setNome("MÁQUINA");
    }

    @Override
    public Linha escolheLinha(Matriz matriz, Tela tela) {

        Linha linha = null;

        try {
            linha = verificaBoxQuaseCompleto(matriz);

            if (linha == null) {
                for (Box box : matriz.getListaBoxes()) {

                    if (box.getLinhaT().getValor() == 0) {
                        linha = box.getLinhaT();
                        break;
                    } else if (box.getLinhaL().getValor() == 0) {
                        linha = box.getLinhaL();
                        break;
                    } else if (box.getLinhaR().getValor() == 0) {
                        linha = box.getLinhaR();
                        break;
                    } else if (box.getLinhaB().getValor() == 0) {
                        linha = box.getLinhaB();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("ERRO.:" + e);
        }
        return linha;
    }

    private Linha verificaBoxQuaseCompleto(Matriz matriz) {
        Linha linha = null;
        int contLinha = 0;
        for (Box box : matriz.getListaBoxes()) {

            if (box.getLinhaT().getValor() == 0) {
                linha = box.getLinhaT();
                contLinha++;
            }
            if (box.getLinhaL().getValor() == 0) {
                linha = box.getLinhaL();
                contLinha++;
            }
            if (box.getLinhaR().getValor() == 0) {
                linha = box.getLinhaR();
                contLinha++;
            }
            if (box.getLinhaB().getValor() == 0) {
                linha = box.getLinhaB();
                contLinha++;
            }
            if (contLinha == 1) {
                return linha;
            }
            contLinha = 0;
        }
        return null;
    }
}
