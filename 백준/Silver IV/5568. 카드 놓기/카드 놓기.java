import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] arr,card;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static String str;
	static HashSet<String> hs;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		arr = new int[k];
		card = new int[n];
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		visited = new boolean[n];
		hs = new HashSet<>();
		dfs(0);
		System.out.println(hs.size());

	}
	public static void dfs(int depth) {
		if(depth == k) {
			str = "";
			for(int i = 0; i < k; i++) {
				str += arr[i];
			}
			hs.add(str);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = card[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

}