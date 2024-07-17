import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] A, B;
	static long hi_win, draw, arc_win;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);

		for(int i = 0; i < N; i++) {
			int s = 0;
			int e = M-1;
			int left = M;
			
			int target = A[i];
			while(s<=e) {
				int mid = (s + e) / 2;
				if(B[mid] >= target) {
					left = mid;
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
			int right = -1;
			s = 0;
			e = M - 1;
			while(s<=e) {
				int mid = (s+e)/2;
				
				if(B[mid] <= target) {
					right = mid;
					s = mid + 1;
				}else {
					e = mid - 1;
				}
			}
			hi_win += left;
			draw += (right - left + 1);
			arc_win += (M - right - 1);
		}
		
		System.out.println(hi_win + " " + arc_win + " " + draw);
	}

}