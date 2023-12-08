import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(N == 0 && K == 0) break;
			int[] arr = new int[N + 1];
			int[] parent = new int[N + 1];
			
			int idx = -1;
			arr[0] = -1;
			parent[0] = -1;
			int target = 0;
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] != arr[i-1] + 1) {
					idx++;
				}
				
				if(arr[i] == K) {
					target = i;
				}
				parent[i] = idx;
			}
			for(int i = 1; i <= N; i++) {
				if(parent[target] != parent[i] && parent[parent[target]] == parent[parent[i]]) {
					ans++;
				}

			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}