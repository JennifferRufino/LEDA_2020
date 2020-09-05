package model;

import java.util.*;

public class Cliente implements Comparable<Cliente> {
	private int pontosDeAlugadorFrequente = 0;
	private double dividaTotal = 0.0;
	private String nome;
	private Aluguel alugueis[];
	private int posicaoAtual = 0;

	public Cliente(String nome) {
		this.nome = nome;
		alugueis = new Aluguel[10];
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		if(this.posicaoAtual >= this.alugueis.length) {
			cresceArray();
		}
		this.alugueis[this.posicaoAtual++] = aluguel;
	}

	public void cresceArray() {
		Aluguel[] novoArray = new Aluguel[this.alugueis.length*2];
		for(int i = 0; i < posicaoAtual; i++) {
			novoArray[i] = this.alugueis[i];
		}
		this.alugueis = novoArray;
	}

	public int getPontosDeAlugadorFrequente() {
		return pontosDeAlugadorFrequente;
	}
	public void setPontosDeAlugadorFrequente(int pontos) {
		pontosDeAlugadorFrequente = pontos;
	}

	public double extrato() {
		double valorCorrente = 0.0;
		for(int i = 0; i < posicaoAtual; i++) {

			System.out.println(alugueis[i].calcularValor());
			valorCorrente += alugueis[i].calcularValor();
			pontosDeAlugadorFrequente += calcularPontosAlugadorFrequente(alugueis[i]);
		}

		return valorCorrente;
	}
	
	public String mostraExtrato() {
	    	
	    	final String fimDeLinha = System.getProperty("line.separator");
	        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;	        
	    	
	    	for(int i = 0; i < alugueis.length; i++) {
	    		if(alugueis[i] == null) {
	    			break;
				}
	    		resultado += "\t" + alugueis[i].getFita().getTitulo() + "\t" + alugueis[i].calcularValor() + fimDeLinha;
	    	}

	    	resultado += "Valor total a pagar: " + extrato() + fimDeLinha;
	        resultado += this.nome + " " + "tem" + " " + getPontosDeAlugadorFrequente() + " pontos de alugador frequente";
	        
	        return resultado;    	
	    }
		

	private int calcularPontosAlugadorFrequente(Aluguel aluguel) {
		int pontos = 1;
		if (aluguel.getFita().getTipo() instanceof TipoLancamento && aluguel.getDiasAlugada() > 1) {
			pontos += 1;
		}
		return pontos;
	}

	public Aluguel[] ordenarAluguelPorValor () {
		int ordena = 1;
		int i;
		alugueis = Arrays.copyOf(alugueis, posicaoAtual);
		while (ordena < this.posicaoAtual) {
			Aluguel aluguel = alugueis[ordena];
			if (alugueis[ordena] == null) {
				break;
			}
			for (i = ordena; i > 0; i--) {
				if (aluguel.calcularValor() < alugueis[i - 1].calcularValor()) {
					alugueis[i] = alugueis[i - 1];
				} else {
					break;
				}
			}
			alugueis[i] = aluguel;
			ordena++;
		}
		return alugueis;
	}

	public int posicaoAtual() {
		return this.posicaoAtual;
	}

	public Aluguel[] ordenarAlugueisSelectionSortPorValor() {
		int i;
		int max;
		int tam = posicaoAtual();
		alugueis = Arrays.copyOf(alugueis,posicaoAtual());
		while (tam > 0) {
			max = 0;
			for (i = 1; i < posicaoAtual(); i++) {
				if (alugueis[max].calcularValor() < alugueis[i].calcularValor()) max = i;
			}
			swap(alugueis, max, posicaoAtual() -1);
			tam--;
		}
		return alugueis;
	}


	private void swap (Aluguel[] alugueis, int max, int tam) {
		Aluguel smallestNumber = alugueis[max];
		alugueis[max] =  alugueis[tam];
		alugueis[tam] = smallestNumber;
	}


	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareToIgnoreCase(o.getNome());
	}

	public String toString(){
		return this.nome;
	}


	public Aluguel getAluguel(int j) {
		return alugueis[j];
	}


}