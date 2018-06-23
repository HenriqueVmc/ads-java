package pctfigurasgeometricas;

public abstract class FiguraGeometrica {
    
    public double calcularArea(Quadrado q){
        return q.getAltura() * q.getBase();
    }
    
    public double calcularArea(Triangulo t){
        return (t.getLadoA()*t.getLadoB())*t.getLadoC();
    }
    
    public double calcularArea(Circulo c){
        return c.getRaio()*3.14;
    }
    
    public double calcularPerimetro(Quadrado q){
        return q.getBase()+q.getAltura();
    }
    
    public double calcularPerimetro(Triangulo t){
        return t.getLadoA()+t.getLadoB()+t.getLadoC();
    }
    
    public double calcularPerimetro(Circulo c){
        return 2*3.14*c.getRaio();
    }
}
