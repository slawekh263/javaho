package algo;

public class CharOccurence {

	public static void main(String[] args) {
		System.out.println(findOccurence("Test z javy i z kavy" , 'x'));
	}
	
	public static int findOccurence(String s, char c) {
		int result = 0;
		char [] sArr = s.toCharArray();
		for(int i=0; i<sArr.length; i++) {
			if(sArr[i] == c) {
				result++;
			}
		}
		return result;
	}

}
