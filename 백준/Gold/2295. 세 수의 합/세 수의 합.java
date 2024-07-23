import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] sum;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sum = new int[N*(N+1)/2];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				sum[idx++] = arr[i] + arr[j];
			}
		}
		Arrays.sort(sum);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int target = arr[i] - arr[j];
				if(Arrays.binarySearch(sum, target) > - 1) {
					max = Math.max(max, arr[i]);
				}
			}
		}


		System.out.println(max);

	}
	
}