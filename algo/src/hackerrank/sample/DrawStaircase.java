package hackerrank.sample;

import java.util.Arrays;
import java.util.Scanner;
public class DrawStaircase {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [] arr = new char[n];
        Arrays.fill(arr, ' ');
        for(int i=n-1; i>=0; i--) {
            arr[i] = '#';
            System.out.println(new String(arr));
        }
        sc.close();
    }
}
