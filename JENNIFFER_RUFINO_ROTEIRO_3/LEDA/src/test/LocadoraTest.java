package test;

import java.util.Arrays;
import model.Aluguel;
import model.Cliente;
import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;
import model.Locadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocadoraTest {

           Cliente cliente = new Cliente("Abel");
           Cliente cliente2 = new Cliente("Jeiza");
           Cliente cliente3 = new Cliente("Zeca");

           Fita baby = new Fita("Baby", new TipoInfantil());
           Fita avengers = new Fita("Avengers", new TipoLancamento());
           Fita LoboW = new Fita("Lobo de Wall Street",new TipoNormal());

           Aluguel alugado = new Aluguel(baby, 2);
           Aluguel alugado1 = new Aluguel(avengers, 2);
           Aluguel alugado2 = new Aluguel(LoboW, 5);

        @Test
        void inserirClienteOrdenado() {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente2);
            locadora.adicionaCliente(cliente);
            locadora.adicionaCliente(cliente3);

            System.out.println(Arrays.toString(locadora.ordenarClientesPeloNome()));

            Cliente cl1 = locadora.getCliente(0);
            Cliente cl2 = locadora.getCliente(1);
            Cliente cl3 = locadora.getCliente(2);

            //System.out.println(cl1.getNome());
            //System.out.println(cliente.getNome());

            assertEquals(cliente.getNome(), cl1.getNome());
            assertEquals(cliente2.getNome(), cl2.getNome());
            assertEquals(cliente3.getNome(), cl3.getNome());
        }

        @Test
        void ordenarClientePeloNome() {
            Locadora locadora = new Locadora();
            Cliente[] desordena = {cliente3, cliente, cliente2};
            Cliente[] expected = {cliente, cliente2, cliente3};

            //System.out.println(Arrays.toString(locadora.ordenarClientePeloNome(desordena)));
            assertArrayEquals(expected, locadora.ordenarClientePeloNome(desordena));
        }

        @Test
        void removeCliente() {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            locadora.adicionaCliente(cliente2);
            locadora.adicionaCliente(cliente3);
            Cliente c1 = locadora.removeCliente("Jeiza");

            assertEquals(cliente2.getNome(), c1.getNome());
        }

        @Test
        void buscaLinearClientes() {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            locadora.adicionaCliente(cliente2);
            locadora.adicionaCliente(cliente3);

            System.out.println(((locadora.buscaLinearCliente("Jeiza"))));
            System.out.println(((locadora.buscaLinearCliente("Bartolomeu"))));

        }

        @Test
        void buscaBinariaClientes() {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            locadora.adicionaCliente(cliente2);
            locadora.adicionaCliente(cliente3);

            System.out.println(((locadora.buscaBinariaClientes("Jeiza"))));
            System.out.println(((locadora.buscaBinariaClientes("Bartolomeu"))));

        }

        @Test
        void inserirFita() {
            Locadora locadora = new Locadora();
            locadora.adicionaFita(baby);
            locadora.adicionaFita(avengers);
            locadora.adicionaFita(LoboW);

           assertEquals(baby, locadora.getFita(0));
        }

        @Test
        void ordenarFitaPeloTitulo() {
            Locadora locadora = new Locadora();
            Fita[] desordena = {baby, LoboW, avengers};
            Fita[] expected = {avengers, baby, LoboW};

            System.out.println(Arrays.toString(locadora.ordenarFitasPeloTitulo(desordena)));
            assertArrayEquals(expected, locadora.ordenarFitasPeloTitulo(desordena));
        }

        @Test
        void ordenarFitaPeloValorMerge() {
            Locadora locadora = new Locadora();
            locadora.adicionaFita(LoboW);
            locadora.adicionaFita(baby);
            locadora.adicionaFita(avengers);

            Fita[] esperado = {baby, LoboW, avengers};
            Fita[] desordenado = {avengers, baby, LoboW};

            assertArrayEquals(esperado, locadora.ordenarFitasMergeSortPorValor(desordenado));
        }

        @Test
        void ordenarFitaPeloValorQuick() {
            Locadora locadora = new Locadora();
            locadora.adicionaFita(LoboW);
            locadora.adicionaFita(baby);
            locadora.adicionaFita(avengers);

            Fita[] esperado = {baby, LoboW, avengers};
            Fita[] desordenado = {avengers, baby, LoboW};

            assertArrayEquals(esperado, locadora.ordenarFitasPeloValorQuick(desordenado, 0, desordenado.length - 1));
        }

        @Test
        void removeFita() {
            Locadora locadora = new Locadora();
            locadora.adicionaFita(baby);
            locadora.adicionaFita(avengers);
            locadora.adicionaFita(LoboW);
            Fita b1 = locadora.removeFita("Baby");


            assertEquals(baby.getTitulo(), b1.getTitulo());
        }

        @Test
        void buscaLinearFita() {
            Locadora locadora = new Locadora();
            locadora.adicionaFita(baby);
            locadora.adicionaFita(avengers);
            locadora.adicionaFita(LoboW);

            assertEquals(baby, locadora.buscaLinearFita("Baby"));
        }

        @Test
        void buscaBinariaFita() {
                Locadora locadora = new Locadora();
                locadora.adicionaFita(avengers);
                locadora.adicionaFita(baby);
                locadora.adicionaFita(LoboW);

                assertEquals(avengers, locadora.buscaBinariaFita("Avengers"));
        }

        @Test
        void adicionaAluguel () {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            cliente.adicionaAluguel(alugado);
            cliente.adicionaAluguel(alugado1);
            cliente.adicionaAluguel(alugado2);
            assertEquals(alugado, locadora.getAluguel(0, 0));
            assertEquals(alugado1, locadora.getAluguel(0, 1));
            assertEquals(alugado2, locadora.getAluguel(0, 2));
        }

        @Test
        void ordenarAlugueisPorValor() {
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            cliente.adicionaAluguel(alugado1);
            cliente.adicionaAluguel(alugado2);
            cliente.adicionaAluguel(alugado);

            Aluguel[] alugueis = cliente.ordenarAluguelPorValor();

            assertEquals(1.5, Double.parseDouble(alugueis[0].toString()));
            assertEquals(6.0, Double.parseDouble(alugueis[1].toString()));
            assertEquals(6.5, Double.parseDouble(alugueis[2].toString()));

        }

    @Test
    void ordenarAlugueisSelectionSortPorValor(){
            Locadora locadora = new Locadora();
            locadora.adicionaCliente(cliente);
            cliente.adicionaAluguel(alugado);

            cliente.adicionaAluguel(alugado2);
            cliente.adicionaAluguel(alugado1);

            Aluguel[] esperado = {alugado,alugado1, alugado2};
            Aluguel[] alugueis = cliente.ordenarAlugueisSelectionSortPorValor();

            assertEquals(6.0, Double.parseDouble(alugueis[1].toString()));
            assertEquals(1.5, Double.parseDouble(alugueis[0].toString()));
            assertEquals(6.5, Double.parseDouble(alugueis[2].toString()));
            assertArrayEquals(esperado, cliente.ordenarAlugueisSelectionSortPorValor());
            assertEquals(3, cliente.posicaoAtual());
        }
}