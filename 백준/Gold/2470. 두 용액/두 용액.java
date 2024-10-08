import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		/*
		 *  -99 -2 -1 4 98
		 * 
		 * */
		int s = 0;
		int e = N - 1;
		long a = 0;
		long b = 0;
		long min = Long.MAX_VALUE;
		while(s < e) {
			long sum = arr[s] + arr[e];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				a = arr[s];
				b = arr[e];
				
				if(sum == 0) break;
			}
		
			if(sum < 0) s++;
			else e--;
		}
		
		System.out.println(a + " " + b);
	}

}