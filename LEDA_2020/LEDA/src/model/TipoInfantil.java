package model;

public class TipoInfantil implements TipoFilme {
	private static final int DIAS_TOLERANCIA = 3;
	private static final double VALOR_FITA_INFANTIL = 1.5;

	public double getValor(int diasAlugada) {
		double valorCorrente = VALOR_FITA_INFANTIL;
        if (diasAlugada > DIAS_TOLERANCIA) {
            valorCorrente += (diasAlugada - 3) * VALOR_FITA_INFANTIL;
        }
        return valorCorrente;
	}
	public double getValor() {
		return VALOR_FITA_INFANTIL;
	}
}
