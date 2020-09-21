package algoritmos;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort. Desta vez este
 * algoritmo deve satisfazer os seguintes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos.
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

    @Override
    public Integer[] ordena(Integer[] array, int leftIndex, int rightIndex) {
        int range = rightIndex - leftIndex + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - leftIndex]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - leftIndex] - 1] = array[i];
            count[array[i] - leftIndex]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
        return array;
    }

}