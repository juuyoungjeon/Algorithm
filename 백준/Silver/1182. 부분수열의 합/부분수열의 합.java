import java.util.*;
import java.io.*;

public class Main {
	static int N, S;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		System.out.println(S == 0? cnt - 1 : cnt);
		
	} 
	public static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				cnt++;
			}
			return;
		}
		dfs(depth + 1, sum + arr[depth]);
		dfs(depth + 1, sum);
	}

}