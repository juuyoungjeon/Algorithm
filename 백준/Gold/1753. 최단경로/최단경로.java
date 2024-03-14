import java.util.*;
import java.io.*;

public class Main {
	static int[] dist;
	static int v, e, k;
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}
		
		dist = new int[v + 1];
		for(int i = 1; i <= v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
		}
		
		bfs();
		
		for(int i = 1; i <= v; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE? dist[i] : "INF").append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		dist[k] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.idx] < now.cost) continue;
			
			for(int i = 0; i < list.get(now.idx).size(); i++) {
				Node next = list.get(now.idx).get(i);
				
				if(dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}

}