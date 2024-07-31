import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] stars;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		stars = new char[N][N * 2 - 1];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		star(0, N-1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2 - 1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void star(int r, int c, int N) {
		if(N == 3) {
			stars[r][c] = '*';
			stars[r+1][c-1] = stars[r+1][c+1] = '*';
			stars[r+2][c-2] = stars[r+2][c-1] = stars[r+2][c] = stars[r+2][c+1] = stars[r+2][c+2] = '*';
			return;
		}else {
			int cut = N/2;
			star(r,c,cut);
			star(r+cut,c-cut,cut);
			star(r+cut,c+cut,cut);
		}
	}

}