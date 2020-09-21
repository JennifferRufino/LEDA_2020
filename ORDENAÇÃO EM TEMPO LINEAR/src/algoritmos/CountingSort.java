package algoritmos;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 */
public class CountingSort extends AbstractSorting<Integer>{
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
