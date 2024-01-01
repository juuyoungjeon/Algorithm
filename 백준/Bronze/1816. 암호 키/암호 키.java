import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			long a = Long.parseLong(br.readLine());
			for(int j = 2; j < 1_000_001; j++) {
				if(a % j == 0) {
					sb.append("NO").append("\n");
					break;
				}
				if(j == 1_000_000) {
					sb.append("YES").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}