import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] same;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[20000 + 5];
		same = new boolean[20000 + 5];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 1;
		for(int i = 1; i <= N; i++) {
			if(same[i]) continue;
			ans = LCM(ans, checkCycle(i));
		}
		
		System.out.println(ans);
	}

	private static int LCM(int A, int B) {
		// TODO Auto-generated method stub
		return A / GCD(A,B) * B;
	}

	private static int GCD(int B, int A) {
		// TODO Auto-generated method stub
		int C;
		while(A != 0) {
			C = B % A;
			B = A;
			A = C;
		}
		return B;
	}

	private static int checkCycle(int start) {
		int cnt = 1;
		int next = arr[start];
		
		while(true) {
			if(start == next) {
				return cnt;
			}
			
			same[next] = true;
			
			next = arr[next];
			cnt++;
		}
	}

}