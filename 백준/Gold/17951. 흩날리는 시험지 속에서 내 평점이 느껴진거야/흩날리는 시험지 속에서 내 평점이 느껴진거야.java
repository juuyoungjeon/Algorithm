import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int sum;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
//		Arrays.sort(arr);
		
		int s = 0;
		int e = sum;
		
		while(s<=e) {
			int mid = (s + e) / 2;
			
			int sum = 0;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				sum += arr[i];
				if(sum >= mid) {
					cnt++;
					sum = 0;
				}
			}
			if(cnt >= K) {
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		
		System.out.println(e);
	}
	
}