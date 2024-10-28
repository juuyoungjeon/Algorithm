import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k;
	static int min;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int cost = Integer.MAX_VALUE;
	static ArrayList<Integer> money;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				min += dfs(i);
			}
		}
		
		if(min <= k) {
			System.out.println(min);
		}else {
			System.out.println("Oh no");
		}

	}
	public static int dfs(int depth) {
		visited[depth] = true;
		int cost = arr[depth];
		
		for(int i : list.get(depth)) {
			if(!visited[i]) {
				visited[i] = true;
				cost = Math.min(cost, dfs(i));				
			}
		}
		
		return cost;
	}

}

/*
 * 1  2  3  4  5
 * 10 10 20 20 30
 * 
 * 1 3
 * 2 4
 * 5 4
 * 
 * 각 그룹별 가장 작은 금액
 * 
 * 1 3 / 2 4 5
 * 
 * 
 * */