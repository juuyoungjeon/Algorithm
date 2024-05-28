import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static Integer[] LISdp;
	static Integer[] LDSdp;
	static int N;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		LISdp = new Integer[N];
		LDSdp = new Integer[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		
		ans = -1;
		for(int i = 0; i < N; i++) {
			ans = Math.max(LISdp[i] + LDSdp[i], ans);
		}
		System.out.println(ans - 1);
	}
	
	public static int LIS(int N) {
		if(LISdp[N] == null) {
			LISdp[N] = 1;
			
			for(int i = N - 1; i >= 0; i--) {
				if(arr[i] < arr[N]) {
					LISdp[N] = Math.max(LISdp[N], LIS(i) + 1);
				}
			}
		}
		return LISdp[N];
	}

	public static int LDS(int N) {
		if(LDSdp[N] == null) {
			LDSdp[N] = 1;
			
			for(int i = N + 1; i < LDSdp.length; i++) {
				if(arr[i] < arr[N]) {
					LDSdp[N] = Math.max(LDSdp[N], LDS(i) + 1);
				}
			}
		}
		return LDSdp[N];
	}
}