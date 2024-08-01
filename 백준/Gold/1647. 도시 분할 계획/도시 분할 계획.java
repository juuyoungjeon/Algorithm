import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static boolean[] visited;
	static int sum;
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		
		prim(1);
		System.out.println(sum - max);

	}
	static int max;
	public static void prim(int idx) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(idx, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			sum += now.cost;
			max = Math.max(max, now.cost);
			
			for(Node next : list.get(now.idx)) {
				if(!visited[next.idx]) {
					pq.add(next);
				}
			}
		}
	}

}