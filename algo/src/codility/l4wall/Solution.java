package codility.l4wall;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	
	// correctness: 100%, performance 44%
	
    public class Block {
        private int startIdxLeft;
        private int startBottom;
        private int endIdxLeft;
        private int endTop;
        
        public Block(int startIdxLeft, int startBottom, int endIdxLeft, int endTop) {
			super();
			this.startIdxLeft = startIdxLeft;
			this.startBottom = startBottom;
			this.endIdxLeft = endIdxLeft;
			this.endTop = endTop;
		}

		public int getEndIdxLeft() {
			return endIdxLeft;
		}

		public void setEndIdxLeft(int endIdxLeft) {
			this.endIdxLeft = endIdxLeft;
		}

		public int getEndTop() {
			return endTop;
		}

		public void setEndTop(int endTop) {
			this.endTop = endTop;
		}

		public boolean isComplete() {
        	return endIdxLeft != -1;
        }
        
		public int getStartIdxLeft() {
			return startIdxLeft;
		}
		public void setStartIdxLeft(int startIdxLeft) {
			this.startIdxLeft = startIdxLeft;
		}
		public int getStartBottom() {
			return startBottom;
		}
		public void setStartBottom(int startBottom) {
			this.startBottom = startBottom;
		}
		public int getWidth() {
			return endIdxLeft - startIdxLeft + 1;
		}

		public int getHeight() {
			return endTop - startBottom + 1;
		}

		
		public String toString() {
			StringBuffer sb = new StringBuffer("\nBlock:\n");
			sb.append("\nstart idx left: " + startIdxLeft);
			sb.append("\nstart idx bottom: " + startBottom);
			sb.append("\nend idx left " + endIdxLeft);
			sb.append("\nendTop: " + endTop);
			sb.append("\n-width: " + getWidth());
			sb.append("\n-height: " + getHeight());
			sb.append("\nCOMPLETE: " + isComplete());
			return sb.toString();
		}
		
    }

	public int solution(int[] H) {
        
        List<Block> blocks = new LinkedList<>();
        Block block = null;
        int blocksNo = 0;
        int n = H.length;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				block = new Block(0, 1, -1, H[i]); // TODO default params
				blocks.add(block);
				// System.out.println("i: " + i + ", " + Solution.blocksString(blocks));
			} else {
				// System.out.println("i: " + i);
				if (H[i] > H[i - 1]) {
					block = new Block(i, H[i - 1] + 1, -1, H[i]);
					blocks.add(block);
					// System.out.println("i: " + i + ", " + Solution.blocksString(blocks));
				} else if (H[i] == H[i - 1]) {
					// continue current blocks, do nothing
				} else if (H[i] < H[i - 1]) {
					Solution.closeBlocks(blocks, false, i - 1, H[i]);
					// System.out.println("i: " + i + ", " + Solution.blocksString(blocks));
					// open new 
					int openTop = Solution.getOpenTop(blocks);
					if(H[i] > openTop) {
						// something above open blocks, start new one
						block = new Block(i, openTop+1, -1, H[i]);
						blocks.add(block);
						// System.out.println("i: " + i + ", " + Solution.blocksString(blocks));
					}

				}
			}
			if(i == n-1) {
				// end of wall, close all
				Solution.closeBlocks(blocks, true, i, H[i]);
			}			
		}
		// System.out.println("===============\n" + Solution.blocksString(blocks));
        Iterator<Block> it = blocks.iterator();
        while(it.hasNext()) {
        	block = it.next();
        	if(!block.isComplete()) {
        		System.err.println("Not completed: " + block);
        	} else {
        		blocksNo++;
        	}
        }
        // System.out.println("Minimum blocks number: " + blocksNo);
        return blocksNo;

    }
    
	public static String blocksString(List<Block> blocks) {
		String result = "\nBlocks:\n";
		Iterator<Block> it = blocks.iterator();
		while(it.hasNext()) {
			result += it.next();
		}
		return result;
	}
        
    public static void closeBlocks(List<Block> blocks, boolean closeAll, int endIdxLeft, int currentVal) {
    	Iterator<Block> it = blocks.iterator();
    	Block block;
    	while(it.hasNext()) {
    		block = it.next();
    		if(closeAll || block.getEndTop() > currentVal) {
    			if(!block.isComplete()) {
    				block.setEndIdxLeft(endIdxLeft);
    			}
    		}
    	}
    }
    
    public static int getOpenTop(List<Block> blocks) {
    	int maxTop = 0, top;
    	Iterator<Block> it = blocks.iterator();
    	Block block;
    	while(it.hasNext()) {
    		block = it.next();
    		if(!block.isComplete()) {
    			top = block.getEndTop();
    			if(top > maxTop) {
    				maxTop = top;
    			}
    		}
    	}
    	return maxTop;
    }
    
//     public static void main(String [] args) {
//     	int [] H = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
//     	int count = new Solution().solution(H);
//     	System.out.println("Count: " + count);
//     }
}