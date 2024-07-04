import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] parents;
	static class Node implements Comparable<Node>{
		int to;
		int from;
		int value;
		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		int total = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if('a' <= map[i][j] && map[i][j] <= 'z') {
					total += map[i][j] - 96;
					pq.add(new Node(i+1, j+1, map[i][j] - 96));
				}else if('A' <= map[i][j] && map[i][j] <= 'Z') {
					total += map[i][j] - 38;
					pq.add(new Node(i+1, j+1, map[i][j] - 38));
				}
			}
		}
		
		int size = pq.size();
		int cycleNode = 1;
		int res = 0;
		for(int i = 0; i < size; i++) {
			Node node = pq.poll();
			int rx = find(node.to);
			int ry = find(node.from);
			
			if(rx != ry) {
				cycleNode++;
				res += node.value;
				union(node.to, node.from);
			}
		}
		if(cycleNode != N) {
			System.out.println(-1);
		}else {
			System.out.println(total - res);
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) {
			parents[y] = x;
		}else {
			parents[x] = y;
		}
	}

}