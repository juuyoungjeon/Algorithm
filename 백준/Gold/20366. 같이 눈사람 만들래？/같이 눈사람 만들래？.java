import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				int snowMan1 = arr[i] + arr[j];
				int s = 0;
				int e = N - 1;
				
				while(s < e) {
					if(s == i || s == j) {
						s++;
						continue;
					}
					if(e == i || e == j) {
						e--;
						continue;
					}
					
					int snowMan2 = arr[s] + arr[e];
					min = Math.min(min, Math.abs(snowMan1 - snowMan2));
					
					if(snowMan1 > snowMan2) {
						s++;
					}else if(snowMan1 < snowMan2) {
						e--;
					}else {
						System.out.println(0);
						return;
					}
				}
			}
		}
		System.out.println(min);
		
	}

}