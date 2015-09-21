package codility.l3slicearr;

//  correctness: 100%, performance: 20%
public class SliceArray {
	public int solution(int[] A) {
		int n = A.length;
		int cntr;
		float sliceAvg;
		int slice, sliceIdx;
		float minSlice = 300001.0f;
		sliceIdx = -1;
		for (int p = 0; p < n - 1; p++) {
			for (int q = p + 1; q < n; q++) {
				slice = 0;
				cntr = 0;
				for (int idx = p; idx <= q; idx++) {
					slice += A[idx];
					cntr++;
				}
				sliceAvg = (float) slice / cntr;
				if (sliceAvg < minSlice) {
					minSlice = sliceAvg;
					sliceIdx = p;
				}
			}
		}
		return sliceIdx;
	}

}
