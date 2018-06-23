package pctfigurasgeometricas;

public class Sistema {
    
    public static void main(String[] args) {
        
        Quadrado q = new Quadrado(2,6);
        System.out.println("\n---Quadrado---\nÁrea: "+q.calcularArea(q));
        System.out.println("Perímetro: "+q.calcularPerimetro(q));
        
        Circulo c = new Circulo(5);
        System.out.println("\n---Círculo---\nÁrea: "+c.calcularArea(c));
        System.out.println("Perímetro: "+c.calcularPerimetro(c));
        
        Triangulo tEq = new Equilatero(3,3,3);
        System.out.println("\n---Triângulo Equilátero---\nÁrea: "+tEq.calcularArea(tEq));
        System.out.println("Perímetro: "+tEq.calcularPerimetro(tEq));
        
        Triangulo tEs = new Escaleno(3,3,6);
        System.out.println("\n---Triângulo Escaleno---\nÁrea: "+tEs.calcularArea(tEs));
        System.out.println("Perímetro: "+tEs.calcularPerimetro(tEs));
        
        Triangulo tIs = new Isosceles(3,4,6);
        System.out.println("\n---Triângulo Isosceles---\nÁrea: "+tIs.calcularArea(tIs));
        System.out.println("Perímetro: "+c.calcularPerimetro(tIs));
    }
}
