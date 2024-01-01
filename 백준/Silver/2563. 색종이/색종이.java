import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		for(int i= 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				map[i][j] = 0;
			}
		}
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					map[j][k] = 1;			
				}
			}
		}
		
		for(int i= 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j]==1) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}