import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int T;
	static int S, I, C;
	static int[] arr;
	static int tmp = Integer.MAX_VALUE;
	static int result = -1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			I = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
//			arr = new int[C];
//			arr[0] = S;
//			for(int j = 1; j < C; j++) {
//				arr[j] = arr[j-1] + I;
//			}
			
			int s = 1;
			int e = C;
			
			while(s <= e) {
				int mid = (s+e)/2;
				if(ok(mid)) {
					result = Math.min(tmp, (S+I*(mid-1)) - T);
					tmp = result;
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
		}
		System.out.println(result);
	}
	public static boolean ok(int mid) {
		return S + I *(mid- 1) >= T;
	}

}