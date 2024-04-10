import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] note1, note2;
	static int find;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			note1 = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(note1);
			
			M = Integer.parseInt(br.readLine());
			
			note2 = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				note2[i] = Integer.parseInt(st.nextToken());
				
				binarySearch(note2[i]);
			}
		}
		System.out.println(sb);
	}
	static int ans;
	public static void binarySearch(int a) {
		int s = 0;
		int e = N-1;
		ans = 0;
		while(s<=e) {
			int mid = (s+e)/2;
			if (note1[mid] == a) {
				ans = 1;
				break;
			}
			if(a > note1[mid]) {
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		
		sb.append(ans).append("\n");
	}
}