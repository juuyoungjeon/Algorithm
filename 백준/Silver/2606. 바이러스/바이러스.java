import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] adjMatrix;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
	
		adjMatrix = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		visited = new boolean[N+1]; 
		bfs(1);
		
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(start);
		visited[start] = true;
		
		int current = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			current = q.poll();
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && (adjMatrix[current][i] != 0 || adjMatrix[i][current] != 0)) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}