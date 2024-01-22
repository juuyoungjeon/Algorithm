import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] p,a,b,c,d;
	static int[][] map;
	static boolean[] visited;
	static int[] prefixSum;//방문하지 않았을때
	static int[] prefixSum2;//방문 했을때
	static int[] prefixSum3;//최종
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		p = new int[N + 1];
		a = new int[N + 1];
		b = new int[N + 1];
		c = new int[N + 1];
		d = new int[N + 1];
		
		for(int i = 1; i <= M; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 2; i <= M; i++) {
			int prev = p[i - 1];
			int next = p[i];
			if(prev > next) {
				int tmp = prev;
				prev = next;
				next = tmp;
			}
			d[prev]++;
			d[next]--;
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0; 
		long psum = 0;

		for(int i = 1; i < N; i++) {
			psum += d[i];
			ans += Math.min(psum*a[i], psum*b[i] + c[i]);
		}
		System.out.println(ans);
	}
	

}