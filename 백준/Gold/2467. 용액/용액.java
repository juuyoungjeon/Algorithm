import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int s = 0, e = N-1;
		int ml = 0, mr = 0;
		long min = Long.MAX_VALUE;
		while(s<e) {
			long sum = arr[s] + arr[e];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ml = s; mr = e;
			}
			if(sum >= 0) {
				e--;
			}else {
				s++;
			}
		}
		
		System.out.print(arr[ml] + " " + arr[mr]);
	}
	

}