package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;

class FitaTest {
	
	
	Fita baby;
	Fita teletanbs;
	Fita coringa;
	Fita woman;
	Fita loboW;
    
	private static final int UM_DIA_ALUGADO = 1;
	private static final int DOIS_DIAS_ALUGADA = 2;
	private static final int QUATRO_DIAS_ALUGADA = 4;
	private static final int CINCO_DIAS_ALUGADA = 5;
	
	

	@Test
	void testeValor2Days() {
		baby = new Fita("Baby Shark", new TipoInfantil());
		assertEquals(1.5, baby.getValor(DOIS_DIAS_ALUGADA));
		
		//----------------------------- Teste Dois dias para Lançamento  -----------------------------
		woman = new Fita("Mulher Maravilha", new TipoLancamento());
		assertEquals(6 , woman.getValor(DOIS_DIAS_ALUGADA));
	}
	@Test
	void testeValor4Days() {
		teletanbs = new Fita("Teletubs", new TipoInfantil());
		assertEquals(3.0, teletanbs.getValor(QUATRO_DIAS_ALUGADA));
	}
	@Test
	void testeValor1Day() {
		coringa = new Fita("Coringa", new TipoLancamento());
		assertEquals(3, coringa.getValor(UM_DIA_ALUGADO));
	}
	@Test
	void testeValor5Days() {
		loboW = new Fita("Lobo de Wall Street", new TipoNormal());
		assertEquals(6.5, loboW.getValor(CINCO_DIAS_ALUGADA));
	}

}