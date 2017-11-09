package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && 
			leftIndex >= 0 && rightIndex < array.length) {

			int gap = leftIndex + rightIndex;
			boolean guard = true;

			while (gap > 1 || guard) {
				if (gap > 1)
					gap = (int) (gap / 1.25);

				guard = false;
				int i = leftIndex;

				while ((i + gap) <= rightIndex) {
					if (array[i].compareTo(array[gap + i]) > 0) {
						T aux = array[i];
						array[i] = array[gap + i];
						array[gap + i] = aux;
						guard = true;
					}
					i++;
				}
			}
		}
	}
}
