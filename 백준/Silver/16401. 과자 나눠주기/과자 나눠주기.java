import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static int[] arr;
	static int cnt;
	static long ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long s = 1;
		long e = arr[N-1];
		
		while(s<=e) {
			long mid = (s+e)/2;
			if(check(mid) >= M) {
				if(ans < mid) ans = mid;
				s = mid + 1;
			}else {
				e = mid - 1;
			}
			
		}
		
		System.out.println(ans);
	}
	public static int check(long length) {
		cnt = 0;
		
		for(int i = 0; i < N; i++) {
				cnt += arr[i]/length;
		}
		return cnt;
	}

}