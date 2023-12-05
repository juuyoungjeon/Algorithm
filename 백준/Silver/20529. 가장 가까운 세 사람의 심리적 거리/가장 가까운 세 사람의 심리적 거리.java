import java.util.*;
import java.io.*;

public class Main {
	static int T, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			if(N > 32) {
				System.out.println(0);
				continue;
			}
			
			String[] MBTI = new String[N];
			
			for(int i = 0; i < N; i++) {
				MBTI[i] = st.nextToken();
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int j = 0; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					for(int l = k+1; l < N; l++) {
						int cnt = 0;
						for(int m = 0; m < 4; m++) {
							cnt += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
							cnt += MBTI[j].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
							cnt += MBTI[k].charAt(m) != MBTI[l].charAt(m) ? 1 : 0;
							
						}
						
						min = Math.min(cnt, min);
						if(min == 0) break;
					}
				}
			}
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}

}