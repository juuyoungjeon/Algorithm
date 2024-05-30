import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] preCity;
	static int[][] map;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		preCity = new int[n + 1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = INF;
				preCity[i][j] = -1;
				
				if(i==j) {
					map[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], c);
			preCity[a][b] = a;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						preCity[i][j] = preCity[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == INF) {
					map[i][j] = 0;
				}
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(preCity[i][j] == -1) {
					sb.append(0).append("\n");
				}else {
					Stack<Integer> path = new Stack<>();
					int pre = j;
					path.push(j);
					
					while(i != preCity[i][pre]) {
						pre = preCity[i][pre];
						path.push(pre);
					}
					
					sb.append(path.size() + 1 + " ");
					
					sb.append(i + " ");
					while(!path.isEmpty()) {
						sb.append(path.pop() + " ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
		
	}

}