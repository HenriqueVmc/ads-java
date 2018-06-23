package pctfigurasgeometricas;

public class Quadrado extends FiguraGeometrica{

    private double base, altura;       
    
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }   
    public Quadrado(double base, double altura){
        
        setAltura(altura);
        setBase(base);
    }
}
