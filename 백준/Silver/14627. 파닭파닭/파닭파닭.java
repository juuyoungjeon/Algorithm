import java.util.*;
import java.io.*;

public class Main {
	static int S, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		arr = new int[S];
		for(int i = 0; i < S; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		long s = 1;
		long e = arr[S-1];
		
		while(s<=e) {
			long mid = (s+e)/2;
			int cnt = 0;
			for(int i = 0; i < S; i++) {
				cnt += arr[i] / mid;
			}
			if(cnt >= C) {
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		
		
		System.out.println(sum - (e*C));
	}

}