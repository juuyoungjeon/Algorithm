import java.util.*;
import java.io.*;

public class Main {
	//floyd / dfs / dijkstra
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = dist[i][j];
			}
		}
		//k = middle, i = start, j = end
		//dist = map, arr = map2
		int sum = 0;
		for(int middle = 0; middle < N; middle++) {			
			for(int start = 0; start < N; start++) {
				for(int end = 0; end < N; end++) {
					if(start == end || start == middle || middle == end) {
						continue;
					}
					if(dist[start][end] > dist[start][middle] + dist[middle][end]) {
						System.out.println("-1");
						return;
					}
					if(dist[start][end] == dist[start][middle] + dist[middle][end]) {
						arr[start][end] = INF;
					}
				}
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] != INF && !visited[i][j] && i != j) {
					sum += arr[i][j];
					visited[i][j] = visited[j][i] = true;
				}
			}
		}
		System.out.println(sum);
	}

}