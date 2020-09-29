package algoritmos;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public T[] ordena(T[] array, int inicio, int fim) {
		if (fim - inicio < 1) return array;
		int meio = (inicio + fim) / 2;
		ordena(array, inicio, meio);
		ordena(array, meio + 1, fim);

		merge(array, inicio, meio,fim);

		return array;

	}
	private static <T extends Comparable<T>> void merge(T[] array, int inicio, int meio, int fim) {
		Object[] auxiliar = new Object[fim - inicio + 1];
		int i = inicio;
		int j = meio + 1;
		int k = 0;
		while (i <= meio && j <= fim) {
			if (array[i].compareTo(array[j]) < 0) {
				auxiliar[k] = array[i++];
			} else {
				auxiliar[k] = array[j++];
			}
			k++;
		}
		if (i <= meio && j > fim) {
			while (i <= meio) {
				auxiliar[k++] = array[i++];
			}
		} else {
			while (j <= fim) {
				auxiliar[k++] = array[j++];
			}
		}
		for (k = 0; k < auxiliar.length; k++) {
			array[k+inicio] = (T)(auxiliar[k]);
		}
	}
}
