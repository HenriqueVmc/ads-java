package pctfigurasgeometricas;

public class Circulo extends FiguraGeometrica{

    private double raio;
    
    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }
    public Circulo(double raio){
        setRaio(raio);
    }
   
}
