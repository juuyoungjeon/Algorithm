import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] C = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = N; i < N + M; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(C);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N + M; i++) {
			sb.append(C[i] + " ");
		}
		System.out.println(sb);

	}

}