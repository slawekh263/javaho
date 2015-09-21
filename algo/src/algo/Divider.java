package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Divider {
    
	/**
	 * Gets a list of all non-empty subsets of array values
	 * Elements within sets are unique
	 * @param array
	 * @return
	 */
    public static List<List<Integer>> getSubsets(Integer [] array) {
    	
    	int i;
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
    	    	
    	for(i=0; i<uniqueArray.length; i++) {
    		currentLists = concatLists(outputLists, null); // == clone
    		singleValLists = getValueLists(currentLists, uniqueArray[i]);
    		concatLists(singleValLists, outputLists);
    		// printLists(outputLists);
    	}

    	return outputLists;
    }
    
    public static List<List<Integer>> getValueLists(List<List<Integer>> lists, Integer value) {

    	// System.out.println("-- Adding to list: " + value);
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
    /**
     * Appends element from 1st list to 2nd; If the last one is empty, new cloned list is created
     * @param inputLists
     * @param targetLists
     * @return
     */
    public static List<List<Integer>> concatLists(List<List<Integer>> inputLists, List<List<Integer>> targetLists) {
    	if(targetLists == null) {
    		targetLists = new ArrayList<List<Integer>>();
    	}
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
    	
    	return targetLists;
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
    
    public static Integer getDivider(List<Integer> set) {
    	int i, j;
    	boolean allDivide;
    	Integer divider = null;
    	Integer [] setEls = new Integer[set.size()];
    	setEls = set.toArray(setEls);
    	
    	Arrays.sort(setEls);
    	int x = setEls[setEls.length-1];
    	if(x > 1) {
    		for(i=2; i<=x; i++) {
    			allDivide = true;
    			for(j=0; j<setEls.length; j++) {
    				// System.out.println("el: " + setEls[j] + ", i: " + i);
    				if(setEls[j] % i != 0) {
    					allDivide = false;
    					break;
    				}
    			}
    			if(allDivide) {
    				divider = x; 
    			}
    		}
    	}
    	// System.out.println("Divider for " + Arrays.toString(setEls) + " is " + (divider != null ? divider : "not found"));
    	return divider;
    }
    
    public static void executeTest(Integer [] inputArray) {
    	
        List<List<Integer>> subsetsList = getSubsets(inputArray);
        printLists(subsetsList);
        // System.out.println("---------");

        // divider            
        Iterator<List<Integer>> sit = subsetsList.iterator();
        List<List<Integer>> nonDivSubsets = new ArrayList<List<Integer>>();
        List<Integer> subset = null;
        Integer allDivider;
        
        while(sit.hasNext()) {
        	subset = sit.next();
        	allDivider = getDivider(subset);
        	if(allDivider == null) {
        		// subset with no divider exist (can return here)
        		nonDivSubsets.add(subset);
        		printList(subset);
        	}
        }
        System.out.println(nonDivSubsets.isEmpty() ? "NO" : "YES");        
    	
    }
    
    // ===================================
    
    public static void main(String args[] ) throws Exception {
        
        Integer [] testInputArray;
        int testInputArrayLen;
        int i, j;
        int testCount;

        Scanner sc = new Scanner(System.in);
        testCount = sc.nextInt();
        
        for(i=0; i<testCount; i++) {
        	testInputArrayLen = sc.nextInt();
        	testInputArray = new Integer[testInputArrayLen];
            for(j=0; j<testInputArrayLen; j++) {
            	testInputArray[j] = sc.nextInt();
            }

            executeTest(testInputArray);
        }
        sc.close();
    }
    
}
