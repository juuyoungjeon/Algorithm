import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int sum;
	static class Node{
		int num;
		int val;
		public Node(int num, int val) {
			this.num = num;
			this.val = val;
		}
	}
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		
		
		
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sum = 0;
			//bfs(x,y);
			//dfs(x,y);
			sb.append(bfs(x,y)).append("\n");
		}
		System.out.println(sb);
		
	}
	public static int bfs(int start, int end) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		visited = new boolean[N + 1];
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.num == end) {
				return n.val;
				
			}
			for(Node i : list.get(n.num)) {
				if(!visited[i.num]) {
					visited[i.num] = true;
					//sum += i.val;
					q.add(new Node(i.num, n.val + i.val));
				}
			}
			
		}
		return -1;
		
	}
	public static void dfs(int start, int end) {
		visited[start] = true;
		
		for(int i = 0; i < list.get(start).size(); i++) {
			Node n = list.get(start).get(i);
			if(!visited[n.num]) {
				visited[n.num] = true;
				sum += n.val;
			}
		}
	}

}