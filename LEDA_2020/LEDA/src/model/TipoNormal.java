package model;

public class TipoNormal implements TipoFilme {
	private static final double TAXA_ACRESCIMO_NORMAL = 1.5;
	private static final int DIAS_TOLERANCIA = 2;
	private static final double VALOR_FITA_NORMAL = 2.0;

	public double getValor(int diasAlugada) {
		double valorAluguel = VALOR_FITA_NORMAL;
        if (diasAlugada > 2) {
        	valorAluguel += (diasAlugada - DIAS_TOLERANCIA) * TAXA_ACRESCIMO_NORMAL;
        }
        return valorAluguel;
	}
	public double getValor(){
		return VALOR_FITA_NORMAL;
	}
}
