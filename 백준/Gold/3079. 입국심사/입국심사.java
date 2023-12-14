import java.util.*;
import java.io.*;

public class Main {
	static long N,M,max;
	static long[] arr;
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		arr = new long[(int)N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		
		solve();
		
		System.out.println(result);
		
	}
	public static void solve() {
		long low = 0;
		long high = M*max;
		
		while(low<=high) {
			long mid = (low+high)/2;
			long sum = 0;
			
			for(long idx : arr) {
				long cnt = mid/idx;
				
				if(sum >= M) {
					break;
				}
				sum+=cnt;
			}
			if(sum >= M) {
				high = mid - 1;
				result = Math.min(mid, result);
			}
			else {
				low = mid + 1;
			}
		}
	}

}