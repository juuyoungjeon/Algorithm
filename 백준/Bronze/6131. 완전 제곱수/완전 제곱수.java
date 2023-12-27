import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int A, B;
		
		for(int i = 1; i < 501; i++) {
			B = i;
			A = (int) Math.sqrt((B * B) + N);
			
			if(A * A == B * B + N) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}