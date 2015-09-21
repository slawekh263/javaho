package algo;

public class Palindrome {
	public static void main(String [] args) {
		
		String orig = "MAOAM";
		char [] chars = orig.toCharArray();
		char [] reverse = new char[chars.length];
		for(int i=0; i<chars.length; i++) {
			reverse[chars.length-1-i] = chars[i];
		}
		String reversedString = new String(reverse);
		System.out.println("orig: " + orig + ", reverse: " + reversedString);
	}
}
