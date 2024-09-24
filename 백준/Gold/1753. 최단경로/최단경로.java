import java.util.*;
import java.io.*;

public class Main {
	static int V, E, K;
	static int[] dist;
	static int min = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> list;
	static class Node implements Comparable<Node>{
		int idx;
		int value;
		
		public Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		dist = new int[V+1];
		for(int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v,w));
		}
		
		dijkstra(K);
		for(int i = 1; i <= V; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE? dist[i] : "INF").append("\n");
		}
		
		System.out.println(sb);
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.idx] < now.value) continue;
			
			for(int i = 0; i < list.get(now.idx).size(); i++) {
				Node next = list.get(now.idx).get(i);
				
				if(dist[next.idx] > now.value + next.value) {
					dist[next.idx] = now.value + next.value;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}

}