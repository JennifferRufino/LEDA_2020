package algoritmos;

import sorting.AbstractSorting;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		if (inicio < fim) {
			int pIndex = particao(array, inicio, fim);

			ordena(array, inicio, pIndex - 1);
			ordena(array, pIndex + 1, fim);
		}
		return array;
	}
	private Integer particao(T[] array, int inicio, int fim) {
		T pivo = array[fim];
		int i = (inicio - 1);

		for (int j = inicio; j < fim; j++) {
			if (array[j].compareTo(pivo) <= 0) {
				i++;

				T swapAux = array[i];
				array[i] = array[j];
				array[j] = swapAux;
			}
		}

		T swapAux = array[i + 1];
		array[i + 1] = array[fim];
		array[fim] = swapAux;

		return i + 1;
	}
}