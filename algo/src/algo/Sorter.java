package algo;

import java.util.Arrays;

public class Sorter {
	
	public static int [] bubblesort(int [] array) {
		int holder;
		for(int i = array.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(array[j] > array[j+1]) {
					holder = array[j];
					array[j] = array[j+1];
					array[j+1] = holder;
				}
			}
		}
		return array;
	}
	
	public static int [] selectionsort(int [] array) {
		int min, minIdx, i, j;
		for(i=0; i<array.length-1; i++) {
			min = array[i];
			minIdx = -1;
			for(j=i; j<array.length; j++) {
				if(array[j] < min) {
					min = array[j];
					minIdx = j;
				}
			}
			if(minIdx >= i) {
				array[minIdx] = array[i];
				array[i] = min;
			}
		}
		return array;
	}
	
	public static int [] insertionsort(int [] array) {
	
		return array;
	}
	
	public static void main(String [] args) {
		int [] input = { 5, 2, 4, 2, 2, 1, 4, 6, 7, 4 };
		System.out.println("Input: " + Arrays.toString(input));
		int [] sorted = Sorter.bubblesort(input);
		System.out.println("Sorted by bubble: " + Arrays.toString(sorted));
		
		int [] selInput = { 1000, 0, 5, -2, 4, 2, 2, 1, 4, 6, 7, 1000 };
		System.out.println("Sel input: " + Arrays.toString(selInput));
		int [] selSorted = Sorter.selectionsort(selInput);
		System.out.println("Sorted by selection: " + Arrays.toString(selSorted));
	}

}
