import java.util.*;
import java.io.*;

public class Main {
	static long a, d;
	static long q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		
		q = Long.parseLong(br.readLine());
		
		for(long i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			
			if(type == 1) {
				long Al = a + (l-1)*d;
				long An = a + (r-1)*d;
				long sum = ((Al+An)*(r-l+1)/2);
				sb.append(sum).append("\n");
			}else {
				long Al = a + (l-1)*d;
				long ans = 0;
				if(l==r) {
					sb.append(Al).append("\n");
				}
				else {					
					for(long j = 0; j < r-l+1; j++) {
						long b = Al + d;
						ans = GCD(Al, b);
					}
					sb.append(ans).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	public static long GCD(long A, long B) {
		if(B==0) return A;
        while (true){
            if(A%B==0) break;
            long tmp = B;
            B=A%B;
            A=tmp;
        }
        return B;
	}

}