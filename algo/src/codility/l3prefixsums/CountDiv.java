package codility.l3prefixsums;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CountDiv {
	
	// NOTE: this has 87% (failed at [101, 123456789, 10000])

	public int solution(int A, int B, int K) {
		int result = 0;
		int divA, divB;

		if (A == B) {
			result = (A % K == 0) ? 1 : 0;
		} else {
			if (K < A) {
				divA = A / K;
				divA *= K;
				if (divA < A) {
					divA += K;
				}

				divB = B / K;
				divB *= K;
				if (divA > divB) {
					divA -= K;
				}
				if (divB == divA) {
					result = 1;
				} else {
					result = (divB - divA) / K;
					if (A % K == 0 || B % K == 0) {
						result++;
					}
				}

			} else if (K >= A && K <= B) {
				result = (B - A) / K + 1;
			} // if K > B -> 0

		}
		return result;
	}

}