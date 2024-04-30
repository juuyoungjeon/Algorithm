import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static class Node{
		int idx;
		int him;
		int min;
		int ji;
		public Node(int idx, int him, int min, int ji) {
			this.idx = idx;
			this.him = him;
			this.min = min;
			this.ji = ji;
		}
	}
	static ArrayList<Node> list = new ArrayList<>();
	static int[][] info;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		info = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					int cnt = 0;
					for(int l = 0; l < N; l++) {
						if(info[i][0] >= info[l][0] && info[j][1] >= info[l][1] && info[k][2] >= info[l][2]) {
							cnt++;
						}
					}
					if(cnt >= K) {
						min = Math.min(min, info[i][0] + info[j][1] + info[k][2]);
					}
				}
			}
		}
		
		System.out.println(min);
		
	}

}