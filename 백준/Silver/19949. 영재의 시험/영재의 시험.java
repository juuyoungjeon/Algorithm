import java.util.*;
import java.io.*;

public class Main {
	static int[] ans, arr, visited;
	static int cnt, res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = new int[10];
		arr = new int[10];
		
		for (int i = 0; i < 10; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		res = 0;
		dfs(0);
		System.out.println(res);
//		check(0);
//		System.out.println(sb);
		
	}
	
	public static void dfs(int depth) {
		if (depth == 10) {
			cnt = 0;
			for(int i = 0; i < 10; i++) {
				if(arr[i] == ans[i]) {
					cnt++;
				}
				if(cnt == 5) {
					res++;
					return;
				}
			}
			return;
		}
		
		for(int i = 1; i <= 5; i++) {
			if(depth > 1) {
				if(arr[depth-2] == arr[depth - 1] && arr[depth - 1] == i) continue;
			}
			arr[depth] = i;
			dfs(depth + 1);
		}
		
	}
	
	public static void check(int depth) {
		if(depth == 10) {
			for(int i = 0; i < 10; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= 5; i++) {
			arr[depth] = i;
			check(depth + 1);
		}
	}

}