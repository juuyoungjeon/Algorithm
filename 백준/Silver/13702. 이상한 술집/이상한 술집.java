import java.util.*;
import java.io.*;

public class Main {
	static int N, K,max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
//		int min = Integer.MAX_VALUE;
//		int add = 0;
		max = Integer.MIN_VALUE;
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
//			add += arr[i];
			max = Math.max(max, arr[i]);
		}
		
		
		long s = 1;
		long e = max;
		
		while(s <= e) {
			long mid = (s + e) / 2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += arr[i] / mid;
			}
			if(sum >= K) {
				s = mid + 1;
			}else if(sum < K) {
				e = mid - 1;
			}
		}
		
		System.out.println(e);
	}

}