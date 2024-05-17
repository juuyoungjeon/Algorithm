import java.util.*;


import java.io.*;

public class Main {
	static int N, D;
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		distance = new int[10001];
		list = new ArrayList<>();
		for(int i = 0; i <= 10001; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < D + 1; i++) {
			distance[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Node(e, cost));
		}
		
		dijkstra(0);

		
		System.out.println(distance[D]);
	}
	public static void dijkstra(int start) {
		if(start > D) return;
		
		if(distance[start+1] > distance[start] + 1) distance[start+1] = distance[start] + 1;
		
		for(int i=0;i<list.get(start).size();i++){
            if(distance[start]+list.get(start).get(i).cost < distance[list.get(start).get(i).index])
                distance[list.get(start).get(i).index] = distance[start]+list.get(start).get(i).cost;
        }
		
		dijkstra(start+1);
	}

}