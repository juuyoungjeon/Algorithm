import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;
	public static int V;
	
	public static boolean[] visited;
	public static int[][] link;
    
    public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	V = Integer.parseInt(st.nextToken());
	
	visited = new boolean[N+1];
	link = new int[N+1][N+1];
	
	for(int i = 0; i< M; i++) {
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		link[start][end] = 1;
		link[end][start] = 1;
	}

    sb = new StringBuilder();
	
	dfs(V);
	System.out.println(sb.toString());
	
	sb.setLength(0);
	Arrays.fill(visited, false);
	
	bfs(V);
	System.out.println(sb.toString());
	}
	
	public static void dfs(int vertex) {
		visited[vertex] = true;
		sb.append(vertex).append(" ");
		
		for(int i = 1; i <= N; i++) {
			if(link[vertex][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
		
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append(start).append(" ");
		
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			
			for(int i = 1; i<=N; i++) {
				if(link[vertex][i] == 1 && !visited[i])	{
					sb.append(i).append(" ");
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
