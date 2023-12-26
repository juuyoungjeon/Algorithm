import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxDp[0] = minDp[0] = a;
				maxDp[1] = minDp[1] = b;
				maxDp[2] = minDp[2] = c;
			}else {
				int beforeMaxDp_0 = maxDp[0];
				int beforeMaxDp_2 = maxDp[2];
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
				maxDp[1] = Math.max(Math.max(beforeMaxDp_0, maxDp[1]), beforeMaxDp_2) + b;
				
				int beforeMinDp_0 = minDp[0];
				int beforeMinDp_2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + a;
				minDp[2] = Math.min(minDp[1], minDp[2]) + c;
				minDp[1] = Math.min(Math.min(beforeMinDp_0, minDp[1]), beforeMinDp_2) + b;
			}
		}
		
		System.out.print(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " ");
		System.out.print(Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
	}

}