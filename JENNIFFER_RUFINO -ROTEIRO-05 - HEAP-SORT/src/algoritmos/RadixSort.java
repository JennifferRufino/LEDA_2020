package algoritmos;
import sorting.AbstractSorting;

public class RadixSort extends AbstractSorting<Integer> {
    @Override
    public Integer[] ordena(Integer[] array, int inicio, int fim) {
        int size= array.length;
        int max = maxValue(array, size);

        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
        return array;
    }
    private void countingSort(Integer array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    private Integer maxValue(Integer array[], int tam) {
        int max = array[0];
        for (int i = 1; i < tam; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
}