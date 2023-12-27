import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); //양이 먹는 사료 양
		int b = Integer.parseInt(st.nextToken()); //염소가 먹는 사료 양
		int n = Integer.parseInt(st.nextToken()); //양 + 염소(A + B)
		int w = Integer.parseInt(st.nextToken()); //전체 사료양(A*a + B*b)

		int cnt = 0;
		int A = 0;//양의 수
		int B = 0;//염소의 수

		for(int i = 1; i < n; i++) {
			if(i*a + (n - i)*b == w) {
				cnt++;					
				A = i;
				B = n - i;
			}
		}
		if(cnt == 1) {
			System.out.println(A + " " + B);
		}else {
			System.out.println(-1);
		}

	}

}