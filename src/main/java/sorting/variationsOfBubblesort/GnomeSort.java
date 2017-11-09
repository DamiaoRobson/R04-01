package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = leftIndex + 1;
			
			if (pivot != leftIndex && array[pivot - 1].compareTo(array[pivot]) > 0)
				Util.swap(array, pivot - 1, pivot);

			while (pivot < rightIndex) {
				if (array[pivot].compareTo(array[pivot + 1]) > 0) {
					Util.swap(array, pivot, pivot + 1);
					if (pivot != leftIndex)
						pivot--;
				} else
					pivot++;
			}
		}
	}
}
