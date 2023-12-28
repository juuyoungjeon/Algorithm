import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	static int V, E, K;
	static ArrayList<ArrayList<Node>> graph;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); //정점
		E = Integer.parseInt(st.nextToken()); //간선
		K = Integer.parseInt(br.readLine()); //시작정점

		graph = new ArrayList<ArrayList<Node>>();

		for(int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, value));

		}
		
		distance = new int[V+1];
		int INF = Integer.MAX_VALUE;
		
		for(int i = 0; i < V + 1; i++) {
			distance[i] = INF;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost,  o2.cost));
		
		q.offer(new Node(K, 0));
		
		distance[K] = 0;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(distance[tmp.idx] < tmp.cost) {
				continue;
			}
			
			for(int i = 0; i < graph.get(tmp.idx).size(); i++) {
				Node next = graph.get(tmp.idx).get(i);
				
				if(distance[next.idx] > tmp.cost + next.cost) {
					distance[next.idx] = tmp.cost+next.cost;
					q.offer(new Node(next.idx, distance[next.idx]));
				}
			}
		}
		for(int k = 1; k < V + 1; k++) {
		System.out.println(distance[k] != INF? distance[k] : "INF");
	}
		
	}
}

//public class JUN1753_Jeonjuyoung {
//
//	static int V, E, K;
//	static int start;
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		V = Integer.parseInt(st.nextToken()); //정점
//		E = Integer.parseInt(st.nextToken()); //간선
//		K = Integer.parseInt(br.readLine()); //시작정점
//
//		int[][] adjMatrix = new int[V+1][V+1];
//		for(int i =0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int value = Integer.parseInt(st.nextToken());
//
//			adjMatrix[start][end] = value;
//
//		}
//
//		final int INF = Integer.MAX_VALUE;
//		int[] distance = new int[V+1];
//		boolean[] visited = new boolean[V+1];
//
//		Arrays.fill(distance, INF);
//		distance[K] = 0;
//
//		int min, current;
//		for(int c = 0; c < V + 1; c++) {
//			current = -1;
//			min = INF;
//
//			for(int i = 1; i < V + 1; i++) {
//				if(!visited[i] && min > distance[i]) {
//					min = distance[i];
//					current = i;
//				}
//			}
//
//			if(current == -1) break;
//			visited[current] = true;
//
//			for(int j = 1; j < V + 1; j++) {
//				if(!visited[j] && adjMatrix[current][j] != 0
//						&& distance[j] > min + adjMatrix[current][j]) {
//					distance[j] = min + adjMatrix[current][j];
//				}
//			}
//		}
//
//		for(int k = 1; k < V + 1; k++) {
//			System.out.println(distance[k] != INF? distance[k] : "INF");
//		}
//	}
//
//}