package hackerrank.sample;

import java.util.Scanner;

class Solution
{
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0; t < n; t++) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(a+b);
        }
    }
}