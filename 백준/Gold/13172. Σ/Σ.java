import java.util.*;
import java.io.*;

public class Main {
	static final int P = 1_000_000_007;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine());
		
		//분모, 분자
		long N = 1, S = 0;
		//기댓값 합 구하기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			//각 분모와 분자를 통분하여 계산
			S = s*N + S*n;
			N *= n;
			//모듈러 산술로 인하여 나머지 계산
			S %= P;
			N %= P;
		}
		
		//기약분수일때
		if(S % N != 0) {
			System.out.println((search(N, P - 2) * S) % P);
		}else {//기약분수가 아닐때
			System.out.println(S / N);
		}

	}
	//페르마 소정리, 모듈러 산술을 이용한 역원의 값 구하기
	public static long search(long N, int idx) {
		if(idx == 1) {
			return N;
		}
		long tmp = search(N, idx/2);
		if(idx % 2 == 1) {
			return tmp * tmp % P * N % P;
		}else {
			return tmp * tmp % P;
		}
	}

}