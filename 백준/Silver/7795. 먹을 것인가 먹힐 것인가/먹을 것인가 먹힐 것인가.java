import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] A, B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
//			Arrays.sort(A);
			Arrays.sort(B);
			int ans = 0;
			for(int i = 0; i < N; i++) {
				int s = 0;
				int e = M - 1;
				int cnt = 0;
				while(s <= e) {
					int mid = (s + e) / 2;
					if(B[mid] < A[i]) {
						s = mid + 1;
						cnt = mid + 1;
					}else {
						e = mid - 1;
					}
				}
				ans += cnt;
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}