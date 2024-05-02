import java.util.*;
import java.io.*;

public class Main {
	static int[] A;
	static String input;
	static int B, C;
	static int ans = -1;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		input = st.nextToken();
		A = new int[input.length()];
		B = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < input.length(); i++) {
			A[i] = input.charAt(i) -'0';
		}
		
		visited = new boolean[input.length()];
		
		dfs(0,0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int depth, int num) {
		if(depth == input.length()) {
			ans = Math.max(ans, num);
			return;
		}
		for(int i = 0; i < input.length(); i++) {
			if(visited[i] || (A[i] == 0 && depth == 0)) continue;
			if(num * 10 + A[i] > B) continue;
			
			visited[i] = true;
			dfs(depth + 1, num * 10 + A[i]);
			visited[i] = false;
		}
	}

}