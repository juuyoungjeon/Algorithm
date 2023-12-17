import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 2;
		for(int i = 1; i < N + 1; i++) {
			for(int j = N; j > i + 1; j--) {
				if(arr[i] + arr[i + 1] > arr[j]) {
					ans = Math.max(ans, j - i + 1);
				}
				
			}
		}

		if(N == 1) ans = 1;
		System.out.println(ans);
		

	}

}