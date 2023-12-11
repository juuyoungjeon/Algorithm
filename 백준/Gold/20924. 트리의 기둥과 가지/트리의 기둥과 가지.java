import java.util.*;
import java.io.*;

public class Main {
	static int N, R, G;
	static int[] parent;
	static long Max;
	static boolean[] visited;
	//static ArrayList<ArrayList<Integer>> list;
	static class Node{
		int b;
		int d;
		public Node(int b, int d) {
			this.b = b;
			this.d = d;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		visited = new boolean[N + 5];
		list = new ArrayList<>(N + 5);
		for(int i = 0; i < N + 5; i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, d));
			list.get(b).add(new Node(a, d));
		}
		
		System.out.println(getPillar(R) + " " + getBranch(G));
		
	}
	public static int getPillar(int idx) {
		visited[idx] = true;
		G = idx;
		if((idx == R && list.get(idx).size() > 1) || (idx != R && list.get(idx).size() != 2) || N == 1) {
			return 0;
		}
		Node nextNode = list.get(idx).get(0);
		nextNode = (visited[nextNode.b] == true) ? list.get(idx).get(1) : nextNode;
		return getPillar(nextNode.b) + nextNode.d;
	}
	public static int getBranch(int idx) {
		visited[idx] = true;
		int ret = 0;
		for(int i = 0; i < list.get(idx).size(); i++) {
			Node nextNode = list.get(idx).get(i);
			if(visited[nextNode.b]) continue;
			ret = Math.max(ret, getBranch(nextNode.b) + nextNode.d);
		}
		return ret;
	}

}