package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Solution {
    public static void main(String args[] ) throws Exception {
        
        int [] aArr;
        int [][]subsets;
        int i, j;
        int aLen;
        boolean noDividerSubsetFound;
        
        Integer [] testArray = { 4, 2, 1, 7, 3, 4, 2 };
        Integer [] smallTestArray = { 2, 1, 4, 2, 5, 1000, 7 };
        /*
         * 4, 4 2, 4, 1 
         */
        
        List<List<Integer>> tubsets = getSubsets(smallTestArray);
        List<Integer> ar;
        Iterator<List<Integer>> it = tubsets.iterator();
        while(it.hasNext()) {
        	ar = it.next();
        	System.out.println("Subset: " + Arrays.toString(ar.toArray()));
        }
        
        if(true) {
        	return;
        }
        
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
            // subsets = getSubsets(aArr);
            
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
    
    public static List<List<Integer>> getSubsets(Integer [] array) {
    	
    	int i;
    	List<List<Integer>> lists = new LinkedList<List<Integer>>();
    	List<List<Integer>> singleValLists = new LinkedList<List<Integer>>();
    	List<List<Integer>> currentLists = new LinkedList<List<Integer>>();
    	List<List<Integer>> outputLists = new LinkedList<List<Integer>>();
    	Integer [] uniqueArray;

    	// creating set to remove duplicates (not significant when finding dividers)
    	Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));
    	List<Integer> uniqueList = new ArrayList<Integer>();
    	Iterator<Integer> it =  set.iterator();
    	while(it.hasNext()) {
    		uniqueList.add(it.next());
    	}
    	uniqueArray = new Integer[uniqueList.size()];
    	uniqueArray = uniqueList.toArray(uniqueArray);
    	
    	System.out.println("Unique array: " + Arrays.toString(uniqueArray));
    	
    	// list.add(new Integer[] { 2, 3 });
    	// list.add(new Integer[] { 4, 6 });
    	
    	for(i=0; i<uniqueArray.length; i++) {
    		currentLists = cloneLists(outputLists);
    		singleValLists = getValueLists(currentLists, uniqueArray[i]);
    		System.out.println("List size after add: " + lists.size());
    		concatLists(singleValLists, outputLists);
    		printLists(outputLists);
    	}

    	return outputLists;
    }
    
    public static List<List<Integer>> getValueLists(List<List<Integer>> lists, Integer value) {

    	System.out.println("-- Adding to list: " + value);
    	Iterator<List<Integer>> it = lists.iterator();
    	List<Integer> list = null;
    	// add to existing lists
    	while(it.hasNext()) {
    		list = it.next();
    		list.add(value);
    	}
    	// create single-element list
    	List<Integer> singleList = new ArrayList<Integer>();
    	singleList.add(value);
    	lists.add(singleList);
    	    	
    	return lists;
    }
    
    public static List<List<Integer>> cloneLists(List<List<Integer>> source) {
    	List<List<Integer>> target = new ArrayList<List<Integer>>();
    	Iterator<Integer> existingList = null;
    	List<Integer> cloneList = null;
    	Iterator<List<Integer>> it = source.iterator();
    	while(it.hasNext()) {
    		existingList = it.next().iterator();
    		cloneList = new ArrayList<Integer>();
    		while(existingList.hasNext()) {
    			cloneList.add((int) existingList.next());
    		}
    		if(!cloneList.isEmpty()) {
    			target.add(cloneList);
    		}    		
    	}
    	return target;
    }
    
    public static void concatLists(List<List<Integer>> inputLists, List<List<Integer>> targetLists) {
    	Iterator<List<Integer>> it = inputLists.iterator();
    	Iterator<Integer> existingList = null;
    	List<Integer> cloneList = null;
    	while(it.hasNext()) {
    		existingList = it.next().iterator();
    		cloneList = new ArrayList<Integer>();
    		while(existingList.hasNext()) {
    			cloneList.add((int) existingList.next());
    		}
    		if(!cloneList.isEmpty()) {
    			targetLists.add(cloneList);
    		}    		
    	}
    }
    
    public static void printList(List<Integer> list) {
    	System.out.println("List: " + Arrays.toString(list.toArray()));
    }
    
    public static void printLists(List<List<Integer>> lists) {
    	System.out.println("Printing lists");
    	if(lists != null) {
    		Iterator<List<Integer>> it = lists.iterator();
    		while(it.hasNext()) {
    			printList(it.next());
    		}    		
    	}
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
