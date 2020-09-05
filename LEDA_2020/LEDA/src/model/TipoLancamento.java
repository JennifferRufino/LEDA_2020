package model;

public class TipoLancamento implements TipoFilme {
	
	private static final double VALOR_FITA_LANCAMENTO = 3.0;

	public double getValor(int diasAlugada) {
		return VALOR_FITA_LANCAMENTO * diasAlugada;
	}

	public double getValor() {
		return VALOR_FITA_LANCAMENTO;
	}

}
