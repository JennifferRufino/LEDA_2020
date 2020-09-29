package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.TipoLancamento;
import model.TipoNormal;
import model.Fita;
import model.TipoInfantil;

class AluguelTest {
	static Fita lancamento;
	static Fita Normal;
	static Fita Infantil;
	@BeforeAll
	public static void construirInstancias() {
		lancamento = new Fita("Lancamento", new TipoLancamento());
		Normal = new Fita("Normal", new TipoNormal());
		Infantil = new Fita("Infantil", new TipoInfantil());
	}
	private static final int UM_DIA_ALUGADO = 1;
	private static final int DOIS_DIAS_ALUGADA = 2;
	private static final int QUATRO_DIAS_ALUGADA = 4;
	private static final int CINCO_DIAS_ALUGADA = 5;

	@Test
	void testAluguelLancamento() {
		//TODO: criar e configurar um aluguel com filme fo tipo lançamento
		assertEquals(lancamento.getValor(DOIS_DIAS_ALUGADA), 6); 
		assertEquals(lancamento.getValor(UM_DIA_ALUGADO), 3);
	}
	
	@Test
	void testAluguelNormal() {
		//TODO: criar e configurar um aluguel com filme fo tipo normal
		assertEquals(Normal.getValor(CINCO_DIAS_ALUGADA), 6.5); 
	}
	
	@Test
	void testAluguelInfantil() {
		//TODO: criar e configurar um aluguel com filme fo tipo infantil
		assertEquals(Infantil.getValor(DOIS_DIAS_ALUGADA), 1.5);
		assertEquals(Infantil.getValor(QUATRO_DIAS_ALUGADA), 3);
	}
 
}
 