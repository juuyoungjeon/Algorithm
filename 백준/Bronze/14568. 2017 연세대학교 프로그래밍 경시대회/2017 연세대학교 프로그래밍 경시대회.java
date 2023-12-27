import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//A 택희, B 영훈, C 남규
		//C = B + 2
		//A 짝수
		
		int cnt = 0;
		
		for(int i = 1; i < N; i++) {
			for(int j = i + 2; j < N; j++) {
				
				int C = j;
				int B = i;
				int A = N - (i + j);
				
				if(A % 2 == 0 && A + B + C == N && A > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}