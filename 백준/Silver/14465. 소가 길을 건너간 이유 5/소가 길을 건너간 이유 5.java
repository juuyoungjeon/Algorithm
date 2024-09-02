import java.util.*;
import java.io.*;

public class Main {
	static int N,K,B;
	static int cnt;
	static int minus = Integer.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		Arrays.fill(arr, 1);
		
		for(int i = 0; i < B; i++) {
			arr[Integer.parseInt(br.readLine())] = 0;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[i] += arr[i-1];
		}
		for(int i = K; i <= N; i++) {
			minus = Math.min(minus, K - (arr[i] - arr[i - K]));
		}
		
		System.out.println(minus);
	}

}