package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
    public static void main(String args[] ) throws Exception {
        
        int [] aArr;
        int [][]subsets;
        int i, j;
        int aLen;
        boolean noDividerSubsetFound;
        
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(i=0; i<tests; i++) {
        	// read input data
            aLen = sc.nextInt();
            aArr = new int[aLen];
            // System.out.println("aLen: " + aLen);
            for(j=0; j<aLen; j++) {
            	aArr[j] = sc.nextInt();
            	// System.out.println("ai: " + aArr[j]);
            }
            // create subsets
            subsets = getSubsets(aArr);
            
            // divider
            noDividerSubsetFound = false;
            for(j=0; j<subsets.length; j++) {
            	if(hasNoDivider(subsets[j])) {
            		noDividerSubsetFound = true;
            		break;
            	}
            }
            if(noDividerSubsetFound) {
            	System.out.println(noDividerSubsetFound ? "YES" : "NO");
            }
            
        }
    }
    
    public static int[][] getSubsets(int [] array) {
    	ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
    	Set<Integer> s = new HashSet<Integer>();
    	
    	// get all subsets
    	
    	return null;
    }
    
    public static boolean hasNoDivider(int [] set) {
    	int i, j;
    	Arrays.sort(set);
    	int x = set[set.length-1];
    	if(x > 1) {
    		for(i=2; i<=x; i++) {
    			for(j=0; j<set.length; j++) {
    				if(set[j] % i != 0) {
    					// at least one element divides
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
}
