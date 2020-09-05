package model;

public class Aluguel implements Comparable<Aluguel> {
    private Fita fita;
    private int diasAlugada;
    
    public Aluguel(Fita fita, int diasAlugada) {
        this.fita = fita;
        this.diasAlugada = diasAlugada;
    }
    
    public Fita getFita() {
        return fita;    
    }
    
    public int getDiasAlugada() {
        return diasAlugada;    
    }
    public double calcularValor() {    	
    	return fita.getValor(diasAlugada);
    }

    @Override
    public int compareTo(Aluguel o) {
        return this.getDiasAlugada() - o.getDiasAlugada();
    }
    public String toString(){
        return String.valueOf(this.calcularValor());
    }
}
