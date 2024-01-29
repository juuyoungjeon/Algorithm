import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		arr = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long left = 1;
		long right = max;
		while(left <= right) {
			long mid = (left + right) / 2;
			int sum = 0;
			for(int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}
			
			if(sum >= N) {
				left = mid + 1;
			}else if(sum < N){
				right = mid - 1;
			}
		}
		System.out.println(right);
	}

}