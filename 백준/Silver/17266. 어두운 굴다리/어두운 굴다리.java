import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 1;
		int e = N;
		int ans = 0;
		
		while(s<=e) {
			int mid = (s+e)/2;
			if(ok(mid)) {
				ans = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		System.out.println(ans);
	}
	public static boolean ok(int mid) {
		int prev = 0;
		for(int i = 0; i < M; i++) {
			if(arr[i] - mid <= prev) {
				prev = arr[i] + mid;
			}else {
				return false;
			}
		}
		return N -prev <= 0;
	}

}