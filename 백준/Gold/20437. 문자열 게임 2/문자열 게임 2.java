import java.util.*;
import java.io.*;

public class Main {
	static int T, K;
	static char[] arr;
	static int[] alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String s = br.readLine();
			K = Integer.parseInt(br.readLine());
			
			if(K == 1) {
				sb.append("1 1").append("\n");
				continue;
			}
			
			alpha = new int[26];
			
			for(int i = 0; i < s.length(); i++) {
				alpha[s.charAt(i) - 'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = -1;
			for(int i = 0; i < s.length(); i++) {
				if(alpha[s.charAt(i) - 'a'] < K) continue;
				
				int cnt = 1;
				for(int j = i + 1; j < s.length(); j++) {
					if(s.charAt(i) == s.charAt(j)) cnt++;
					if(cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			if(min == Integer.MAX_VALUE || max == -1) {				
				sb.append("-1");
			}
			else {
				sb.append(min).append(" ").append(max);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}