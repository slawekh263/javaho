package algo;

import java.util.Arrays;

public class Lumbermill {
	
	public static int maxProfit(int cutCost, int unitPrice, int [] lengths) {
		Arrays.sort(lengths);
		
		int logLen, log;
		int pieces = 0, piecesInLen;
		int cuts = 0, cutsInLen;
		int maxVal = 0, val;
		int optimalLogLen = 0;
		
		for(logLen = 1; logLen <= lengths[lengths.length-1]; logLen++) {
			pieces = 0;
			cuts = 0;
			for(log=0; log<lengths.length; log++) {
				piecesInLen = lengths[log] / logLen;
				pieces += piecesInLen;
				cutsInLen = (lengths[log] % logLen == 0 ? piecesInLen-1 : piecesInLen);
				cuts += cutsInLen;
				// System.out.println("log: " + lengths[log] + " log len: " + logLen + " pieces in len: " + piecesInLen + " cuts: " + cutsInLen);
			}
			val = pieces * logLen * unitPrice - cuts*cutCost;
			System.out.println("Revenue: " + val);
			if(val > maxVal) {
				maxVal = val;
				optimalLogLen = logLen;
			}
		}
		System.out.println("Max value: " + maxVal + " at log length: " + optimalLogLen);
		
		return maxVal;
	}

	public static void main(String[] args) {
		int cutCost = 1;
		int unitPrice = 10;
		int [] lengths = new int[] { 26, 103, 59 };
		System.out.println("Max: " + maxProfit(cutCost, unitPrice, lengths));
	}

}
