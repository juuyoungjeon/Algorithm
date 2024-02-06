import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] S, B;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		S = new int[N];
		B = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(0,0,1,0);
		System.out.println(ans);
	}

	public static void recur(int depth, int selectCnt, int sumS, int sumB) {
		if(depth == N) {
			if(selectCnt != 0) {//요리를 선택했다면 실행, 요리 선택을 안했으면 계산할 필요가 없음
				ans = Math.min(ans, Math.abs(sumS - sumB));
			}
			return;
		}
		
		recur(depth+1, selectCnt+1, sumS * S[depth], sumB + B[depth]);
		recur(depth+1, selectCnt, sumS, sumB);
	}
}