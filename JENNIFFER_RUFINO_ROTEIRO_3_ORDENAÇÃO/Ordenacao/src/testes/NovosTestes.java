package testes;

import java.util.Arrays;

import algoritmos.QuickSort;
import algoritmos.QuickSortExtraPivo;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algoritmos.MergeSort;

class NovosTestes {
	
	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private MergeSort<Integer> Implementacao;
	private Integer[] vetorPiorCaso;
	private Integer[] vetorMelhorCaso;
	
	@BeforeEach
	public void setUp() {
		populaVetorValoresIguais(new Integer[] {3, 3, 3, 3, 3, 3, 3, 3,});
		populaVetorTamImpar(new Integer[] {3, 99, 48, 13, 47, 18, 1, 28, 59, 22, 67});
		populaVetorTamPar(new Integer[] {23, 10, 3, 69, 51, 99, 45, 32, 87, 88});
		populaVetorVazio(new Integer[] {});
		populaVetorRepetidos(new Integer[] {2, 6, 98, 54, 6, 78, 2, 34, 87, 78, 2, 1 });
		populaVetorMelhorCaso(new Integer[] {1, 5, 8, 12, 38, 40, 45, 67, 70, 78, 80, 98});
		populaVetorPiorCaso(new Integer[] {59, 43, 36, 20, 19, 17, 13, 10, 8, 5, 2, 1});
		getImplementacao();
	}
	
	private void getImplementacao() {
		//TODO: colocar a implementação do método a ser testada
		this.Implementacao = new MergeSort<Integer>();
//		Assert.fail("falhar quando não tiver implementação");
	}
	
	public void populaVetorRepetidos(Integer[] arrayArgumento) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorValoresIguais(Integer[] arrayArgumento) {
		this.vetorValoresIguais = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamImpar(Integer[] arrayArgumento) {
		this.vetorTamImpar = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorTamPar(Integer[] arrayArgumento) {
		this.vetorTamPar = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorVazio(Integer[] arrayArgumento) {
		this.vetorVazio = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorPiorCaso(Integer[] arrayArgumento) {
		this.vetorPiorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}
	
	public void populaVetorMelhorCaso(Integer[] arrayArgumento) {
		this.vetorMelhorCaso = Arrays.copyOf(arrayArgumento, arrayArgumento.length);
	}

	public void testeGenerico(Integer[] array) {
		Integer[] copia1 = {};
		if (array.length > 0) {
			copia1 = Arrays.copyOf(array, array.length);
		}
		Implementacao.sort(array);
		Arrays.sort(copia1);
		Assert.assertArrayEquals(copia1, array);
	}
	
	@Test
	public void testSortVetorPar() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorTamPar, 0, vetorTamPar.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorTamPar, 0, vetorTamPar.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorTamPar, 0, vetorTamPar.length - 1));
	}
	
	@Test
	public void testSortVetorImpar() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorTamImpar, vetorTamImpar.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorTamImpar, 0, vetorTamImpar.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorTamImpar, 0, vetorTamImpar.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorTamImpar, 0, vetorTamImpar.length - 1));
	}
	
	@Test
	public void testSortRepetidos() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1));
	}
	
	@Test
	public void testSortIguais() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorValoresIguais, vetorValoresIguais.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorValoresIguais, 0, vetorValoresIguais.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorValoresIguais, 0, vetorValoresIguais.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorValoresIguais, 0, vetorValoresIguais.length - 1));
	}
	
	@Test
	public void testSortVazio() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorVazio, vetorVazio.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorVazio, 0, vetorVazio.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorVazio, 0, vetorVazio.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorVazio, 0, vetorVazio.length - 1));
	}
	
	@Test
	public void testSortPiorCaso() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorPiorCaso, vetorPiorCaso.length);
		Arrays.sort(esperado);
		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorPiorCaso, 0, vetorPiorCaso.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorPiorCaso, 0, vetorPiorCaso.length - 1));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorPiorCaso, 0, vetorPiorCaso.length - 1));
	}
	
	@Test
	public void testSortMelhorCaso() {
		MergeSort<Integer> mergeSort = new MergeSort<>();
		QuickSort<Integer> quickSort = new QuickSort<>();
		QuickSortExtraPivo<Integer> quickSortExtraPivo = new QuickSortExtraPivo<>();
		Integer[] esperado;
		esperado = Arrays.copyOf(vetorMelhorCaso, vetorMelhorCaso.length);
		Arrays.sort(esperado);

		Assert.assertArrayEquals(esperado, mergeSort.ordena(vetorMelhorCaso, 0, vetorMelhorCaso.length - 1));
		Assert.assertArrayEquals(esperado, quickSort.ordena(vetorMelhorCaso, 0, vetorMelhorCaso.length - 1));
		System.out.println(Arrays.toString(quickSortExtraPivo.ordena(vetorMelhorCaso, 0, vetorMelhorCaso.length -1)));
		Assert.assertArrayEquals(esperado, quickSortExtraPivo.ordena(vetorMelhorCaso, 0, vetorMelhorCaso.length - 1));
	}

}
