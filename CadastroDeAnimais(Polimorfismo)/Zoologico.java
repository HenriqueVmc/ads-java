package pctcadastrodeanimais;

import java.util.ArrayList;

public class Zoologico {

    ArrayList<Animal> listaDeAnimais;

    public Zoologico() {
        listaDeAnimais = new ArrayList<Animal>();
    }

    public void inserirAnimal(Animal animal) {
        listaDeAnimais.add(animal);
    }

    public Animal buscarAnimais(int index) {

        return listaDeAnimais.get(index);
    }

    public int buscarQtdAnimais() {

        return listaDeAnimais.size();
    }
}
