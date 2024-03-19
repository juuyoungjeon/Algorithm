import java.util.*;
import java.io.*;

public class Main {

	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N; //숫자 갯수
	static int[] A; //숫자
	static int[] B = new int[4]; //연산자
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			
			B[i] = Integer.parseInt(st.nextToken());
		}

		dfs(A[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);

	}
	public static void dfs(int num, int idx) {
		if(idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(B[i] > 0){
				B[i]--;

				switch (i) {
				
				case 0: dfs(num + A[idx], idx + 1);
				break;
				
				case 1: dfs(num - A[idx], idx + 1);
				break;
				
				case 2: dfs(num * A[idx], idx + 1);
				break;
				
				case 3: dfs(num / A[idx], idx + 1);
				break;
				
				}
				B[i]++;
			}
		}
	}

}