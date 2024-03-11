import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[] visited;
	static int[] arr;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		visited = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			visited[i] = true;
			dfs(i,i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void dfs(int start, int target) {
		if(!visited[arr[start]]) {
			visited[arr[start]] = true;
			dfs(arr[start], target);
			visited[arr[start]] = false;
		}
		if(arr[start] == target) {
			list.add(target);
		}
	}
}