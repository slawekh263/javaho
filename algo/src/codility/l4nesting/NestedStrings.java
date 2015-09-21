package codility.l4nesting;

public class NestedStrings {
	// 100%
    public int solution(String S) {
        int result = 0;
        int openings = 0;
        int wrongClosings = 0;
        char c;
        for(int i=0; i<S.length(); i++) {
            c=S.charAt(i);
            if(c == '(') {
                openings++;
            } 
            if(c == ')') {
                if(openings > 0) {
                    openings--;
                } else {
                    wrongClosings++;
                    break;
                }
            }
        }
        if(openings == 0 && wrongClosings == 0) {
            result = 1;
        }
        return result;
        
    }	

}
