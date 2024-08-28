import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		int total = 0;
		while(e <= N) {
			if(total >= M) {
				total -= arr[s++];
			}else {
				total += arr[e++];
			}
			
			if(total == M) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}