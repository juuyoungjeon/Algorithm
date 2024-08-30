import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] S;
	static ArrayList<Integer> list = new ArrayList<>();
	static int odd;
	static int max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		S = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		while(e < N) {
			if(odd < K) {//홀수 갯수가 K보다 적을때
				if(S[e] % 2 == 1) {
					odd++;
				}
				e++;
				max = Math.max(max, e-s-odd);
			}else if(S[e] % 2 == 0) {//홀수 갯수가 K개 이상이면서, 지금 S[e]가 짝수
				e++;
				max = Math.max(max, e-s-odd);
			}else {//홀수 갯수가 K개 이상이면서, 지금 S[e]가 홀수
				if(S[s] % 2 == 1) {
					odd--;
				}
				s++;
			}
		}
		System.out.println(max);
	}

}