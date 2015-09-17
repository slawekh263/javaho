package hackerrank.sample;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class SampleTest2 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> diffs = new HashMap<Integer, Integer>();
		
		final int MIN = (int) -10e6 - 1;
		final int MAX = (int) 10e6 + 1;
		int i;
		int diff;
		int diffsNo;
		int tmp;
		int standardDiff = MIN;
		int nonStandardDiff = MIN;
		int standardDiffCntr = 0;
		int nonStandardDiffCntr = 0;
		int standardCandidate = (int) -10e6-1;
		int nonStandardCandidate = (int) -10e6-1;
		int tmpCandidate;
		int currentDiff;
		int minDiff;
		int stdDiff = 0;
		int cntr;
		
		Integer missing = null;
		
		int[] numbers = new int[n];
		
		if(n<3 || n>2500) {
			return;
		}

		for (i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
			if(numbers[i] < MIN || numbers[i] > MAX) {
				return;
			}
		}

		diffs = getDiffs(numbers);
		
		Set<Integer> keys = diffs.keySet();
		Iterator<Integer> it = keys.iterator();

		while(it.hasNext()) {
			currentDiff = it.next();
			cntr = diffs.get(currentDiff);
			if(cntr == 1) {
				nonStandardDiff = currentDiff;
			} else if(cntr > 1) {
				stdDiff = currentDiff;
			}
		}
		// System.out.println("non standard diff: " + nonStandardDiff + ", standard: " + stdDiff);
		
		for(i = 0; i < n - 1; i++) {
			if(numbers[i + 1] - numbers[i] == nonStandardDiff) {
				missing = numbers[i] + stdDiff;
				// System.out.println("Missing candidate: " + missing);
				break;
			}
		}
		
		// validate
		if(missing != null) {
			int [] arr = new int[numbers.length+1];
			for(i=0; i<numbers.length; i++) {
				arr[i] = numbers[i];
			}
			arr[numbers.length] = missing;
			Arrays.sort(arr);
			
			diffs = getDiffs(arr);
			diffsNo = diffs.keySet().size();
					
			if(diffsNo == 1) {
				System.out.println(missing);
			}
		}
		
	}
    
    	static Map<Integer, Integer> getDiffs(int[] array) {
		int i;
		int diff;
		Map<Integer, Integer> diffs = new HashMap<Integer, Integer>();
		if (array != null) {

			for (i = 0; i < array.length - 1; i++) {
				diff = array[i + 1] - array[i];
				if (diffs.get(diff) == null) {
					diffs.put(diff, 1);
				} else {
					diffs.put(diff, diffs.get(diff) + 1);
				}
			}
		}
		return diffs;
	}
}