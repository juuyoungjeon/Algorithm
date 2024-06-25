import java.util.*;
import java.io.*;

public class Main {
	static int[][] map = new int[8][7];
	static int[][] select = new int[8][7];
	static boolean[][] visit = new boolean[8][7];
	static boolean[][] domino = new boolean[7][7];
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int i = 0; i < 8; i++) {
			String s = br.readLine();
			for(int j = 0; j < 7; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		solve(0,0);
		
		System.out.println(cnt);
	}
	
	public static void solve(int r, int c) {
		if(r == 8) {
			cnt++;
			return;
		}
		
		if(c == 7) {
			solve(r+1, 0);
			return;
		}
		
		if(!visit[r][c]) {
			visit[r][c] = true;
			int curNum = map[r][c];
			
			for(int i = 0; i < 2; i++) {
				if(i == 0) {
					int nextR = r + 1;
					int nextC = c;
					
					if(nextR >= 8 || nextC >= 7) continue;
					
					int pairNum = map[nextR][nextC];
					
					if(visit[nextR][nextC]) continue;
					
					if(domino[curNum][pairNum]) continue;
					
					visit[nextR][nextC] = true;
					domino[curNum][pairNum] = true;
					domino[pairNum][curNum] = true;
					solve(r, c+ 1);
					visit[nextR][nextC] = false;
					domino[curNum][pairNum] = false;
					domino[pairNum][curNum] = false;
					
				}
				if(i == 1) {
					int nextR = r;
					int nextC = c+1;
					
					if(nextR >= 8 || nextC >= 7) continue;
					
					int pairNum = map[nextR][nextC];
					
					if(visit[nextR][nextC]) continue;
					
					if(domino[curNum][pairNum]) continue;
					
					visit[nextR][nextC] = true;
					domino[curNum][pairNum] = true;
					domino[pairNum][curNum] = true;
					solve(r, c+ 1);
					visit[nextR][nextC] = false;
					domino[curNum][pairNum] = false;
					domino[pairNum][curNum] = false;
					
				}
			}
			visit[r][c] = false;
		}else {
			solve(r,c+1);
		}
	}

}