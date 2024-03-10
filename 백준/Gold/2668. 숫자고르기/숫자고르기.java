import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Integer> list;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int start, int target) {
		if(visited[arr[start]] == false) {
			visited[arr[start]] = true;
			dfs(arr[start], target);
			visited[arr[start]] = false;
		}
		if(arr[start] == target) list.add(target);
	}

}