import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt;
	static int[][] map, copy;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Integer> list;
	static int[][] visited;
	static int[] dongCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		copy = new int[N][N];
		visited = new int[N][N];
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				
			}
		}
		int dong=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0 && visited[i][j]==0) {
					dfs(i,j,dong);
					dong++;
				}
			}
		}
		dongCnt=new int[dong];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==0) continue;
				dongCnt[visited[i][j]]+=1;
			}
		}
		dongCnt[0]=999999999;
		Arrays.sort(dongCnt);
		System.out.println(dongCnt.length-1);
		for(int i=0;i<dongCnt.length-1;i++) {
			System.out.println(dongCnt[i]);
		}
	}
	
	public static void dfs(int x, int y,int dong) {
		visited[x][y] = dong;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(visited[nx][ny]!=0) continue;
			if(map[nx][ny] != 0 && visited[nx][ny]==0) {
				visited[nx][ny]=dong;
				dfs(nx,ny,dong);
			}
		}
	}

}