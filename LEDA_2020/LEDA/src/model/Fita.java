package model;

public class Fita implements Comparable<Fita> {


    private String titulo;
    private TipoFilme tipo;
    
    
    public Fita(String titulo, TipoFilme tipo) {
    	this.titulo = titulo;
    	this.tipo = tipo;
    }


	public String getTitulo() {
		return titulo;
	}
	
	public double getValor(int diasAlugada) {
		return tipo.getValor(diasAlugada);
	}

	public double getValor() {
    	return tipo.getValor();
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoFilme getTipo() {
		return tipo;
	}

	@Override
	public int compareTo(Fita o) {
		return this.titulo.compareToIgnoreCase(o.getTitulo());
	}
	public String toString(){
    	return this.titulo;
	}
}
