import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int G = Integer.parseInt(br.readLine());
		//G = 현재 몸무게의 제곱 - 성원이가 기억하고 있던 몸무게 제곰
		
		long a = 2;//현재
		long b = 1;//기억
		boolean check = false;
		while(b < a && a < 100_000) {
			if(a*a - b*b == G) {
				sb.append(a).append("\n");
				check = true;
			}
			
			if(a*a - b*b > G) {
				b++;
			}else {
				a++;
			}
		}
		
		if(check) {
			System.out.println(sb);
		}else {
			System.out.println("-1");
		}
		
	}

}