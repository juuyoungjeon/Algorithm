import java.util.*;
import java.io.*;

public class Main {
	static int N, T, P;
	static int sum;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[6];

		for(int i = 0; i < 6; i++) {
			a[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		int p = sc.nextInt();

		int count = 0;
		for(int i = 0; i < 6; i++) {
			count += a[i] / t;
			if(a[i] % t != 0) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(n / p + " " + n % p);
	}

}