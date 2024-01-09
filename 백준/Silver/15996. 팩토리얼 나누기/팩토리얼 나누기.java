import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		
		long X = A;
		long cnt = 0;
		while(X <= N) {
			cnt += N/X;
			X *= A;
		}
		
		System.out.println(cnt);
	}

}