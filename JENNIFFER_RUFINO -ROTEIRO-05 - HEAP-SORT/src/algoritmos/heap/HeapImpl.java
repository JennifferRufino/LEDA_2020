package algoritmos.heap;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;


	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é mudar
	 * apenas o comparator e mandar reordenar a heap usando esse comparator. Assim
	 * os metodos da heap não precisam saber se vai funcionar como max-heap ou
	 * min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private static final int ZERO = 0;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma min-heap.
	 */


	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento indexado
	 * pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento indexado
	 * pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		T[] ret = (T[])new Comparable[index+1];
		for (int i = 0; i <= index; i++) {
			ret[i] = this.heap[i];
		}
		return ret;
	}

	// ///////////// METODOS A IMPLEMENTAR

	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode ser
	 * a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		int left = left(position);
		int right = right(position);
		int max = position;

		if (left <= index && heap[left] != null &&
				comparator.compare(heap[left], heap[position]) > 0) {
			max = left;
		}

		if (right <= index && heap[right] != null &&
				comparator.compare(heap[right], heap[max]) > 0) {
			max = right;
		}

		if (max != position) {
			Util.swap(heap, max, position);
			heapify(max);
		}
	}

	@Override
	public void insert(T element) {
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		if (element == null) return;

		heap[++index] = element;
		int i = index;

		while (i != 0) {
			i = parent(i);
			heapify(i);

		}
	}

	@Override
	public void buildHeap(T[] array) {
		if (array == null || array.length <= 0) {
			return;
		}

		heap = Arrays.copyOf(array, array.length);
		index = array.length - 1;

		for (int i = parent(index); i >= 0; i--) {
			heapify(i);
		}
	}

	@Override
	public T extractRootElement() {
		if (isEmpty()) {
			return null;
		}

		T remover = rootElement();
		Util.swap(heap, ZERO, index--);
		heapify(ZERO);

		return remover;
	}

	@Override
	public T rootElement() {
		if (isEmpty()) {
			return null;
		}

		return heap[ZERO];
	}

	@Override
	public T[] heapsort(T[] array) {
		if (array == null || array.length <= 0) return array;

		int indexAux = index;
		T[] heapAux = getHeap();
		Comparator<T> comparatorAux = getComparator();

		comparator = new Comparator<T>() {
			@Override
			public int compare(T a, T b) {
				return a.compareTo(b);
			}

		};

		buildHeap(array);
		T[] resultado = (T[])new Comparable[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			resultado[i] = extractRootElement();
		}

		heap = heapAux;
		index = indexAux;
		comparator = comparatorAux;

		return resultado;
	}

	@Override
	public int size() {
		//TODO
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
