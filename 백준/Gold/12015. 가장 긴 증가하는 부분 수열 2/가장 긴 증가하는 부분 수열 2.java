import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] LIS;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		LIS = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = arr[0];
		
		int lengthOfLIS = 1;
		
		for(int i = 1; i < N; i++) {
			
			int key = arr[i];
			if(LIS[lengthOfLIS -1 ] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
			}else {
				int lo = 0;
				int hi = lengthOfLIS;
				
				while(lo < hi) {
					int mid = (lo + hi) / 2;
					
					if(LIS[mid] < key) {
						lo = mid + 1;
					}else {
						hi = mid;
					}
				}
				
				LIS[lo] = key;
			}
		}
		
		System.out.println(lengthOfLIS);
	}
	

}