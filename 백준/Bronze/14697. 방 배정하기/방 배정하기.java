import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int ans = 0;

		if(N % A == 0 || N % B == 0 || N % C == 0) {
			ans = 1;
		}else {
			for(int i = 0; i < N/A; i++) {
				for(int j = 0; j < N/B; j++) {
					for(int k = 0; k < N/C; k++) {
						if(A*i + B*j + C*k == N) {
							ans = 1;
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

}