import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] W;
	static int[][] P;
	static long sum;
	static class Node implements Comparable<Node>{
		int v1, v2;
		int W;
		public Node(int v1, int v2, int W) {
			this.v1 = v1;
			this.v2 = v2;
			this.W = W;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return W - o.W;
		}
	}
	static ArrayList<Node> list = new ArrayList<>();
	static boolean[] visited;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N + 1];
		parents = new int[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		sum = 0;
		P = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			W[i] = Integer.parseInt(br.readLine());
			parents[i] = i;
		}
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if(i == j) {
					pq.add(new Node(0, i, W[i]));
				}else if(i < j) {
					pq.add(new Node(i, j, w));
				}
			}
		}
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(find(node.v1) == find(node.v2)) {
				continue;
			}
			
			union(node.v1, node.v2);
			sum += node.W;
		}
		
		
		
		System.out.println(sum);
		    
	}
	public static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1 > p2) {
			parents[p1] = p2;
		}else {
			parents[p2] = p1;
		}
	}
	public static int find(int v) {
		if(parents[v] == v) {
			return v;
		}else {
			return find(parents[v]);
		}
	}

}