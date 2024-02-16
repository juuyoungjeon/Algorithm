import java.util.*;
import java.io.*;

public class Main {
	static int N, sum1, sum2, ans;
	static int[][] S;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		S = new int[N][N];
		
		arr = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum1 = 0; sum2 = 0;
		ans = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(ans);
		
	}
	
	public static void dfs(int depth, int start) {
		if(depth == N/2) {
//			for(int i = 0; i < N / 2 - 1; i++) {
//				for(int j = i+1; j < N / 2; j++) {
//					sum1 += S[arr[i]][arr[j]] + S[arr[j]][arr[i]];
//				}
//			}
//			
//			for(int i = N / 2; i < N - 1; i++) {
//				for(int j = i+1; j < N; j++) {
//					sum2 += S[arr[i]][arr[j]] + S[arr[j]][arr[i]];
//				}
//			}
//			
//			for(int i = 0; i < N; i++) {
//				sb.append(arr[i] + " ");
//			}
//			sb.append("\n");
//			System.out.println(sum1 + " " + sum2);
//			ans = Math.min(ans, Math.abs(sum1 - sum2));
			
			diff();
			return;
		}
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
//				arr[depth] = i;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
		
	}
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visited[i] == true && visited[j] == true) {
					team_start += S[i][j];
					team_start += S[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visited[i] == false && visited[j] == false) {
					team_link += S[i][j];
					team_link += S[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(team_start - team_link);
		
		/*
		  두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		  더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		ans = Math.min(val, ans);
	}

}