package test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Aluguel;
import model.Cliente;
import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;



class ClienteTest {
	Fita teletanbs;
	Fita baby;
    Fita coringa;
    Fita woman;
    Fita loboW;
	
    //@Before
	void criarFitasTeste() {
		baby = new Fita("Baby Shark", new TipoInfantil());
        teletanbs = new Fita("Teletubs", new TipoInfantil());
        coringa = new Fita("Coringa",new TipoLancamento());
        woman = new Fita("Mulher Maravilha", new TipoLancamento());
        loboW = new Fita("Lobo de Wall Street",new TipoNormal());
	}

	@Test
	void testExtrato() {
		
		Cliente cliente2 = new Cliente("Maria");
        
        Aluguel alugado3 = new Aluguel(coringa, 1);
        Aluguel alugado4 = new Aluguel(woman, 2);
        
        cliente2.adicionaAluguel(alugado3);
        cliente2.adicionaAluguel(alugado4);
		
		assertEquals(cliente2.getNome(),"Maria");
//		assertEquals(cliente2.getAlugueis(), 2);
//		assertEquals(cliente2.getPontosAlugadorFreq(), 3);
	}

}
 