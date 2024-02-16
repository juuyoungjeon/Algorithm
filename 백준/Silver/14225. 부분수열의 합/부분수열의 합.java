import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited, check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		check = new boolean[100_000*20 + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			check[arr[i]] =true;
		}
		
		//Arrays.sort(arr);
		
		visited = new boolean[N + 1];
		solve(0, 0);
		
		for(int i = 1; i < 100_000*20 + 1; i ++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static void solve(int depth, int sum) {
		if(depth == N) {
			check[sum] = true;
			return;
		}
		solve(depth + 1, sum + arr[depth]);
		solve(depth + 1, sum);
	}

}