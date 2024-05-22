import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static long res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long s = 0;
		long e = (long)arr[0]*(long)M;
		while(s<=e) {
			long cnt = 0;
			long mid = (s+e)/2;
			for(int i = 0; i < N; i++) {
				cnt += mid/(long)arr[i];
			}
			if(cnt >= M) {
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		System.out.println(s);
	}

}