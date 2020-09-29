package algoritmos;

import sorting.AbstractSorting;

/**
 * QuickSort de pivô extra foca na implementação de um método de pivoteamento
 * O(n) para escolher um pivo com base nos valores do array. Este método deve
 * analisar os elementos do array e obter uma média dos valores para que seja 
 * usado como o pivô.
 * Lembre de identificar pivô que de fato existam no array, ou seja, você precisa
 * fazer uma busca no próprio array.
 * @author fabioleite
 *
 * @param <T>
 */
public class QuickSortExtraPivo<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		if(array == null || array.length == 0) {
			return array;
		}
		if(inicio > fim) {
			int pIndex = quicksort(array, inicio, fim);
			quicksort(array, inicio, pIndex - 1 );
			quicksort(array, pIndex + 1, fim);
		}

		return array;
	}
	private Integer quicksort(T[] array, int inicio, int fim) {
		int i = inicio, j = fim;

		Double pivo =  media(array, i, fim) ;

		while(i < j) {
			while(((Double) array[i]).compareTo(pivo) < 0) {
				i++;
			}
			while(((Double)array[j]).compareTo(pivo) > 0){
				j--;
			}
			if(i >= j) {
				T aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				i++;
				j--;
			}
		}
		if(inicio < j ){
			quicksort(array, inicio, j);
		}
		if(i < fim) {
			quicksort(array, i, fim);
		}

		return i + 1;
	}

	private Double media(T[] array, int inicio, int fim) {
		T maior = array[inicio];
		T menor = array[fim];

		for(int i  = 0; i < array.length; i++){
			if(array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
		}

		Double media = ((Double)maior + (Double)menor) / 2;

		return media;
	}
	

}
