import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] x,y;
	static long sumX, sumY;
	static long ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
//		N = Integer.parseInt(br.readLine());
		N = sc.nextInt();
		
		x = new int[N];
		y = new int[N];
		
		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			x[i] = Integer.parseInt(st.nextToken());
//			y[i] = Integer.parseInt(st.nextToken());
			
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		int a = x[(N-1)/2];
		int b = y[(N-1)/2];
		
		for(int i = 0; i < N; i++) {
			ans += Math.abs(a - x[i]) + Math.abs(b - y[i]);
		}
		
		System.out.println(ans);
		

	}

}