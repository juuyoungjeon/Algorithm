import java.util.*;
import java.io.*;

public class Main {
	static String a;
	static int b;
	static int[] arr1;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());

		arr1 = new int[a.length()];
		for(int i = 0; i < a.length(); i++) {
			arr1[i] = a.charAt(i) - '0';
		}

		visited = new boolean[a.length()];

		solve(0,0);
		
		System.out.println(ans);

	}
	static int ans = -1;
	public static void solve(int depth, int num) {
		if(depth == a.length()) {
			ans = Math.max(ans, num);
			return;
		}

		for(int i = 0; i < a.length(); i++) {
			if(visited[i] || (arr1[i] == 0 && depth == 0)) continue;
			if(num * 10 + arr1[i] > b) continue;
			
			visited[i] = true;
			solve(depth + 1, num * 10 + arr1[i]);
			visited[i] = false;
		}
	}
}