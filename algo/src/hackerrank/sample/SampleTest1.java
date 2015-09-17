package hackerrank.sample;

import java.util.Scanner;

public class SampleTest1 {

	static void findingDigits(int[] foo) {
		int number;
		int[] digits;
		int cntr;
		if (foo != null) {
			for (int i = 0; i < foo.length; i++) {
				cntr = 0;
				number = foo[i];
				digits = getDigits(number);
				for (int j = 0; j < digits.length; j++) {
					if(digits[j] != 0) {
						if (number % digits[j] == 0) {
							cntr++;
						}
					}
				}
				System.out.println(cntr);
			}
		}
	}

	static int[] getDigits(int number) {
		int[] result = null;
		String str = Integer.toString(number, 10);
		result = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			result[i] = Integer.parseInt(new String(new char[]{str.charAt(i)}), 10);
			System.out.println("digit: " + result[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _foo_size = 0;
		_foo_size = Integer.parseInt(in.nextLine());
		int[] _foo = new int[_foo_size];
		int _foo_item;
		for (int _foo_i = 0; _foo_i < _foo_size; _foo_i++) {
			_foo_item = Integer.parseInt(in.nextLine());
			_foo[_foo_i] = _foo_item;
		}

		findingDigits(_foo);

	}

}
