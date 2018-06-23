package pctcadastrodeanimais;

import java.util.Scanner;

public class Tela {

    Scanner read = new Scanner(System.in);
    Zoologico zoo = new Zoologico();

    int op;

    public Tela() {
        op = 0;
    }

    public int menu() {

        System.out.println("\n---Menu Principal---\n");
        System.out.println("1-Adicionar Animal\n");
        System.out.println("2-Imprimir detalhes de todos Animais\n");
        System.out.println("3-Imprimir Qtd de Animais\n");
        System.out.println("4-Emitir o Som dos Animais\n");
        System.out.println("0-Sair\n");

        op = Integer.parseInt(read.nextLine());
        return op;
    }

    public int subMenuCadAnimal() {

        System.out.println("1-Mamifero\n");
        System.out.println("2-Peixe\n");

        op = Integer.parseInt(read.nextLine());

        return op;
    }

    public void iniciarSistema() {
        do {
            op = menu();

            if (op == 1) {
                switch (subMenuCadAnimal()) {
                    case 1:
                        //adicionar Mamifero
                        zoo.inserirAnimal(inserirMamifero());

                        break;
                    case 2:
                        //adicionar Peixe
                        zoo.inserirAnimal(inserirPeixe());

                        break;
                }
            } else {
                switch (op) {
                    case 2:
                        //imprimir Detalhes de Tds Animais                        
                        imprimirTdsDetalhes(zoo);
                        break;
                    case 3:
                        //imprimir Qtd Animais
                        imprimirQtdAnimais();
                        break;
                    case 4:
                        //Emitir Som dos Animais
                        emitirSom(zoo);
                        break;
                    case 0:
                        //Sair
                        System.out.println("\nSaindo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpcao Inválida!");
                        break;
                }
            }

        } while (op != 0);
    }

    public Mamifero inserirMamifero() {

        String nome, alimento, cor;
        float comprimento, velocidade;

        System.out.println("\nInforme o Nome: ");
        nome = read.nextLine();
        System.out.println("\nInforme o Alimento: ");
        alimento = read.nextLine();
        System.out.println("\nInforme a Cor: ");
        cor = read.nextLine();
        System.out.println("\nInforme o Comprimento: ");
        comprimento = Float.parseFloat(read.nextLine());
        System.out.println("\nInforme a Velocidade(m/s): ");
        velocidade = Float.parseFloat(read.nextLine());

        return new Mamifero(alimento, nome, cor, comprimento, velocidade);
    }

    public Peixe inserirPeixe() {
        String nome;
        float comprimento, velocidade;

        System.out.println("\nInforme o Nome: ");
        nome = read.nextLine();
        System.out.println("\nInforme o Comprimento: ");
        comprimento = Float.parseFloat(read.nextLine());
        System.out.println("\nInforme a Velocidade(m/s): ");
        velocidade = Float.parseFloat(read.nextLine());

        return new Peixe(nome, comprimento, velocidade);
    }

    public void imprimirTdsDetalhes(Zoologico zoo) {

        System.out.println("\n---Animais---");

        for (int i = 0; i < zoo.buscarQtdAnimais(); i++) {
            Animal animais = zoo.buscarAnimais(i);

            if (animais instanceof Mamifero) {
                System.out.println("\n---Mamifero---");
                Mamifero m = (Mamifero) animais;
                m.imprimirDetalhes();
            } else if (animais instanceof Peixe) {
                System.out.println("\n---Peixe---");
                Peixe p = (Peixe) animais;
                p.imprimirDetalhes();
            } else {
                System.out.println("\nErro ao instanciar Animal...");
            }
        }
    }

    public void imprimirQtdAnimais() {

        System.out.println("Quantidade de Animais: " + zoo.buscarQtdAnimais());
    }

    public void emitirSom(Zoologico zoo) {
        System.out.println("\n---Sons dos Animais---\n");

        for (int i = 0; i < zoo.buscarQtdAnimais(); i++) {
            Animal animais = zoo.buscarAnimais(i);

            if (animais instanceof Mamifero) {
                System.out.println("\n---Mamifero---");
                Mamifero m = (Mamifero) animais;
                System.out.println("Nome: " + m.getNome() + " - Som: " + m.emitirSom());
            } else if (animais instanceof Peixe) {
                System.out.println("\n---Peixe---");
                Peixe p = (Peixe) animais;
                System.out.println("Nome: " + p.getNome() + " - Som: " + p.emitirSom());
            }
        }
    }
}
