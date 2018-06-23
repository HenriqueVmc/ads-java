package model;

public enum ModoDeJogo {
    MAQUINA(1), HUMANO(2);
    
    private final int modo;
    
    ModoDeJogo(int modo){
        this.modo = modo;
    }
    
    public int getModoDeJogo(){
        return this.modo;
    }
}