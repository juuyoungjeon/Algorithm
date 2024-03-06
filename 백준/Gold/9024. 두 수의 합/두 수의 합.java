import java.util.*;
import java.io.*;

public class Main {
	static int t, n, k, cnt;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			solve();
		}
		System.out.println(sb);
	}
	
	public static void solve() {
		int s = 0;
		int e = n - 1;
		int find = Integer.MAX_VALUE;
		cnt = 0;
		while(s < e) {
			int sum = arr[s] + arr[e];
			int gap = Math.abs(sum - k);
			if(sum >= k) {
				e--;
			}
			else {
				s++;
			}
			if(find >= gap) {
				if(find > gap) {
					cnt = 0;
				}
				find = gap;
				cnt++;
			}
		
		}
//		System.out.println(find);
//		if(cnt > 0) {
//			sb.append(cnt).append("\n");
//		}else {
//			int s2 = 0;
//			int e2 = n - 1;
//			while(s < e) {
//				int sum = arr[s2] + arr[e2];
//				if(sum < find) {
//					s++;
//				}
//				else if(sum > find) {
//					e--;
//				}
//				else if(Math.abs(sum - k) == find) {
//					cnt++;
//					s++;
//					e--;
//				}
//			}
			sb.append(cnt).append("\n");
		
	}

}